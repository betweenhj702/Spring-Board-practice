package bit.sdo.mapper;

import java.util.List;

import bit.sdo.domain.BdFile;
import bit.sdo.domain.Board;
import bit.sdo.domain.BoardVo;

public interface BoardMapper {
	void insert(Board board);
	long getMaxRef();
	List<Board> list(BoardVo boardVo);
	long getTotalCount();
	void setCnt(long seq);
	Board getContent(long seq);
	void delete(long seq);
	void update(Board board);
	//
	void insertFileInfo(BdFile bdFile);
}
