package com.freudromero.springdemo.dao;

import com.freudromero.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
}
