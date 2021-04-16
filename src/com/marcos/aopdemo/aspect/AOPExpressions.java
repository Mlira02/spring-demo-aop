package com.marcos.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AOPExpressions
{
    @Pointcut("execution(* com.marcos.aopdemo.dao.*.*(..))")
    public void forDAOPackage() {}

    @Pointcut("execution(* com.marcos.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.marcos.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter(){}
}
