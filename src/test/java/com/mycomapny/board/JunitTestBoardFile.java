package com.mycomapny.board;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mycomapny.board.dto.BoardFile;
import com.mycomapny.board.repository.BoardFileRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})

public class JunitTestBoardFile {

	@Autowired
	private BoardFileRepository boardFileRepository;
	
	@Test
	public void testInsert() {
		BoardFile boardFile = new BoardFile();
		boardFile.setBnum(1);
		boardFile.setFilename("b.png");
		int cnt = boardFileRepository.insert(boardFile);
		System.out.println(cnt+"건 인서트");
	}

	@Test
	public void testUpdate() {
		BoardFile boardFile = new BoardFile();
		boardFile.setBfnum(1);
		boardFile.setFilename("c.png");
		int cnt = boardFileRepository.update(boardFile);
		System.out.println(cnt+"건 업데이트");
	}

	@Test
	public void testDelete() {
		int cnt = boardFileRepository.delete(1);
		System.out.println(cnt+"건삭제");
		
	}

	@Test
	public void testSelectOne() {
		BoardFile boardFile =boardFileRepository.selectOne(1);
		System.out.println(boardFile);
		assertNotNull(boardFile);
	}

	@Test
	public void testSelectList() {
		List<BoardFile> bflist= boardFileRepository.selectList(1);
		System.out.println(bflist);
		assertNotEquals(0, bflist.size());//사이즈가 0과 같지 않으면 성공
	}

}
