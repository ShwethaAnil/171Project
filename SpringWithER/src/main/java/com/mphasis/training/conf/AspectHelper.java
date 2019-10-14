package com.mphasis.training.conf;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectHelper {
	@Pointcut("execution(* com.mphasis.training.*.*.*(..))")
	public void getAll() {}
	
	@Before("getAll()")
	public void beforeMethod(JoinPoint jp) {
		System.out.println("Before the Method " + jp.getSignature().getName());
		System.out.println(Arrays.toString(jp.getArgs()));
	}
	
	@After("getAll()")
	public void afterMethod(JoinPoint jp) {
		System.out.println("After the Method " + jp.getSignature().getName());
		System.out.println(Arrays.toString(jp.getArgs()));
	}
	
	@AfterThrowing(pointcut="execution(* com.mphasis.training.*.*.*(..))")
	public void afterThrowingMethod(JoinPoint jp) {
		System.out.println("After Throwing the Method " + jp.getSignature().getName());
		System.out.println(Arrays.toString(jp.getArgs()));
	}
}
