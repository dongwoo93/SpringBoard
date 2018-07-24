package kh.spring.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MemberDTO;
import kh.spring.interfaces.MemberDAO;

@Component
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate template;
	//private JdbcTemplate template;
	
	@Override
	public int insert(MemberDTO dto) {
		return template.insert("Member.insert", dto);
//		String sql = "insert into members values(?,?,?,?,?,?,?,?,?,?,default,sysdate)";
//		return template.update(sql, dto.getId(), dto.getPw(), dto.getName(), dto.getPhone1(), dto.getPhone2(), dto.getPhone3(), dto.getEmail(), dto.getZipcode(), dto.getAddress1(), dto.getAddress2());
	}

	@Override
	public int login(String id, String pw) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		return template.selectOne("Member.login", map);
//		String sql = "select * from members where id=? and pw=?";
//		return template.update(sql, id, pw);
	}

	@Override
	public int withdraw(String id) {
		return template.delete("Member.withdraw", id);
//		String sql = "delete from members where id=?";
//		return template.update(sql, id);
//		동우띠 화이똥 
	}

	@Override
	public MemberDTO getAllData(String id) {
		return template.selectOne("Member.getAllData", id);
//		String sql = "select * from members where id=?";
//		return template.queryForObject(sql, new Object[] {id}, new RowMapper<MemberDTO>() {
//
//			@Override
//			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberDTO tmp = new MemberDTO();
//				tmp.setId(rs.getString(1));
//				tmp.setPw(rs.getString(2));
//				tmp.setName(rs.getString(3));
//				tmp.setPhone1(rs.getString(4));
//				tmp.setPhone2(rs.getString(5));
//				tmp.setPhone3(rs.getString(6));
//				tmp.setEmail(rs.getString(7));
//				tmp.setZipcode(rs.getString(8));
//				tmp.setAddress1(rs.getString(9));
//				tmp.setAddress2(rs.getString(10));
//				tmp.setIsBlocked(rs.getString(11));
//				tmp.setLast_modified(rs.getString(12));
//				return tmp;
//			}
//		});
	}

	@Override
	public int updateInfo(MemberDTO dto) {
		return template.delete("Member.update", dto);
//		String sql = "update members set pw=?, name=?, phone1=?, phone2=?, phone3=?, email=?, zipcode=?, address1=?, address2=? where id=?";
//		return template.update(sql, dto.getPw(), dto.getName(), dto.getPhone1(), dto.getPhone2(), dto.getPhone3(), dto.getEmail(), dto.getZipcode(), dto.getAddress1(), dto.getAddress2(), dto.getId());
	}

}
