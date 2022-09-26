package org.example.exercise2;


public class CustomerDaoImp implements CustomerDao {

    private Customers customer;

    public CustomerDaoImp(Customers customer) {
        this.customer = customer;
    }

    @Override
    public String displayCustomers() {
        return customer.toString();
    }
}
