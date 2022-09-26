package org.example.exercise4;

import java.util.List;

public class CustomerDaoImp implements CustomerDao {
    private List<Customer> customer;

    public CustomerDaoImp(List<Customer> customer) {
        this.customer = customer;
    }

    @Override
    public String displayCustomers() {
        return customer.toString();
    }
}
