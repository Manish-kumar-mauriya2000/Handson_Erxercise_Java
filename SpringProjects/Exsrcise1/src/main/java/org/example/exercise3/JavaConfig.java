package org.example.exercise3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.example.exercise3")
public class JavaConfig {

    @Bean
    public CustomerDaoImp customerDaoImp(){
        CustomerDaoImp customerDaoImp=new CustomerDaoImp();
        customerDaoImp.setCustomer(customer());
        return customerDaoImp;
    }

    @Bean
    public List<Customer> customer(){
        List<Customer> customerList= new ArrayList<>();
        Customer customer1=new Customer();
        customer1.setUserId(301);
        customer1.setUserName("Manish");
        customer1.setEmail("manish@example.com");
        customer1.getMobileNumber(9876765);
        customer1.setCity("Erode");
        customerList.add(customer1);
        return customerList;
    }
}
