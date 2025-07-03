package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.MemberVO;

public interface MemberService {
	
	List<MemberVO> list() throws SQLException;
	
	MemberVO getMember(String id) throws SQLException;

	// 등록
	void regist(MemberVO member) throws SQLException;
	
	// 수정
	void modify(MemberVO member) throws SQLException;
	
	// 삭제
	void remove(String id) throws SQLException;
	
	void modifyAuthority(String id, List<String> authorities) throws SQLException;
	
	}
