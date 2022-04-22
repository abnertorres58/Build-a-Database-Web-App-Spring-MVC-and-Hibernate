package com.freudromero.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // Setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // Setup pointcut declarations
    @Pointcut("execution(* com.freudromero.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    // Do the same for service and dao
    @Pointcut("execution(* com.freudromero.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.freudromero.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // Add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJointPoint) {

        // Display methods we are calling
        String theMethod = theJointPoint.getSignature().toShortString();
        myLogger.info("===========> in @Before: calling method: " + theMethod);

        // Display the arguments to the method

        // Get the arguments
        Object[] args = theJointPoint.getArgs();

        // Loop through and display arg
        for(Object tempArg : args) {
            myLogger.info("==========> argument: " + tempArg);
        }
    }

    // Add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterReturning(JoinPoint theJointPoint, Object theResult) {

        // Display method we are returning from
        String theMethod = theJointPoint.getSignature().toShortString();
        myLogger.info("===========> in @AfterReturning: from method: " + theMethod);

        // Display data returned
        myLogger.info("=========> result: " + theResult);

    }

}
