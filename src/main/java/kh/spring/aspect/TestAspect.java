package kh.spring.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import kh.security.util.EncryptUtils;
import kh.spring.dto.MemberDTO;


@Aspect
@Component
public class TestAspect {
	
		@Pointcut("execution(* kh.spring.impl.*ServiceImpl.login(..))")
		public void loginPw() {} 
		
		@Pointcut("execution(* kh.spring.impl.*ServiceImpl.insert(..))")
		public void insertPointCut() {}
		
		@Pointcut("execution(* kh.spring.impl.*ServiceImpl.insert(..))")
		public void insertEncrypt() {}
		
		@Around("loginPw()")
		public int loginPw(ProceedingJoinPoint pjp) {
			// Before
			String id = pjp.getArgs()[0].toString();
			String pw = pjp.getArgs()[1].toString();
			pw = EncryptUtils.getSha256(pw);
			int result = 0;
			try {
				result = (int)pjp.proceed(new Object[] {id, pw}); // before after branch 분기점
				// After
			} catch (Throwable e) {
				e.printStackTrace();
			} 
			return result;
		}
		
		@Before("insertEncrypt()")
		public void changePw(JoinPoint jp) {
			MemberDTO dto = (MemberDTO)jp.getArgs()[0];
			String pw = EncryptUtils.getSha256(dto.getPw());
			dto.setPw(pw);
		}
		
		
		@After("insertPointCut()")
		public void insertLoggin(JoinPoint jp) {
			MemberDTO dto = (MemberDTO)jp.getArgs()[0];
			System.out.println(dto.getId() + " 님이 " + " 회원가입했습니다.");
			System.out.println(new Date(System.currentTimeMillis()) + "Insert문이 실행되었습니다.");
		}
		
}
