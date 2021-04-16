package com.marcos.aopdemo;

import com.marcos.aopdemo.dao.AccountDAO;
import com.marcos.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

public class MainDemoApp
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account myAccount = new Account();

        theAccountDAO.addAccount(myAccount);
        theAccountDAO.setName("Marcos");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String serviceCode = theAccountDAO.getServiceCode();

        theMembershipDAO.addMembership();

        context.close();
    }
}
