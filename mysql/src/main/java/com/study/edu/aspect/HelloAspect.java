package com.study.edu.aspect;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/3/14.
 */
//@Aspect
//@Component
public class HelloAspect {
    private final Logger logger = Logger.getLogger(getClass().toString());

    //@Pointcut("execution(public * com.study.edu.mapper.*.*(..))")
    public void weblog(){}

   //@Before("weblog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL"+request.getRequestURI().toString());
        logger.info("HTTP_MEHTOD"+request.getMethod());
        logger.info("IP"+request.getRemoteAddr());
        logger.info("CLASS_METHOD: "+joinPoint.getSignature().getDeclaringTypeName()+","+joinPoint.getSignature().getName());
        logger.info("ARGS:"+joinPoint.getArgs());
        Transaction transaction = Cat.newTransaction("URL",request.getRequestURI().toString());
        Cat.logEvent("Method",request.getMethod());
        transaction.setStatus(Transaction.SUCCESS);
        transaction.complete();
    }

    public void doAround(ProceedingJoinPoint point){

    }

   //@AfterReturning(returning = "ret",pointcut = "weblog()")
    public void doAfterReturn(Object ret){
        logger.info("RESPONSE:"+ret);
    }
}
