package bit.sdo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import bit.sdo.domain.BdFile;
import bit.sdo.domain.Board;
import bit.sdo.domain.BoardContentResult;
import bit.sdo.domain.BoardListResult;
import bit.sdo.domain.BoardVo;
import bit.sdo.mapper.BoardMapper;
import lombok.extern.log4j.Log4j;
import bit.sdo.filesetting.Path;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;
	@Override
	public BoardListResult getBoardListResult(int cp, int ps) {
		BoardVo boardVo = new BoardVo(cp, ps);
		List<Board> list = boardMapper.list(boardVo);
		long totalCount = boardMapper.getTotalCount();
		return new BoardListResult(cp, totalCount, ps, list);
	}

	@Override
	public BoardContentResult getContent(long seq) {
		boardMapper.setCnt(seq);
		Board board = boardMapper.getContent(seq);
		List<BdFile> list = boardMapper.getFileInfo(seq);
		return new BoardContentResult(board, list);
	}

	@Override
	public void write(Board board, ArrayList<MultipartFile> files) {
		long maxRef = boardMapper.getMaxRef();
		board.setRefer(maxRef + 1);
		board.setCnt(0);board.setLev(0);board.setPlace(0);
		
		boardMapper.insert(board);
		long b_seq = board.getSeq();
		
		log.info("####"+ b_seq);
		
		for(MultipartFile file: files) {
    		String ofname = file.getOriginalFilename();
    		if(ofname != null) ofname = ofname.trim();
    		if(ofname.length() != 0) {
    			saveStore(file, b_seq);	
    			// 다중파일 입력을 위해서 자식테이블을 만들었기 때문에  글의 seq 값을 어떻게 구해서 매칭시키나? max(seq) 동기화? 트랜잭션? 프로시져?
    		}
    	}
	}

	@Override
	public void edit(Board board) {
		boardMapper.update(board);
	}

	@Override
	public void remove(long seq) {
		boardMapper.delete(seq);
	}

	@Override
	public void saveStore(MultipartFile file, long b_seq) {
		String ofname = file.getOriginalFilename();
		int idx = ofname.lastIndexOf(".");
		String ofheader = ofname.substring(0, idx);
		String ext = ofname.substring(idx);
		long ms = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		sb.append(ofheader);
		sb.append("_");
		sb.append(ms);
		sb.append(ext);
		String fname = sb.toString();
		long fsize = file.getSize();
		
		
		BdFile bdFile = new BdFile(-1, b_seq ,fname,ofname,fsize);
		boardMapper.insertFileInfo(bdFile);
		
		boolean flag = writeFile(file, fname);
		if(flag) {
			log.info("#업로드 성공");
		}else {
			log.info("#업로드 실패");
		}
	}

	private boolean writeFile(MultipartFile file, String fname) {
		File rDir = new File(Path.FILE_STORE);
		if(!rDir.exists()) rDir.mkdirs();
		
		FileOutputStream fos = null;
		try {
			byte data[] = file.getBytes();
			fos = new FileOutputStream(Path.FILE_STORE+fname);
			fos.write(data);
			fos.flush();
			
			return true;
		}catch(IOException ie) {
			return false;
		}finally {
			try {
				if(fos != null) fos.close();
			}catch(IOException ie) {}
		}
	}

}
