package com.study.edu.aspect;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import com.study.edu.annotation.CatAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/3/15.
 * 自定义切面，结合自定义注解埋点
 */
//@Aspect
//@Component
public class CatAop {
    @Around(value="execution(* com.study.edu.mapper.*.*(..))")
    public Object arroudAdvice(ProceedingJoinPoint point){
        System.out.println("enter Aop");
        Object o = null;
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        /*判断该方法是否被注解*/
        boolean flag = method.isAnnotationPresent(CatAnnotation.class);
        if(flag){
            System.out.println("enter annotation.");
            /*进行埋点*/
            Transaction t = Cat.newTransaction("Method",method.getName());
            try{
                Cat.logMetricForCount(method.getName());
                o = point.proceed();
                t.setStatus(Transaction.SUCCESS);
            } catch (Throwable throwable) {
                t.setStatus(throwable);
                throwable.printStackTrace();
            }finally {
                t.complete();

            }

        }else {
            try {
                o = point.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return o;
    }
}
