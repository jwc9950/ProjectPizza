package com.mycomapny.board.advice;

import com.sun.net.httpserver.Authenticator.Success;

//c언어 열거형 //상수 필드열거 //열거형이라 세미콜론은 나열후 마지막에
//코드와 메시지 관리
public enum ErrorCode {
	SUCCESS_ADD("0","추가성공"),
	SUCCESS_MODIFY("0", "수정성공"),
	SUCCESS_REMOVE("0","삭제성공");
	
	
	
	private String code;
	private String msg;
	
	//enum의 생성자
	private ErrorCode(String code, String msg) {
		this.code=code;
		this.msg=msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
}
