package com.robertosancho.example_reactive_crud.application;

import org.reactivestreams.Publisher;

import com.robertosancho.example_reactive_crud.application.requestObject.CustomerRequest;
import com.robertosancho.example_reactive_crud.domains.customer.Customer;


public interface CustomerController {

    public Publisher<Customer> getCustomers();

    public Publisher<Customer> getCustomer(String id);

    public Publisher<Customer> createCustomer(CustomerRequest customer);

    public Publisher<Customer> updateCustomer(String id, CustomerRequest customer);

    public Publisher<Void> deleteCustomer(String id);
    
}
