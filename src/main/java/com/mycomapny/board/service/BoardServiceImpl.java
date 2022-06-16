package com.mycomapny.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mycomapny.board.advice.ErrorCode;
import com.mycomapny.board.dto.Board;
import com.mycomapny.board.dto.BoardFile;
import com.mycomapny.board.dto.Page;
import com.mycomapny.board.repository.BoardFileRepository;
import com.mycomapny.board.repository.BoardRepository;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private BoardFileRepository boardFileRepository;
	
	
	@Override
	public List<Board> selectList(Page page) {
		
		//페이징처리 
		//1.시작 끝번호구해야함
		//시작번호=(현재페이지-1)*한페이지의게시물수 + 1
		//끝번호 = 시작번호 + 한페이지의 게시물수 -1
		//현재페이지
		int curPage = page.getCurPage();
		//한페이지당 게시물수
		int perPage = page.getPerPage();
		//시작번호 계산
		int startNum =(curPage-1)*perPage+1;
		//끝번호 
		int entNum =startNum+perPage-1;
		//페이지블럭의수
		int perBlock = page.getPerBlock();
		
		//전체 게시물 수
		int totalCnt=boardRepository.selectTotalCnt(page);
		//전체페이지수=전체게시물수/한페이지의게시물수 나머지가 있을때 +1
		int totPage = totalCnt/perPage;
		if(totalCnt%perPage!=0) totPage++;
		
		//시작페이지
				int startPage=curPage-((curPage-1)% perBlock);
				//끝페이지
				int entPage=startPage+(perBlock-1);
				//페이지블럭의수
				
		
		if(totPage<entPage) entPage=totPage;
		
		
		
	
		
	
		
		
		
		//시작,끝번호를 page dto에 넣기
		page.setStartNum(startNum);
		page.setEntNum(entNum);
		
		
		//2. 시작페이지 끝페이지 구하기
		//시작페이지=현재페이지-((현재페이지-1)%페이지블럭의수)
		//끝페이지=시작페이지+(페이지블럭의수-1)
		
		//시작페이지
//		int startPage=curPage-((curPage-1)% perBlock);
//		//끝페이지
//		int entPage=startPage+(perBlock-1);
		
		page.setStartPage(startPage);
		page.setEntPage(entPage);
		page.setTotPage(totPage);
		
		//전체페이지수 계산
		//전체페이지수=전체게시물수/한페이지의게시물수
		
		
		
		
		return boardRepository.selectList(page);
	}


	@Override
	public Board selectOne(int bnum) {
		
		return boardRepository.selectOne(bnum) ;
	}


	@Transactional//트렌젝션관리//커밋롤백
	@Override
	public ErrorCode insert(Board board) throws Exception {
		//게시물
		
		//insert시 bnum세팅
		boardRepository.insert(board);
		
		//2)게시물 파일들업로드후 저장.  밑에 공통 된것을 메소드로 묶어놓고 여기에서 사용
		boardFilesSave(board);
		
		
		//이부부이 공통적으로 사용해야해서 아래에서 bordFilesSave(board)로 묶어 놨음. 이것을 사용하면 됨
//		//게시물 파일을 저장
//		List<MultipartFile> files = board.getFiles();
//		
//		for(MultipartFile file :files){
//		 
//		String filename =fileService.fileUpload(file);
//		
//		//게시물 파일 객체 생성
//		BoardFile boardFile = new BoardFile();
//		boardFile.setBnum(board.getBnum());
//		boardFile.setFilename(filename);
//		if(filename.equals("")) continue; 
//		
//		
//		boardFileRepository.insert(boardFile);
//		}
		
		return ErrorCode.SUCCESS_ADD;
		
	
		
		
	}


	@Override
	public int update_readcnt(int bnum) {
		
		return boardRepository.update_readcnt(bnum);
	}

	@Transactional
	@Override
	public ErrorCode update(Board board, List<Integer> removeFiles) throws Exception {
		//1) 게시물 수정
		boardRepository.update(board);
		//2) 게시물 파일 db삭제
		// 	if(removeFiles!=null) 이유 : 파일을 선택안했을때 에러가 나서
		if(removeFiles!=null) {
			for( int bfnum: removeFiles) {
				boardFileRepository.delete(bfnum);
			}
			
		}
		//3)게시물 파일들 업로드 후 저장
				boardFilesSave(board);

		return ErrorCode.SUCCESS_MODIFY;
	}

	
	//(Board board) 공통된 board를 메소드 묶으려는것
	private void boardFilesSave(Board board) throws Exception {
		//게시물 파일을 저장
		List<MultipartFile> files = board.getFiles();
		
		for(MultipartFile file :files){
		 
		String filename =fileService.fileUpload(file);
		
		//게시물 파일 객체 생성
		BoardFile boardFile = new BoardFile();
		boardFile.setBnum(board.getBnum());
		boardFile.setFilename(filename);
		if(filename.equals("")) continue; 
		
		
		boardFileRepository.insert(boardFile);
		}
	}


	


	@Override
	public ErrorCode updateRemoveyn(int bnum) {
		// TODO Auto-generated method stub
		 boardRepository.updateRemoveyn(bnum);
		 return ErrorCode.SUCCESS_REMOVE;
	}


	@Override
	public int update_Likecnt(int bnum) {
		// TODO Auto-generated method stub
		return boardRepository.update_LikeCnt(bnum);
	}


	@Override
	public int update_disLikecnt(int bnum) {
		// TODO Auto-generated method stub
		return boardRepository.update_disLikecnt(bnum);
	}



}
