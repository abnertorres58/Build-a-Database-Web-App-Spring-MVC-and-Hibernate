package com.freudromero.springdemo.dao;

import com.freudromero.springdemo.entity.Customer;
import com.mysql.cj.xdevapi.SessionImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
    // Inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

        // Execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // Return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Save the customer
        currentSession.save(theCustomer);

    }
}
