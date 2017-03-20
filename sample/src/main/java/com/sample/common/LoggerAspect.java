package com.sample.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

@Aspect
public class LoggerAspect{
	protected Log log = LogFactory.getLog(LoggerAspect.class);
    static String name = "";
    static String type = "";
    static String prefix = "########## ";
    static String suffix = "##########";
    
    
    /**
     * 컨트롤러, 서비스 매서드 호출 전에 찍히는 로그
     */
    @Before("execution(* com.sample.**.controller.*Controller.*(..)) or execution(* com.sample.**.service.*Impl.*(..))")
    public void startLogPrint(JoinPoint joinPoint) throws Throwable {
        type = joinPoint.getTarget().getClass().getSimpleName();
        log.debug(prefix + type + " :: " + joinPoint.getSignature().getName() + " :: Start " + suffix);
    }
    
    /**
     * 컨트롤러, 서비스 매서드 호출 후에 찍히는 로그
     */
    @After("execution(* com.sample.**.controller.*Controller.*(..)) or execution(* com.sample.**.service.*Impl.*(..))")
    public void endLogPrint(JoinPoint joinPoint) throws Throwable {
    	type = joinPoint.getTarget().getClass().getSimpleName();
        log.debug(prefix + type + " :: " + joinPoint.getSignature().getName() + " :: End " + suffix);
    }
}
