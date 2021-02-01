package bit.sdo.persistence;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bit.sdo.domain.Board;
import bit.sdo.domain.BoardVo;
import bit.sdo.mapper.BoardMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DaoTests {
	/*@Autowired
	private AddressDao addressDao;
	@Inject
	private AddressDao addressDao;
	@Resource(name="addressDao") 또는 @Resource
	@Resource
	private AddressDao addressDao;
	*/
	/*
	@Test
	public void testList() {
		List<Address> list = addressDao.list();
	    log.info("#list(1): " + list);
	}
	
	@Test
	public void testInsert() {
		Address address = new Address(-1, "홍길동", "서울시", null);
		addressDao.insert(address);
		
		List<Address> list = addressDao.list();
	    log.info("#list(2): " + list);
	}
	
	@Test
	public void testDelete() {
		addressDao.delete(3);
		List<Address> list = addressDao.list();
	    log.info("#list(3): " + list);
	}
	*/
	@Autowired
	private BoardMapper mapper;
	@Test
	public void testMapper() {
		Board board = new Board(-1,"가","나","다","라",null,-1,-1,-1,-1);
//		mapper.insert(board);
//		mapper.getMaxRef();
//		List<Board> list(BoardVo boardVo);
//		mapper.getTotalCount();
//		mapper.setCnt(2);
//		mapper.getContent(2);
//		mapper.delete(2);
		mapper.update(board);
	}
	
}
