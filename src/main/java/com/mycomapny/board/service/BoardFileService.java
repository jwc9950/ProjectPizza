package com.mycomapny.board.service;

import java.util.List;


import com.mycomapny.board.dto.BoardFile;

public interface BoardFileService {

		List<BoardFile> selectList(int bnum);
}
