package com.mycomapny.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycomapny.board.advice.ErrorCode;
import com.mycomapny.board.dto.Board;
import com.mycomapny.board.dto.Page;
import com.mycomapny.board.service.BoardFileService;
import com.mycomapny.board.service.BoardService;


//자동임포트 컨트롤 쉬프트 o
//동기방식
@Controller
@RequestMapping("board") //중복되는 루트를 엮어줌

//세션만들기
//@SessionAttributes("page")//1)/세션에 객체를 담을 변수명
public class BoardController {
	
	@Autowired
	private BoardService boardService; 
	
	@Autowired
	private BoardFileService boardFileService; 
	
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//동기방식
	@GetMapping("/") //get방식post방식 다 상관없이 쓸수있음
	//페이지객체를 생성  2)
	public String listhome(Page page,Model model) {
		
		//SessionAttributes세션에 객체를 할당하기 위한 목적 3)
		model.addAttribute("page", page);
		
		//return을 생략하게 되엇음. 매핑정보와 가야할장소가 같아서
		return "/board/list";
		
		//리스트를 띄울때 로컬호스트/board/board 에가서 리스트를 클릭해야 에러안남
		// 매핑순서가 여기부터라 순서대로 들어가야함
		//board/board 치면 객체가 그때 할당이 됨
		
	}
	//동기방식
	//@ModelAttribute("page"):@SessionAttributes가 있을때는 세션에도 저장되어있음
	@GetMapping("list")  //page dto클래스에서 가지고 온것 //변수에 findkey,findvalue를 파라메터로 가지고옴
	//@ModelAttribute("page")생략도가능 
	public void list(@ModelAttribute("page") Page page, Model model) {
		
		//@ModelAttribute("page") =model.addAttribute("page", page);
		
		//방식1
		//List<Board> blist= boardService.selectList(page);
		model.addAttribute("blist", boardService.selectList(page));  //다른방식으로 더 줄임
		//model.addAttribute("page",page); //서비스에서 페이징처리한것을 계산하여 컨트롤에서 뷰로 보냄
	}
	//동기방식
	@GetMapping("detail")
	public void detail(@RequestParam int bnum, Model model) {
		Board board=boardService.selectOne(bnum);
		//방식2  //게시물
		
		//1)조회수 +1
		boardService.update_readcnt(bnum);
		
	
		//2)게시물 조회
		model.addAttribute(board);
		
		//3)게시물파일들조회
		model.addAttribute("bflist",boardFileService.selectList(bnum));
		
		
		//return을 적을 필요없음 매핑정보와 가야할장소가 같기때문
	}
		
	//동기방식
	//추가페이지이동
	@GetMapping("add")
	public void add() {
		
	}
	//동기방식
	@PostMapping("add")
	//MultipartFile 파일 객체 생성 여러개라 List에
	//List<MultipartFile> files 형성했으나 Board에 저장했음
	//board안에 파일도 담게끔 만들어놓은것음
	//
	//ip객체만들기  1.HttpServletRequest request 2.	board.setIp(request.getRemoteAddr());
	
	public String add(Board board, HttpServletRequest request, RedirectAttributes rattr) throws Exception {
		//클라이언트 ip
		board.setIp(request.getRemoteAddr());
		ErrorCode errorCode= boardService.insert(board);
		
		
		//리스트로이동
		rattr.addFlashAttribute("msg",errorCode.getMsg());
		
		return "redirect:/board/list";
	}
	//동기방식
	//수정폼으로 이동
	@GetMapping("modify")
	
	public void modify(@RequestParam int bnum, Model model) {
	
               //1)게시물 조회
				model.addAttribute("board",boardService.selectOne(bnum));
				
				//2)게시물파일들조회
				model.addAttribute("bflist",boardFileService.selectList(bnum));
				
				//3)파일업로드
	
	}
	//동기방식
	//수정버튼을 클릭했을때
	//removeFiles  modify에서 파일을 삭제시 만들어놓은 name에서 받아온것
	// @RequestParam(required=false)  삭제해야할 파일이 없을경우 에러가 나오는데 required를 false로 적으면 에러 방지. 원래 true임
	//HttpServletRequest request	ip를 가지고 올수 있음
	@PostMapping("modify")
	public String modify(Board board, @RequestParam(required=false) List<Integer> removeFiles,
			HttpServletRequest request,
			RedirectAttributes rattr
			) throws Exception {
		board.setIp(request.getRemoteAddr());
		
		ErrorCode errorCode=boardService.update(board, removeFiles);//서비스 호출
		
		//redirect방식. detadil로이동
		rattr.addFlashAttribute("msg",errorCode.getMsg());//한번만 실행 파라메터
		rattr.addAttribute("bnum",board.getBnum());
		return "redirect:detail";
	}
	//동기방식
	//삭제버튼클릭시
	@GetMapping("remove")
	public String remove(@RequestParam int bnum, RedirectAttributes rattr) {
		ErrorCode errorCode = boardService.updateRemoveyn(bnum);
		//redirect방식 list
		rattr.addFlashAttribute("msg",errorCode.getMsg());
		return "redirect:list";
	}
	
	//비동기방식
	//좋아요
	@ResponseBody
	@PutMapping("like/{bnum}")
	public String likecnt(@PathVariable int bnum) {
		boardService.update_Likecnt(bnum);
		Board board = boardService.selectOne(bnum);
		//좋아요를 문자로 변경후 리턴
		return String.valueOf(board.getLikecnt());
	}
	//비동기방식
	//싫어요
	@ResponseBody
	@PutMapping("dislike/{bnum}")
	public String dislikecnt(@PathVariable int bnum) {
		boardService.update_disLikecnt(bnum);
		Board board = boardService.selectOne(bnum);
		return String.valueOf(board.getDislikecnt());
	}
	
	
	
	
}
