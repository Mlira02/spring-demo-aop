package com.marcos.aopdemo.aspect;

import com.marcos.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect
{
    private Logger myLogger = Logger.getLogger(getClass().getName());
//    @Before("execution(public void add*())") could use this but creating pointcut can be used. duh...
    @Before("com.marcos.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
    {
        myLogger.info("======== Executing @Before advice on all methods with add in front ========");

        MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
        myLogger.info("Method: " + methodSig);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args)
        {
            myLogger.info("This is tempArg: " + tempArg);

            if(tempArg instanceof Account)
            {
                Account theAccount = (Account)tempArg;
                myLogger.info("Account name: " + theAccount.getName());
                myLogger.info("Account level: " + theAccount.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.marcos.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void AfterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result)
    {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("====== Executing afterReturning on method: " + method + "========");
        myLogger.info("Result is: " + result);

        convertAccountNamesToUpperCase(result);
        myLogger.info("====== results have changed as is: " + result + " =========");
    }

    public void convertAccountNamesToUpperCase(List<Account> result)
    {
        for(Account tempAccount : result)
        {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }

    @AfterThrowing(pointcut = "execution(* com.marcos.aopdemo.dao.AccountDAO.findAccounts(..))",
                   throwing = "theExc")
    public void AfterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc)
    {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("======= Executing @AfterThrowing on method: " + method);
        myLogger.info("===== the exception is: " + theExc);
    }

    @After("execution(* com.marcos.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void AfterFinallyFindAccounts(JoinPoint theJoinPoint)
    {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("======= Executing after(finally) on method: " + method);
    }

    @Around("execution(* com.marcos.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object AroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
    {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("===== Executing @Around aspect on method: " + method + " ========");

        long begin = System.currentTimeMillis();
        Object result = null;
        try{
            result = theProceedingJoinPoint.proceed();
        }
        catch(Exception exc)
        {
            myLogger.warning(exc.getMessage());
            result = "Major accident! No worries this will be resolved soon!";
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        myLogger.info("Duration of method: " + duration / 1000.0 + " seconds");
        return result;
    }
}