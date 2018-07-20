package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.BoardDTO;
import kh.spring.interfaces.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("/boardList.do")
	public ModelAndView boardListProc() {
		
		ModelAndView mav = new ModelAndView();
		
		List<BoardDTO> result = this.service.BoardList();
		
		System.out.println(result.get(0).getTitle());
		
		mav.addObject("result", result);
		mav.setViewName("boardList.jsp");
		
		return mav;
		
	}
	
	@RequestMapping("/boardWriting.do")
	public ModelAndView boardWritingProc(BoardDTO dto) {
		
		int result = this.service.BoardWriting(dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName("boardWritingProc.jsp");
		
		return mav;
		
	}
	
	@RequestMapping("/boardDelete.do")
	public int boardDeleteProc(int seq) {
		return this.service.BoardDelete(seq);
	}
	
	
	
}
