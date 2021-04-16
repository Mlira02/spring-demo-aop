package com.marcos.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect
{
    @Pointcut("execution(public void add*(..))")
    private void forDAOPackage() {}

//    @Before("execution(public void add*())") could use this but creating pointcut can be used. duh...
    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("======== Executing @Before advice on all methods with add in front ========");
    }
}