package com.application.dto;

import java.util.Date;

public class ReplyVO {
	
	private int rno;
	
	private int bno;
	
	private String replytext;
	private String replayer;
	private Date regdate;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplayer() {
		return replayer;
	}
	public void setReplayer(String replayer) {
		this.replayer = replayer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	

}
