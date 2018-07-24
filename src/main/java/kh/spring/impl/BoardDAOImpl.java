package kh.spring.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.BoardDTO;
import kh.spring.interfaces.BoardDAO;

@Component
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSessionTemplate template;
	//private JdbcTemplate template;


	@Override
	public List<BoardDTO> BoardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return template.selectList("Board.getAllData", map);
//		String sql = "select * from (select board.*, row_number() over(order by writedate desc) as num from board) where num between ? and ?";
//		return template.query(sql, new Object[] {startNum, endNum}, new RowMapper<BoardDTO>() {
//			@Override
//			public BoardDTO mapRow(ResultSet rs, int rownum) throws SQLException {
//				BoardDTO tmp = new BoardDTO();
//				tmp.setSeq(rs.getString("seq"));
//				tmp.setTitle(rs.getString("title"));
//				tmp.setContents(rs.getString("contents"));
//				tmp.setWriter(rs.getString("writer"));
//				tmp.setWritedate(rs.getString("writedate"));
//				tmp.setViewcount(rs.getString("viewcount"));
//				tmp.setIp(rs.getString("ip"));
//				return tmp;
//			}
//		});
	}
	
	public int BoardWriting(BoardDTO dto) {
		return template.insert("Board.insert",dto);
//		String sql = "insert into board values(board_seq.nextval,?,?,?,sysdate,0,'abc')";
//		return template.update(sql, dto.getTitle(), dto.getContents(), dto.getWriter());
		
	}

	@Override
	public int BoardUpdate(BoardDTO dto) {
		return template.update("Board.update", dto);
//		String sql = "update board set title=?, contents=? where seq=?";
//		return template.update(sql, dto.getTitle(), dto.getContents(), dto.getSeq());
	}


	@Override
	public int BoardDelete(String seq) {
		return template.delete("Board.delete", seq);
//		String sql = "delete from board where seq=?";
//		return template.update(sql, seq);
	}

	@Override
	public BoardDTO BoardView(String seq) {
		return template.selectOne("Board.boardView", seq);
		
//		String sql = "select * from board where seq=?";
//		return template.queryForObject(sql, new Object[] {seq}, new RowMapper<BoardDTO>() {
//
//			@Override
//			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				BoardDTO tmp = new BoardDTO();
//				tmp.setSeq(rs.getString("seq"));
//				tmp.setTitle(rs.getString("title"));
//				tmp.setContents(rs.getString("contents"));
//				tmp.setWriter(rs.getString("writer"));
//				tmp.setWritedate(rs.getString("writedate"));
//				tmp.setViewcount(rs.getString("viewcount"));
//				tmp.setIp(rs.getString("ip"));
//				return tmp;
//			}
//			
//		});
	}

	@Override
	public String getPageNavi(int currentPage) {
		String recordTotalCountStr = template.selectOne("Board.getPageNavi");
		int recordTotalCount = Integer.parseInt(recordTotalCountStr);
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int pageTotalCount = 0;
		
		if(recordTotalCount % recordCountPerPage > 0) {  //정확히 10으로 나누어 떨어지지 않음
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage>pageTotalCount){
			currentPage = pageTotalCount;
		}
		
		int startNavi =  (currentPage - 1) / naviCountPerPage*naviCountPerPage+1;//네이게이터 시작 값
		int endNavi = startNavi + (naviCountPerPage-1); // 네비게이터 끝 값
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi==1) {
			needPrev=false;
		}
		
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(needPrev) {
			sb.append("<a href='boardList.do?currentPage="+(startNavi-1)+"'>< </a> ");
		}
		
		for(int i=startNavi; i<=endNavi; i++) {
			if(currentPage==i){
				sb.append("<a href='boardList.do?currentPage="+i+"' ><b>"+ i + " </b></a>");
			}else {
				sb.append("<a href='boardList.do?currentPage="+i+"' >"+ i + " </a>");
			}
			
		}
		if(needNext) {
			sb.append("<a href='boardList.do?currentPage="+(endNavi+1)+"'>></a>");
		}
		
		return sb.toString();
//		BoardDAOImpl.currentPage = currentPage;
//		String sql = "select count(*) totalCount from board";
//		return template.queryForObject(sql, new RowMapper<String>() {
//
//			@Override
//			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//				int recordTotalCount = rs.getInt("totalCount"); //전체 글(레코드) 의 개수를 저정하는 변수
//				int recordCountPerPage = 10; //한 페이지에 게시글이 몇개 보일 건지
//				int naviCountPerPage = 10; // 한 페이지에서 네이게이터가 몇개씩 보일건지
//				int pageTotalCount = 0; //전체가 몇페이지로 구성 될 것인지
//				
//				if(recordTotalCount % recordCountPerPage > 0) {  //정확히 10으로 나누어 떨어지지 않음
//					pageTotalCount = recordTotalCount / recordCountPerPage + 1;
//				}else {
//					pageTotalCount = recordTotalCount / recordCountPerPage;
//				}
//				
//				//------------------------------------------------------------------
//				
//				if(BoardDAOImpl.currentPage < 1) {
//					BoardDAOImpl.currentPage = 1;
//				}else if(BoardDAOImpl.currentPage>pageTotalCount){
//					BoardDAOImpl.currentPage = pageTotalCount;
//				}
//				//현재 페이지가 비정상인지 검증하는 코드
//				
//				//------------------------------------------------------------------
//				
//				
//				
//				//네이게이터가 시작하는 값 ?
//		        // currentPage / naviCountPerPage * naviCountPerPage+1;
//				
//				int startNavi =  (BoardDAOImpl.currentPage - 1) / naviCountPerPage*naviCountPerPage+1;//네이게이터 시작 값
//				int endNavi = startNavi + (naviCountPerPage-1); // 네비게이터 끝 값
//				
//				if(endNavi > pageTotalCount) {
//					endNavi = pageTotalCount;
//				}
//
//				
//				boolean needPrev = true;
//				boolean needNext = true;
//				
//				if(startNavi==1) {
//					needPrev=false;
//				}
//				
//				if(endNavi == pageTotalCount) {
//					needNext = false;
//				}
//				
//				StringBuilder sb = new StringBuilder();
//				
//				if(needPrev) {
//					sb.append("<a href='boardList.do?currentPage="+(startNavi-1)+"'>< </a> ");
//				}
//				
//				for(int i=startNavi; i<=endNavi; i++) {
//					if(BoardDAOImpl.currentPage==i){
//						sb.append("<a href='boardList.do?currentPage="+i+"' ><b>"+ i + " </b></a>");
//					}else {
//						sb.append("<a href='boardList.do?currentPage="+i+"' >"+ i + " </a>");
//					}
//					
////					sb.append("<a href=''> "+ i +" </a>");
//				}
//				if(needNext) {
//					sb.append("<a href='boardList.do?currentPage="+(endNavi+1)+"'>></a>");
//				}
//				return sb.toString();
//			}
//			
//		});
		
	}

	

	
	
}
