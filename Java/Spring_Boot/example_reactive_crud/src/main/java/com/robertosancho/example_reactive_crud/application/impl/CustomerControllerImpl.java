package com.robertosancho.example_reactive_crud.application.impl;

import javax.annotation.PostConstruct;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robertosancho.example_reactive_crud.application.CustomerController;
import com.robertosancho.example_reactive_crud.application.requestObject.CustomerRequest;
import com.robertosancho.example_reactive_crud.domains.customer.Customer;
import com.robertosancho.example_reactive_crud.domains.customer.ports.inbound.CustomerInboundPort;

@RestController
@RequestMapping("/customers")
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    CustomerInboundPort customerInboundPort;

    @Override
    @GetMapping
    public Publisher<Customer> getCustomers() {
        return customerInboundPort.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Publisher<Customer> getCustomer(@PathVariable("id") String id) {
        return customerInboundPort.findById(id);
    }

    @Override
    @PostMapping
    public Publisher<Customer> createCustomer(@RequestBody CustomerRequest customer) {
        return customerInboundPort.save(customer);
    }

    @Override
    @PutMapping("/{id}")
    public Publisher<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody CustomerRequest customer) {
        return customerInboundPort.update(id, customer);
    }

    @Override
    @DeleteMapping("/{id}")
    public Publisher<Void> deleteCustomer(@PathVariable("id") String id) {
        return customerInboundPort.delete(id);
    }

    
    
}
    
