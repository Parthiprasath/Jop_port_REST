package com.parthi.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {


    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);


    //return type, class-name.method-name, args
//    @Before("execution(* com.parthi.spring_boot_rest.service.JobService.*(..))")
//    public void logMethodCall(){}

    @Before("execution(* com.parthi.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.parthi.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp){

        LOGGER.info("Method Called" + jp.getSignature().getName());
    }

    @After("execution(* com.parthi.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.parthi.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp){

        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.parthi.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.parthi.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCrashed(JoinPoint jp){

        LOGGER.info("Method has some issues " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.parthi.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.parthi.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodSuccess(JoinPoint jp){

        LOGGER.info("Method Executed SuccessFully " + jp.getSignature().getName());
    }


}
