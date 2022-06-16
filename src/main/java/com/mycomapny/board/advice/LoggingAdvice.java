package com.mycomapny.board.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//aop구현//모든 logging을 여기서 모아서 정리하려는 의도
@Component  //스프링이 자동객체 생성
@Aspect
public class LoggingAdvice {

	//매개변수를 자동으로 출력하는 의도
	//Joinpoint 클래스
	//execution:advice를 적용할 메서드를 명시함
	//구현 메소드
	//before(JoinPoint joinPoint) 
	//afterReturning(JoinPoint joinPoint , Object ret)
	
	
	
	@Before("execution(* com.mycomapny.board.controller.*.*(..))")//반환형.패키지명.클래스명(*사용가능).(메소드명)하고싶은거(..)  ..은 매개변수//포인트컷
	//해석 :controller안에 있는 모든내용안에 모든 메소드  
	public void beforeLog(JoinPoint jp) {
		//joinPoint:advice를 적용가능한 지점을 의미한다.
		//toShortString, getSignature: 호출되는 메서드에 대한 정보를 구한다=> //공통 기능이 적용되는 메서드가 어떤 메서드인지 출력하기 위해 메서드명을 얻어옴
		//getArgs :메소드를 통해서 타겟 메소드의 argument를 받아 올 수 있다.

		
		System.out.println("매개변수:"+jp.getSignature().toShortString()+Arrays.toString(jp.getArgs()));
	}
	
	//리턴값을 출력할때는 쓰는 매개변수
	//Object obj :리턴 오브젝트
	//두개이상일때 pointcut사용
	@AfterReturning(pointcut = "execution(* com.mycomapny.board.repository.*.*(..))",returning = "obj")
	public void afterLog(JoinPoint jp, Object obj) {//returning = "obj"으로 오브젝트에 저장
		
		if(obj !=null) { //리턴값이 나오는것 자체가 null이 아니고 , null이 obj와 일치한다면 굳이 이것을 할필요가없다.

			System.out.println("-------------------------");
			System.out.println("리턴값:"+jp.getSignature().toShortString());
			System.out.println(obj);	
			System.out.println("-------------------------");
		}	
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	//메소드 실행 소요시간 체크
	//@Around("execution(* com.mycomapny.board.service.BoardServiceImpl.insert(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//시작시간
		long startTime =System.currentTimeMillis(); //시스템의 사간을 1/1000초 단위로 반환
		System.out.println(pjp.getSignature().toShortString()); //실행되는 메소드의 이름
		
		//result: 실행메소드가 반환하는 값
		Object result= pjp.proceed();//실행메소드 객체
		
		
		//끝시간
		long endTime =System.currentTimeMillis(); 
		
		
		//소요시간 (끝시간 - 시작시간)
		System.out.println("소요시간:"+(endTime-startTime));
		//실행메소드가 반환하는값을 호출한 메소드에 전달
		return result;
	}
	
	
	
	
}
