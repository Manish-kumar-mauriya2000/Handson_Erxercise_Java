package org.example.exercise3;

import java.util.List;

public class CustomerDaoImp implements CustomerDao {

    private List<Customer> customer;

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    @Override
    public String displayCustomers() {
        return customer.toString();
    }
}
