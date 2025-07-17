package com.application.service;

import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dto.ReplyVO;

public interface ReplyService {

	List<ReplyVO> list(int bno, PageMaker pageMaker) throws SQLException;
	
	void regist(ReplyVO reply) throws SQLException;
	
	void modify(ReplyVO reply) throws SQLException;
	
	void remove(int rno) throws SQLException;
	
}
