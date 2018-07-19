package kh.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kh.spring.dto.MemberDTO;
import kh.spring.interfaces.MemberDAO;

@Component
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public int insert(MemberDTO dto) {
		String sql = "insert into members values(?,?,?,?,?,?,?,?,?,?,default,sysdate)";
		return template.update(sql, dto.getId(), dto.getPw(), dto.getName(), dto.getPhone1(), dto.getPhone2(), dto.getPhone3(), dto.getEmail(), dto.getZipcode(), dto.getAddress1(), dto.getAddress2());
	}

}
