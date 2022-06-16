package com.mycomapny.board.dto;

import oracle.sql.DATE;

public class Reply {

	private int rnum;
	private int bnum; 
	private String email; 
	private String content; 
	private String ip; 
	private int restep;
	private int relevel;
	private DATE modidate;
	private DATE regidate;
	
	public Reply() {
		super();
	}

	public Reply(int rnum, int bnum, String email, String content, String ip, int restep, int relevel, DATE modidate,
			DATE regidate) {
		super();
		this.rnum = rnum;
		this.bnum = bnum;
		this.email = email;
		this.content = content;
		this.ip = ip;
		this.restep = restep;
		this.relevel = relevel;
		this.modidate = modidate;
		this.regidate = regidate;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getRestep() {
		return restep;
	}

	public void setRestep(int restep) {
		this.restep = restep;
	}

	public int getRelevel() {
		return relevel;
	}

	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}

	public DATE getModidate() {
		return modidate;
	}

	public void setModidate(DATE modidate) {
		this.modidate = modidate;
	}

	public DATE getRegidate() {
		return regidate;
	}

	public void setRegidate(DATE regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "Reply [rnum=" + rnum + ", bnum=" + bnum + ", email=" + email + ", content=" + content + ", ip=" + ip
				+ ", restep=" + restep + ", relevel=" + relevel + ", modidate=" + modidate + ", regidate=" + regidate
				+ "]";
	} 
	
	
}
