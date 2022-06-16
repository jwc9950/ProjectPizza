package com.mycomapny.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycomapny.board.dto.BoardFile;
import com.mycomapny.board.repository.BoardFileRepository;


@Service
public class BoardFileServiceImpl implements BoardFileService {

	@Autowired
	private BoardFileRepository boardFileRepository;
	
	@Override
	public List<BoardFile> selectList(int bnum) {
		return boardFileRepository.selectList(bnum);
		
	}

}
