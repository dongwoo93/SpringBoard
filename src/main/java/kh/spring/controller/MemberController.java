package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("/login.do")
	public String toLogin(HttpServletRequest requerst, MemberDTO dto) {
		int result = service.login(dto);
		
		if(result == 1) {
			requerst.getSession().setAttribute("loginId", dto.getId());
			return "redirect:index.jsp";
		}else {
			return "redirect:loginProcView.jsp";
		}
		
	}
	
	@RequestMapping("/logout.do")
	public String toLogout(HttpServletRequest requerst) {
		requerst.getSession().invalidate();
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/withdraw.do")
	public ModelAndView toWithdraw(HttpServletRequest requerst) {
		String id = (String) requerst.getSession().getAttribute("loginId");
		ModelAndView mav = new ModelAndView();
		int result = service.withdraw(id);
		if(result == 1) {
			requerst.getSession().invalidate();
		}
		mav.addObject("result", result);
		mav.setViewName("withdrawProc.jsp");
		return mav;
		
		
	}
	

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
	
	@RequestMapping("/mypage.do")
	public ModelAndView toMyPage(HttpServletRequest request) {
		String id = (String) request.getSession().getAttribute("loginId");
		ModelAndView mav = new ModelAndView();
		MemberDTO list = this.service.getAllData(id);
		mav.addObject("list", list);
		mav.setViewName("mypage.jsp");
		return mav;
	}
	
	@RequestMapping("/modify.do")
	public ModelAndView toModifyView(HttpServletRequest request) {
		String id = (String) request.getSession().getAttribute("loginId");
		ModelAndView mav = new ModelAndView();
		MemberDTO list = this.service.getAllData(id);
		mav.addObject("list", list);
		mav.setViewName("infoModify.jsp");
		return mav;
	}
	
	@RequestMapping("/infoModify.do")
	public ModelAndView toModifyProc(HttpServletRequest request, MemberDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = this.service.updateInfo(dto);
		mav.addObject("result", result);
		mav.setViewName("modifyProcView.jsp");
		return mav;
	}
	
	
}
