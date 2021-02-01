package bit.sdo.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import bit.sdo.domain.Board;
import bit.sdo.domain.BoardListResult;

public interface BoardService {
	BoardListResult getBoardListResult(int cp, int ps);
	Board getContent(long seq);
	
	void write(Board board, ArrayList<MultipartFile> files);
	void edit(Board board);
	void remove(long seq);
	
	void saveStore( MultipartFile file, long seq);
}
