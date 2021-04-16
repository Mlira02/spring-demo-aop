package com.marcos.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO
{
    public void addMembership()
    {
        System.out.println(getClass() + " From a different DAO but with add in front of method");
    }
}
