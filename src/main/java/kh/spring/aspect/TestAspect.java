package kh.spring.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import kh.security.util.EncryptUtils;
import kh.spring.dto.MemberDTO;


@Aspect
@Component
public class TestAspect {
	// 메서드 리턴타입, 메서드 풀 경로, 매개변수
		// get*(*)아무 거나 변수 하나, get*(..) 매개변수 있어도 되고 없어도 되고, get*(*,*) 매개변수 두 개
		// @Pointcut("execution(MessagesDTO kh.messages.impl.*ServiceImpl.get*(*))")
		// @Pointcut("execution(* kh.messages.impl.*ServiceImpl.get*(..))")
		@Pointcut("execution(* kh.spring.impl.*ServiceImpl.login(..))")
		public void loginPw() {} // PointCut 아이디가 메서드임
		
		@Pointcut("execution(* kh.spring.impl.*ServiceImpl.insert(..))")
		public void insertPointCut() {}
		
		@Pointcut("execution(* kh.spring.impl.*ServiceImpl.insert(..))")
		public void insertEncrypt() {}
		
		@Before("loginPw()")
		public void loginPw(JoinPoint jp) {
			MemberDTO dto = (MemberDTO)jp.getArgs()[0];
			String pw = EncryptUtils.getSha512(dto.getPw());
			dto.setPw(pw);
		}
		
		@Before("insertEncrypt()")
		public void changePw(JoinPoint jp) {
			MemberDTO dto = (MemberDTO)jp.getArgs()[0];
			String pw = EncryptUtils.getSha512(dto.getPw());
			dto.setPw(pw);
		}
		
		
		@After("insertPointCut()")
		public void insertLoggin(JoinPoint jp) {
			MemberDTO dto = (MemberDTO)jp.getArgs()[0];
			System.out.println(dto.getId() + " 님이 " + " 회원가입 했습니다.");
			System.out.println(new Date(System.currentTimeMillis()) + "Insert가 실행되었습니다.");
		}
		
}
