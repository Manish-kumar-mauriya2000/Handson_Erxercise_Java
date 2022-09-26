package org.example.exercise3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestExercise3 {
    static Logger logger=Logger.getLogger(TestExercise3.class.getName());
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        CustomerDaoImp customer1= (CustomerDaoImp) context.getBean("customerDaoImp");
        logger.log(Level.INFO,"{0}",customer1.displayCustomers());
    }
}
