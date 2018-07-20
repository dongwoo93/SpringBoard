package kh.spring.interfaces;

import java.util.List;

import kh.spring.dto.MemberDTO;

public interface MemberService {
	public int insert(MemberDTO dto); 
	public int login(String id, String pw);
	public int withdraw(String id);
}
