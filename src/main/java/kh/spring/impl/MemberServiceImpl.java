package kh.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MemberDTO;
import kh.spring.interfaces.MemberDAO;
import kh.spring.interfaces.MemberService;

@Component
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	@Override
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}

	@Override
	public int login(String id, String pw) {
		return dao.login(id, pw);
	}

	@Override
	public int withdraw(String id) {
		return dao.withdraw(id);
	}

	@Override
	public MemberDTO getAllData(String id) {
		return dao.getAllData(id);
	}

	@Override
	public int updateInfo(MemberDTO dto) {
		return dao.updateInfo(dto);
	}

	

	

}
