package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView boardListProc(HttpServletRequest request) {
		
		int currentPage = 0;
		String currentPageString = request.getParameter("currentPage");
		
		if(currentPageString ==null){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(currentPageString);
		}
		
		ModelAndView mav = new ModelAndView();
		
		List<BoardDTO> result = this.service.BoardList(currentPage*10-9, currentPage*10);
		String navi = service.getPageNavi(currentPage);
		
		System.out.println(result.get(0).getTitle());
		
		mav.addObject("result", result);
		mav.addObject("navi", navi);
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
	public ModelAndView boardDeleteProc(String seq) {
		
		int result = service.BoardDelete(seq);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName("boardDeleteProc.jsp");
		
		return mav;
		
	}
	
	@RequestMapping("/boardView.do")
	public ModelAndView boardView(String seq) {
		
		BoardDTO result = service.BoardView(seq);
		System.out.println(result.getTitle());
		System.out.println(result.getContents());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName("boardView.jsp");
		
		return mav;
	}
	
	@RequestMapping("boardUpdate.do")
	public ModelAndView boardUpdate(String seq) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("seq", seq);
		mav.setViewName("boardUpdate.jsp");
		return mav;
	}
	
	@RequestMapping("/boardUpdateProc.do")
	public ModelAndView boardUpdateProc(BoardDTO dto) {
		
		int result = service.BoardUpdate(dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName("boardUpdateProc.jsp");
		
		return mav;
		
	}
	
	
}
