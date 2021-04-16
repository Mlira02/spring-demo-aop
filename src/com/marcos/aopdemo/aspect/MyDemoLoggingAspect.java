package com.marcos.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect
{
    @Pointcut("execution(* com.marcos.aopdemo.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("execution(* com.marcos.aopdemo.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.marcos.aopdemo.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    private void forDAOPackageNoGetterSetter(){}

//    @Before("execution(public void add*())") could use this but creating pointcut can be used. duh...
    @Before("forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("======== Executing @Before advice on all methods with add in front ========");
    }

    @Before("forDAOPackageNoGetterSetter()")
    public void performApiAnalytics()
    {
        System.out.println("======= Performing API analytics =======");
    }
}