package com.freudromero.springdemo.controller;

import com.freudromero.springdemo.dao.CustomerDAO;
import com.freudromero.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // Inject the customer dao
    @Autowired
    private CustomerDAO customerDAO;


    @RequestMapping("/list")
    public String listCustomers(Model theModel) {

        // get customers from the dao
        List<Customer> theCustomers = customerDAO.getCustomers();

        // Add the customers to the model
        theModel.addAttribute("customers", theCustomers);


        return "list-customers";
    }
}
