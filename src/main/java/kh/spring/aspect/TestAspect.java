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
	// �޼��� ����Ÿ��, �޼��� Ǯ ���, �Ű�����
		// get*(*)�ƹ� �ų� ���� �ϳ�, get*(..) �Ű����� �־ �ǰ� ��� �ǰ�, get*(*,*) �Ű����� �� ��
		// @Pointcut("execution(MessagesDTO kh.messages.impl.*ServiceImpl.get*(*))")
		// @Pointcut("execution(* kh.messages.impl.*ServiceImpl.get*(..))")
		@Pointcut("execution(* kh.spring.impl.*ServiceImpl.login(..))")
		public void loginPw() {} // PointCut ���̵� �޼�����
		
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
			System.out.println(dto.getId() + " ���� " + " ȸ������ �߽��ϴ�.");
			System.out.println(new Date(System.currentTimeMillis()) + "Insert�� ����Ǿ����ϴ�.");
		}
		
}
