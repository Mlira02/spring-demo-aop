package com.marcos.aopdemo;

import com.marcos.aopdemo.dao.AccountDAO;
import com.marcos.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;
import java.util.List;

public class MainDemoApp
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> theAccounts = null;
        try
        {
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        }
        catch(Exception exc)
        {
            System.out.println("Main program caught exception: " + exc);
        }
        System.out.println("Main Program: DemoApp ");
        System.out.println(theAccounts);

        context.close();
    }
}
