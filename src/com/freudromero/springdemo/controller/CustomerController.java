package com.freudromero.springdemo.controller;

import com.freudromero.springdemo.dao.CustomerDAO;
import com.freudromero.springdemo.entity.Customer;
import com.freudromero.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

   // Need to inject our customer service
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // Add the customers to the model
        theModel.addAttribute("customers", theCustomers);


        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        return "customer-form";
    }
}
