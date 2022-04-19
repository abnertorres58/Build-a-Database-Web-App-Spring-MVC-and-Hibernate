package com.freudromero.springdemo.service;

import com.freudromero.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
