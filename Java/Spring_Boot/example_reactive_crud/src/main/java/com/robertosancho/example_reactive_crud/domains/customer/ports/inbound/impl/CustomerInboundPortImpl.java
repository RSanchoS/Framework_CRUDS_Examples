package com.robertosancho.example_reactive_crud.domains.customer.ports.inbound.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robertosancho.example_reactive_crud.application.requestObject.CustomerRequest;
import com.robertosancho.example_reactive_crud.domains.customer.Customer;
import com.robertosancho.example_reactive_crud.domains.customer.mappers.CustomerMapper;
import com.robertosancho.example_reactive_crud.domains.customer.ports.inbound.CustomerInboundPort;
import com.robertosancho.example_reactive_crud.domains.customer.services.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerInboundPortImpl implements CustomerInboundPort{

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Mono<Customer> save(CustomerRequest customer) {
        return customerService.save(customerMapper.map(customer));
    }

    @Override
    public Mono<Customer> update(String id, CustomerRequest customer) {
        return customerService.update(id, customerMapper.map(customer));
    }

    @Override
    public Mono<Void> delete(String id) {
        return customerService.delete(id);
    }

    @Override
    public Mono<Customer> findById(String id) {
        return customerService.findById(id);
    }

    @Override
    public Flux<Customer> findAll() {
        return customerService.findAll();
    }
    
}
