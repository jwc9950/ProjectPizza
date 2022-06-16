package com.mycomapny.board.service;

import java.util.List;

import com.mycomapny.board.dto.Reply;

public interface ReplyService {

	int insert(Reply reply);

	List<Reply> selectList(int bnum);
	
	int delete(int rnum);

	int update(Reply reply);
	
	
	
}
