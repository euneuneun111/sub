package com.spring.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private SqlSession session;

	public MemberDAOImpl(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		return session.selectList("Member-Mapper.selectMemberList");
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		return session.selectOne("Member-Mapper.selectMemberList", id);
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		session.insert("Member-Mapper.insertMemberList", member);

	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		session.update("Member-Mapper.updateMemberList", member);

	}

	@Override
	public void deleteMember(String id) throws SQLException {
		session.delete("Member-Mapper.deleteMemberList", id);

	}

	@Override
	public List<String> selectAuthoritiesById(String id) throws SQLException {
		return session.selectList("Member-Mapper.selectAuthoritiesById", id);
	}

	@Override
	public void insertAuthorities(String id, int authority) throws SQLException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("authority", authority);
		session.insert("Member-Mapper.insertAuthorities", paramMap);
	}

	@Override
	public void deleteAllAuthorityById(String id) throws SQLException {
		session.delete("Member-Mapper.deleteAllAuthorityById", id);
	}

}
