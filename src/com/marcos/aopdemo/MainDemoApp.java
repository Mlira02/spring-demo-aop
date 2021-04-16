package com.marcos.aopdemo;

import com.marcos.aopdemo.dao.AccountDAO;
import com.marcos.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

public class MainDemoApp
{
    public static void main(String[] args)
    {
        System.out.println("Does the aspect know before executing the main method???");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        theAccountDAO.addAccount();
        System.out.println("\n let's call addMembership now \n");
        theMembershipDAO.addMembership();

        context.close();
    }
}
