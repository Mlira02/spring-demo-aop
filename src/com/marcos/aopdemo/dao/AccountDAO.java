package com.marcos.aopdemo.dao;

import com.marcos.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO
{
//    Fields
    private String name;
    private String serviceCode;

//    Methods

    public List<Account> findAccounts(boolean tripWire)
    {
        if(tripWire)
        {
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Mark", "Gold");
        Account temp3 = new Account("George", "Silver");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }
    public void addAccount(Account theAccount)
    {
        System.out.println(getClass() + "Doing my DB work: Adding account");
    }

    public String getName()
    {
//        System.out.println("in getName()");
        return name;
    }

    public String getServiceCode()
    {
//        System.out.println("in getServiceCode()");
        return serviceCode;
    }

    public void setName(String name)
    {
//        System.out.println("in setName()");
        this.name = name;
    }

    public void setServiceCode(String serviceCode)
    {
//        System.out.println("in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
