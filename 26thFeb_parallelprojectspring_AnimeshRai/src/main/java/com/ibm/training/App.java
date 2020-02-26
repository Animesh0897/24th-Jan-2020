package com.ibm.training;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml");
        DriverClass driverClass = context.getBean("Driver",DriverClass.class);
        driverClass.menu();
    }
}
