package com.mycomapny.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mycomapny.board.dto.Reply;
import com.mycomapny.board.repository.ReplyRepository;
import com.sun.tools.javac.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTestReply {

	@Autowired
	private ReplyRepository replyRepository;
	@Test
	public void testInsert() {
		Reply reply = new Reply();
		reply.setBnum(1);
		reply.setEmail("java@gmail.com");
		reply.setIp("190,232,23,2");
		reply.setContent("댓글1");
		reply.setRestep(1);
		reply.setRelevel(1);
		int cnt = replyRepository.insert(reply);
		System.out.println(cnt+"건 인서트");
	}

	@Test
	public void testUpdate() {
		Reply reply = new Reply();
		reply.setRnum(8);
		reply.setContent("댓글수정1");
		reply.setIp("200,232,23,1");

		int cnt = replyRepository.update(reply);
		System.out.println(cnt+"건수정");
		
	}

	@Test
	public void testDelete() {
		int cnt = replyRepository.delete(7);
		System.out.println(cnt+"건삭제");

	}

	@Test
	public void testSelectOne() {
		Reply reply= replyRepository.selectOne(7);
		System.out.println(reply);
	}

//	@Test
//	public void testSelectList() {
//		List<Reply> rlist = replyRepository.selectList(7);
//		System.out.println(rlist);
//		assertNotEquals(0, rlist.size()); //사이즈가 0과 같지 않으면 성공
//	}

}
