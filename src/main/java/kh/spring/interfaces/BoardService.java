package kh.spring.interfaces;

import java.util.List;

import kh.spring.dto.BoardDTO;

public interface BoardService {

	public List<BoardDTO> BoardList(int startNum, int endNum);
	
	public int BoardWriting(BoardDTO dto);
	
	public int BoardUpdate(BoardDTO dto);
	
	public int BoardDelete(String seq);
	
	public BoardDTO BoardView(String seq);
	
	public String getPageNavi(int currentPage);
}
