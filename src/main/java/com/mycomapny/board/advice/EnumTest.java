package com.mycomapny.board.advice;

public class EnumTest {
	//열거형 테스트
	public static void main(String[] args) {
	System.out.println(ErrorCode.SUCCESS_ADD);	
	System.out.println(ErrorCode.SUCCESS_ADD.getCode());	
	System.out.println(ErrorCode.SUCCESS_ADD.getMsg());	
	
	System.out.println(ErrorCode.SUCCESS_REMOVE.getMsg());	
	}

}
