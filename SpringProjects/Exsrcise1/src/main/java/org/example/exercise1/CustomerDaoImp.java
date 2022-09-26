package org.example.exercise1;


public class CustomerDaoImp implements CustomerDao {
    private Customers customer;

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    @Override
    public String dispalyCustomer() {
        return  customer.toString();
    }


}
