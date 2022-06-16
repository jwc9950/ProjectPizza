package com.mycomapny.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycomapny.board.dto.Reply;
import com.mycomapny.board.service.ReplyService;

@RequestMapping("reply")
@RestController   // RestController은 모든 @ResponseBody을 한꺼번에 모아줘서 밑에 적을 필요없다.//그렇지 않을땐 ResponseBody를붙여야함
public class ReplyController {
	@Autowired
	ReplyService replyService; 
	
	
	
	@PostMapping("/")
	public String add(@RequestBody Reply reply, HttpServletRequest request) {
		reply.setIp(request.getRemoteAddr());
		replyService.insert(reply);
		return "add success";
	}
	
	//댓글의 리스트

	@GetMapping("list/{bnum}")
	//@PathVariable bnum을 읽어옴
	public List<Reply> list(@PathVariable int bnum) {
		List<Reply> rlist = replyService.selectList(bnum);
		return rlist;
	}
	

	@DeleteMapping("{rnum}")
	public String remove(@PathVariable int rnum) {
		replyService.delete(rnum);
		return "remove ok";
	}
	
	//댓글을 수정
	
	@PutMapping("/")
	public String modify(@RequestBody Reply reply,HttpServletRequest request) {
		reply.setIp(request.getRemoteAddr());
		
		replyService.update(reply);
		return "modify ok";
	}
	
	
}
