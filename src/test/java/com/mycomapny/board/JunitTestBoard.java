package com.mycomapny.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mycomapny.board.dto.Board;
import com.mycomapny.board.dto.Page;
import com.mycomapny.board.repository.BoardRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTestBoard {

	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setEmail("chldnd11@naver.com");
		board.setSubject("테스트");
		board.setContent("게시물내용");
		board.setIp("192.168.1.100");
		
		int cnt =boardRepository.insert(board);
		System.out.println(cnt+"건추가");
	}

	@Test
	public void testUpdate() {
		Board board = new Board();
		board.setBnum(2);
		board.setEmail("1chldnd11@naver.com");
		board.setSubject("테스트2");
		board.setContent("게시물내용2");
		board.setIp("192.168.1.100");
		
		int cnt =boardRepository.update(board);
		System.out.println(cnt+"건 업데이트");
		

	}

	@Test
	public void testDelete() {
		int cnt = boardRepository.delete(2);
		System.out.println(cnt+"건 삭제");
		assertEquals(1, cnt); //cnt가 1일때 성공
	}

	@Test
	public void testSelectOne() {
		Board board = boardRepository.selectOne(0);
		System.out.println(board);
		assertNotNull(board); //board가 null이 아니면 성공
	}

	@Test
	public void testSelectList() {
		Page page = new Page();
		page.setFindkey("email");
		page.setFindvalue("ddd");
		List<Board> blist=boardRepository.selectList(page);
		System.out.println(blist);
		assertNotEquals(0, blist.size());//blist의 사이즈가 0과 같이 않을때
	}

}
