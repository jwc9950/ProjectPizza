package com.mycomapny.board.repository;




import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycomapny.board.dto.BoardFile;


@Repository
public class BoardFileRepositoryImpl implements BoardFileRepository  {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(BoardFile boardFile) {
		return  sqlSession.insert("com.mycomapny.board.BoardFileMapper.insert",boardFile);
		
	}

	@Override
	public int update(BoardFile boardFile) {
		
		return  sqlSession.update("com.mycomapny.board.BoardFileMapper.update",boardFile);
	}

	@Override
	public int delete(int bfnum) {
	
		return  sqlSession.delete("com.mycomapny.board.BoardFileMapper.delete",bfnum);
	}

	@Override
	public BoardFile selectOne(int bfnum) {
		
		return  sqlSession.selectOne("com.mycomapny.board.BoardFileMapper.selectOne",bfnum);
	}

	@Override
	public List<BoardFile> selectList(int bnum) {
		
		return sqlSession.selectList("com.mycomapny.board.BoardFileMapper.selectList",bnum);
	}



}
