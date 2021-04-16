package com.marcos.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect
{
    @Before("execution(public void com.marcos.aopdemo.dao.AccountDAO.add*())")
    public void beforeAddAccountAdvice()
    {
        System.out.println("======== Executing @Before advice on all methods with add in front ========");
    }
}
