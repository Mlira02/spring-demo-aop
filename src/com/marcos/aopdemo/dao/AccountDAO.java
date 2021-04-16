package com.marcos.aopdemo.dao;

import com.marcos.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO
{
//    Fields
    private String name;
    private String serviceCode;


//    Methods
    public void addAccount(Account theAccount)
    {
        System.out.println(getClass() + "Doing my DB work: Adding account");
    }

    public String getName()
    {
        System.out.println("in getName()");
        return name;
    }

    public String getServiceCode()
    {
        System.out.println("in getServiceCode()");
        return serviceCode;
    }

    public void setName(String name)
    {
        System.out.println("in setName()");
        this.name = name;
    }

    public void setServiceCode(String serviceCode)
    {
        System.out.println("in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
