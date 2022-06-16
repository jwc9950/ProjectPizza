package com.mycomapny.board.dto;
//페이징처리를 위한dto로 담는방식

public class Page {

	private String findkey; //검색할수있는키
	private String findvalue;//검색값
	
	//페이징처리를 하기위한 필요한것
	private int curPage = 1;//현재페이지(디폴트는 1페이지로)
	private int perPage = 10;//한페이지당 게시물수
	private int perBlock=10; //페이지블럭의수
	
	private int totPage; // 전체페이지수
	private int startNum; //게시줄의 시작번호
	private int entNum; //끝번호
	
	private int startPage;//페이지블럭의 시작페이지
	private int entPage;//페이지블럭의 끝페이지
	
	
	public String getFindkey() {
		return findkey;
	}
	public void setFindkey(String findkey) {
		this.findkey = findkey;
	}
	public String getFindvalue() {
		return findvalue;
	}
	public void setFindvalue(String findvalue) {
		this.findvalue = findvalue;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEntNum() {
		return entNum;
	}
	public void setEntNum(int entNum) {
		this.entNum = entNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEntPage() {
		return entPage;
	}
	public void setEntPage(int entPage) {
		this.entPage = entPage;
	}
	@Override
	public String toString() {
		return "Page [findkey=" + findkey + ", findvalue=" + findvalue + ", curPage=" + curPage + ", perPage=" + perPage
				+ ", perBlock=" + perBlock + ", totPage=" + totPage + ", startNum=" + startNum + ", entNum=" + entNum
				+ ", startPage=" + startPage + ", entPage=" + entPage + "]";
	}
	
	
	

	
}
