package kh.spring.interfaces;

import kh.spring.dto.MemberDTO;

public interface MemberDAO {
	public int insert(MemberDTO dto);
	public int login(MemberDTO dto);
	public int withdraw(String id);
	public MemberDTO getAllData(String id);
	public int updateInfo(MemberDTO dto);
}
