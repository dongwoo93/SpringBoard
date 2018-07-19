package kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.MemberDTO;
import kh.spring.interfaces.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("/index.do")
	public String toIndex() {
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/join.do")
	public String toJoinForm() {
		return "redirect:join.html";
	}
	
	@RequestMapping("/joinProc.do")
	public ModelAndView toJoinProc(MemberDTO dto) {
		int result = this.service.insert(dto);
		System.out.println(dto.getAddress2());
		System.out.println(dto.getPhone2());
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName("joinProcView.jsp");
		return mav;
	}
	
}
