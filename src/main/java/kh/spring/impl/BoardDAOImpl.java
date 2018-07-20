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
	
	public int BoardWriting(BoardDTO dto) {
		String sql = "insert into board values(board_seq.nextval,?,?,?,sysdate,0,'abc')";
		return template.update(sql, dto.getTitle(), dto.getContents(), dto.getWriter());
		
	}

	@Override
	public int BoardUpdate(BoardDTO dto) {
		String sql = "update board set title=?, contents=? where seq=?";
		return template.update(sql, dto.getTitle(), dto.getContents(), dto.getSeq());
	}


	@Override
	public int BoardDelete(String seq) {
		String sql = "delete from board where seq=?";
		return template.update(sql, seq);
	}

	@Override
	public BoardDTO BoardView(String seq) {
		String sql = "select * from board where seq=?";
		return template.queryForObject(sql, new Object[] {seq}, new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
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
