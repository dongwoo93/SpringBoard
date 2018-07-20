package kh.spring.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.BoardDTO;
import kh.spring.interfaces.BoardDAO;
import kh.spring.interfaces.BoardService;

@Component
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;

	@Override
	public List<BoardDTO> BoardList() {
		return dao.BoardList();
	}

	@Override
	public int BoardWriting(BoardDTO dto) {
		return dao.BoardWriting(dto);
	}

	@Override
	public int BoardUpdate(BoardDTO dto) {
		
		return dao.BoardUpdate(dto);
	}

	@Override
	public int BoardDelete(String seq) {
		
		return dao.BoardDelete(seq);
	}

	@Override
	public BoardDTO BoardView(String seq) {
		return dao.BoardView(seq);
	}


	
	
	
}
