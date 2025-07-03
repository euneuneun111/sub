package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;

	}

	@Override
	public List<MemberVO> list() throws SQLException {
		List<MemberVO> memberList = memberDAO.selectMemberList();

		if (memberList != null)
			for (MemberVO member : memberList) {
				List<String> authorities = memberDAO.selectAuthoritiesById(member.getId());
				member.setAuthorities(authorities);
			}

		return memberList;
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		if (member != null)
			member.setAuthorities(memberDAO.selectAuthoritiesById(id));
		return member;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		memberDAO.insertMember(member);
		if (member.getAuthorities().size() > 0) {
			for (String authority : member.getAuthorities()) {
				memberDAO.insertAuthorities(member.getId(), Integer.parseInt(authority));
			}
		}
	}

	@Override
	public void modify(MemberVO member) throws SQLException {
		memberDAO.updateMember(member);
	}

	@Override
	public void remove(String id) throws SQLException {
		memberDAO.deleteMember(id);
	}

	@Override
	public void modifyAuthority(String id, List<String> authorities) throws SQLException {
		memberDAO.deleteAllAuthorityById(id);
		if (authorities.size() > 0)
			for (String authority : authorities) {
				memberDAO.insertAuthorities(id, Integer.parseInt(authority));

			}
	}
}
