package com.mycomapny.board.service;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
//	//rootcontext의 정의된 bean주입
//	@Autowired
//	private String savedir; //rootcontext에 있는 빈객체를 여기로 오토와이어드해서  id인 savedir을 사용할수있다.// 저장경로주소를 적기보다 idf를 사용한다.
	
	
	//Stirng boot 방식  application.properies의 환경설정값
	@Value("{file.savedir}")
	private String savedir;
	
	
	@Override
	public String fileUpload(MultipartFile file) throws Exception {
		//파일을 업로드하고 파일명을 리턴
		//getOriginalFilename 진짜 파일 이름을 가지고와서 변수originFilename에 저장
		String  originFilename= file.getOriginalFilename();
		
		if(originFilename.equals("")) return"";// 파일이름이 없다면 리턴
		
		//파일이름이 겹치지 않도록 시스템날짜를 붙이기
		String filename =System.currentTimeMillis()+"_"+originFilename;
		
		//파일을 만들어서 올리기
		//여기에 원래 파일주소를 적었으나 빈객체를 오토와이드하여 불러와서 id를 변수로 적은것
		file.transferTo(new File(savedir,filename));//import java.io.File;이것으로 임포트
		
		
		return null;
	}

}
