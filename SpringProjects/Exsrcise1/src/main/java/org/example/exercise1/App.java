package org.example.exercise1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App
{
    static Logger logger=Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        CustomerDaoImp user1= (CustomerDaoImp) context.getBean("users");
        logger.log(Level.INFO,"{0}",user1.dispalyCustomer());
    }
}
