package com.mycomapny.board.repository;

import java.util.List;

import com.mycomapny.board.dto.BoardFile;

public interface BoardFileRepository {

	 int insert(BoardFile boardFile); 
	 int update(BoardFile boardFile);
	 int delete(int bfnum);
	 BoardFile selectOne(int bfnum);
	 List<BoardFile> selectList(int bnum);
}
