package com.stackroute.keepnote.aspectj;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/* Annotate this class with @Aspect and @Component */
@Component
@Aspect
public class LoggingAspect {
	/*
	 * Write loggers for each of the methods of User controller, any particular
	 * method will have all the four aspectJ annotation
	 * (@Before, @After, @AfterReturning, @AfterThrowing).
	 */
	private static final Logger logger =LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("execution (* com.stackroute.keepnote.controller.UserController.*(..))")
	public void allControllersMethods() {
		
	}
	
	//
	@Before("allControllersMethods()")
	public void beforeAdvice(JoinPoint joinPoint) {
		logger.info("****************@Before*********************");
		logger.debug("Method Name: {}", joinPoint.getSignature().getName());
		logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
		logger.info("*********************************************");
	}
	
	@After("allControllersMethods()")
	public void afterAdvice(JoinPoint joinPoint) {
		logger.info("****************@After*********************");
		logger.debug("Method Name: {}", joinPoint.getSignature().getName());
		logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
		logger.info("*********************************************");
	}
	@AfterReturning(value="allControllersMethods()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("****************@Afetr Returning*********************");
		logger.debug("Method Name: {}", joinPoint.getSignature().getName());
		logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
		logger.debug("Method return values: {}", result);
		logger.info("*********************************************");
	}
	@AfterThrowing(value="allControllersMethods()", throwing="error")
	public void afterThrowing(JoinPoint joinPoint, Throwable error) {
		logger.info("****************@After Throwing*********************");
		logger.debug("Method Name: {}", joinPoint.getSignature().getName());
		logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
		logger.debug("Exceptions: {}", error);
		logger.info("*********************************************");
	}
}
