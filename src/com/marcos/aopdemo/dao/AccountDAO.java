package com.marcos.aopdemo.dao;

import com.marcos.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO
{
    public void addAccount(Account theAccount)
    {
        System.out.println(getClass() + "Doing my DB work: Adding account");
    }
}
