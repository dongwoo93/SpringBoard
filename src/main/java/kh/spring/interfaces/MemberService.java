package kh.spring.interfaces;

import kh.spring.dto.MemberDTO;

public interface MemberService {
	public int insert(MemberDTO dto); 
	public int login(String id, String pw);
	public int withdraw(String id);
	public MemberDTO getAllData(String id);
	public int updateInfo(MemberDTO dto);
}
