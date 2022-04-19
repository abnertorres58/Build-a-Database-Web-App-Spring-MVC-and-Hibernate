package com.freudromero.springdemo.controller;

import com.freudromero.springdemo.dao.CustomerDAO;
import com.freudromero.springdemo.entity.Customer;
import com.freudromero.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        // Create model attribute to bind from data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer (@ModelAttribute("customer") Customer theCustomer) {

        // Save our customer using our service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

        // Get the customer from our Service
        Customer theCustomer = customerService.getCustomer(theId);

        // Set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        // Send over to our form
        return "customer-form";

    }


}
