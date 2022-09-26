package org.example.exercise2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestExercise2 {
    static Logger logger=Logger.getLogger(TestExercise2.class.getName());
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("ContructorConfig.xml");
        CustomerDaoImp user1= (CustomerDaoImp) context.getBean("users");
        logger.info("Constructor called...");
        logger.log(Level.INFO,"{0}",user1.displayCustomers());

    }
}
