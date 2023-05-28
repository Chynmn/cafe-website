package org.tukorea.starbucks.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MemberAspect {
	private static final Logger logger = LoggerFactory.getLogger(MemberAspect.class);
	
	@Before("execution(* org.tukorea.starbucks.controller..*.*(..))")
	public void beforeMethod(JoinPoint jp) {
		System.out.println("메소드 호출 전");
		org.aspectj.lang.Signature sig = jp.getSignature();
		logger.info("메소드 이름 : " + sig.getName());
		Object[] obj = jp.getArgs();
		logger.info("인자 값 : " + obj[0]);
	}
	
	@After(value = "execution(* org.tukorea.starbucks.controller..*.*(..))")
	public void afterReturningMethod(JoinPoint jp) {
		System.out.println(" 메소드 호출 후");
		org.aspectj.lang.Signature sig = jp.getSignature();
		logger.info(" 메소드 이름 : " + sig.getName());
		Object[] obj = jp.getArgs();
		logger.info(" 인자 값 : " + obj[0]);
	}

}
