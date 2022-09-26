package org.example.exercise4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestExercise4 {
    static Logger logger=Logger.getLogger(TestExercise4.class.getName());
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        CustomerDaoImp customers= (CustomerDaoImp) context.getBean("customerDaoImp");
        logger.log(Level.INFO,"{0}",customers.displayCustomers());

    }
}
