package com.gjl.topmovies.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by guojilong on 2017/10/24.
 */
@Aspect
@Component("logService")
public class LogService {

    @Around(value = "execution(* com.gjl.topmovies.service.impl.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("log:" + joinPoint.getSignature());
        Object object = joinPoint.proceed();
        return object;
    }
}
