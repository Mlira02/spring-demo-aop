package com.marcos.aopdemo.aspect;

import com.marcos.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect
{
//    @Before("execution(public void add*())") could use this but creating pointcut can be used. duh...
    @Before("com.marcos.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
    {
        System.out.println("======== Executing @Before advice on all methods with add in front ========");

        MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
        System.out.println("Method: " + methodSig);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args)
        {
            System.out.println("This is tempArg: " + tempArg);

            if(tempArg instanceof Account)
            {
                Account theAccount = (Account)tempArg;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.marcos.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void AfterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result)
    {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("====== Executing afterReturning on method: " + method + "========");
        System.out.println("Result is: " + result);

        convertAccountNamesToUpperCase(result);
        System.out.println("====== results have changed as is: " + result + " =========");
    }

    public void convertAccountNamesToUpperCase(List<Account> result)
    {
        for(Account tempAccount : result)
        {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }

}
