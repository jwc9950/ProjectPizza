package com.mycomapny.board.repository;

import java.util.List;

import com.mycomapny.board.dto.Board;
import com.mycomapny.board.dto.Page;


public interface BoardRepository {

	int insert(Board board);
	int update(Board board);
	int delete(int bnum);
	Board selectOne(int bnum);
	List<Board> selectList(Page page);  //기존에 map에 넣었던것을 편의를 위해 page dto를 만들고 받아옴
	
	//전체 게시물수 구하기
	int selectTotalCnt(Page page);
	
	//조회수+1씩증가
	int update_readcnt(int bnum);
	
	//좋아요+1씩증가
	int update_LikeCnt(int bnum);
	
	//싫어요 +1씩증가
	int update_disLikecnt(int bnum);
	
	
	//삭제시 삭제여부 y로 변경
	int updateRemoveyn(int bnum);
	
	
}
