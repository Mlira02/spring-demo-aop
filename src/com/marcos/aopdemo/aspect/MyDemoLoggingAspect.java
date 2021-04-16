package com.marcos.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect
{
//    @Before("execution(public void add*())") could use this but creating pointcut can be used. duh...
    @Before("com.marcos.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("======== Executing @Before advice on all methods with add in front ========");
    }
}