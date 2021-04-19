package com.marcos.aopdemo;

import com.marcos.aopdemo.dao.AccountDAO;
import com.marcos.aopdemo.dao.MembershipDAO;
import com.marcos.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;
import java.util.List;
import java.util.logging.Logger;

public class MainDemoApp
{

    private static Logger myLogger = Logger.getLogger(MainDemoApp.class.getName());

    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

//        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
//        List<Account> theAccounts = null;
//        try
//        {
//            boolean tripWire = true;
//            theAccounts = theAccountDAO.findAccounts(tripWire);
//        }
//        catch(Exception exc)
//        {
//            myLogger.info("Main program caught exception: " + exc);
//        }
//        myLogger.info("Main Program: DemoApp ");
//        myLogger.info(theAccounts);
        myLogger.info("Main program DemoApp");

        boolean tripWire = true;
        String data = theFortuneService.getFortune(tripWire);

        myLogger.info("My fortune is: " + data);

        myLogger.info("finished");

        context.close();
    }
}
