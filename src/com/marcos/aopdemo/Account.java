package com.marcos.aopdemo;

import java.util.List;

public class Account
{
//    Fields
    private String name;
    private String level;


//    Constructors
public Account() { }

public Account(String theName, String theLevel)
{
    name = theName;
    level = theLevel;
}

//    Methods
    public String getName()
    {
        return name;
    }

    public String getLevel()
    {
        return level;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    @Override
    public String toString()
    {
        return "Account{" + "name='" + name + '\'' + ", level='" + level + '\'' + '}';
    }
}
