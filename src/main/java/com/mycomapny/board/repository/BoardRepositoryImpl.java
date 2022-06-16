package com.mycomapny.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycomapny.board.dto.Board;
import com.mycomapny.board.dto.Page;



@Repository
public class BoardRepositoryImpl implements BoardRepository {
	
	@Autowired
	private SqlSession sqlSession;

	public int insert(Board board) {
		return sqlSession.insert("com.mycomapny.board.BoardMapper.insert",board);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycomapny.board.BoardMapper.update",board);
	}

	@Override
	public int delete(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.mycomapny.board.BoardMapper.delete",bnum);
	}

	@Override
	public Board selectOne(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.mycomapny.board.BoardMapper.selectOne",bnum);
	}

	
	@Override
	public List<Board> selectList(Page page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.mycomapny.board.BoardMapper.selectList",page);
	}

	@Override
	public int selectTotalCnt(Page page) {
		//전체 게시물수
		return sqlSession.selectOne("com.mycomapny.board.BoardMapper.selectTotalCnt",page);
	}

	@Override
	public int update_readcnt(int bnum) {
		// TODO Auto-generated method stub
		return  sqlSession.update("com.mycomapny.board.BoardMapper.update_readcnt",bnum);
	}

	@Override
	public int updateRemoveyn(int bnum) {
		
		return sqlSession.update("com.mycomapny.board.BoardMapper.updateRemoveyn",bnum);
	}

	@Override
	public int update_LikeCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycomapny.board.BoardMapper.update_LikeCnt",bnum);
	}

	@Override
	public int update_disLikecnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycomapny.board.BoardMapper.update_disLikecnt",bnum);
	}
	
	
}
