package com.mycomapny.board.repository;


import java.util.List;
import java.util.Map;


import com.mycomapny.board.dto.Reply;


public interface ReplyRepository {

	int insert(Reply reply);
	int update(Reply reply);
	int delete(int rnum);
	Reply selectOne(int bnum);
	List<Reply> selectList(int bnum);
	
	/* 글순서 재수정 */
	int updateRestep(Reply reply);
}
