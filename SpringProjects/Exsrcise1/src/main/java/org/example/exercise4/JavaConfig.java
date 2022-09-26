package org.example.exercise4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.example.exercise4")
public class JavaConfig {

    @Bean
    public CustomerDaoImp customerDaoImp(){
       return new CustomerDaoImp(customer());
    }

    @Bean
    public List<Customer> customer(){
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer(401,"Ram","ram@gmail.com",12365478,"Gobi");
        Customer customer2 = new Customer(402,"Ramu","ramu@gmail.com",952365478,"sakthi");
        customerList.add(customer1);
        customerList.add(customer2);
        return customerList;

    }


}
