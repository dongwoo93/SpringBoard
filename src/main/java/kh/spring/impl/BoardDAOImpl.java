package kh.spring.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kh.spring.dto.BoardDTO;
import kh.spring.interfaces.BoardDAO;

@Component
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<BoardDTO> BoardList() {
		String sql = "select * from board";
		return template.query(sql, new RowMapper<BoardDTO>() {
			@Override
			public BoardDTO mapRow(ResultSet rs, int rownum) throws SQLException {
				BoardDTO tmp = new BoardDTO();
				tmp.setSeq(rs.getString("seq"));
				tmp.setTitle(rs.getString("title"));
				tmp.setContents(rs.getString("contents"));
				tmp.setWriter(rs.getString("writer"));
				tmp.setWritedate(rs.getString("writedate"));
				tmp.setViewcount(rs.getString("viewcount"));
				tmp.setIp(rs.getString("ip"));
				return tmp;
			}
		});
	}

}
