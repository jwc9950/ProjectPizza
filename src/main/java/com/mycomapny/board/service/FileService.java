package com.mycomapny.board.service;

import org.springframework.web.multipart.MultipartFile;

//공통모듈
//파일을 처리해주는곳
public interface FileService    {

	//파일을 업로드하고 파일명을 리턴
	String fileUpload(MultipartFile file) throws Exception;
}
