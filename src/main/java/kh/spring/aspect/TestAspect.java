package kh.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
	
	@Around("loginPointCut()")
		public int encryptPw(ProceedingJoinPoint pjp) {
		String id = pjp.getArgs()[0].toString();
		String pw = pjp.getArgs()[1].toString();
		
		pw = EncryptUtils.getSha512(pw);
		
		//Before
		int result = 0;
		try {
			result = (Integer)pjp.proceed(new Object[] {id,pw});
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // proceed 기준
		//After
		
		return result;
	}
	
	@Pointcut("execution(* kh.spring.impl.*ServiceImpl.updateInfo(..))")
	public void updatePointCut() {}
	
	@Before("updatePointCut()")
	public void updatePw(JoinPoint jp) {
		MemberDTO dto = (MemberDTO) jp.getArgs()[0];
		String pw = dto.getPw();
		dto.setPw(EncryptUtils.getSha512(pw));
	}
	
	
	
}
