package kh.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import kh.security.util.EncryptUtils;
import kh.spring.dto.MemberDTO;

@Aspect
@Component
public class TestAspect {
	
	@Pointcut("execution(* kh.spring.impl.*ServiceImpl.insert(..))")
	public void insertPointCut() {}
	
	@Before("insertPointCut()") 
		public void insertPw(JoinPoint jp) {
			MemberDTO dto = (MemberDTO) jp.getArgs()[0];
			String pw = dto.getPw();
			dto.setPw(EncryptUtils.getSha512(pw));
		}
	
	@Pointcut("execution(* kh.spring.impl.*ServiceImpl.login(..))")
	public void loginPointCut() {}
	
	@Before("loginPointCut()")
		public void encryptPw(JoinPoint jp) {
		MemberDTO dto = (MemberDTO) jp.getArgs()[0];
		String pw = dto.getPw();
		dto.setPw(EncryptUtils.getSha512(pw));
	}
	
}
