package com.mycomapny.board.service;

import java.util.List;

import com.mycomapny.board.advice.ErrorCode;
import com.mycomapny.board.dto.Board;
import com.mycomapny.board.dto.Page;

public interface BoardService {

	List<Board> selectList(Page page);
	
	Board selectOne(int bnum);
	
	//열거형 반환
	ErrorCode insert(Board board) throws Exception;
	//열거형 반환
	ErrorCode update(Board board, List<Integer> removeFiles) throws Exception; //컨트롤에서  파일 삭제 하는부분에서 가지고 옴
	
	ErrorCode updateRemoveyn(int bnum);
	

	//조회수1
	int update_readcnt(int bnum);
	
	//좋아요
	int update_Likecnt(int bnum);
	
	//싫어요
	int update_disLikecnt(int bnum);
	
	
	
}
