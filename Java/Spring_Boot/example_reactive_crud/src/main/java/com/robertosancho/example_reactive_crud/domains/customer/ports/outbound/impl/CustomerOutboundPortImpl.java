package com.robertosancho.example_reactive_crud.domains.customer.ports.outbound.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robertosancho.example_reactive_crud.domains.customer.Customer;
import com.robertosancho.example_reactive_crud.domains.customer.entities.CustomerEntity;
import com.robertosancho.example_reactive_crud.domains.customer.mappers.CustomerMapper;
import com.robertosancho.example_reactive_crud.domains.customer.ports.outbound.CustomerOutboundPort;
import com.robertosancho.example_reactive_crud.infrastructure.repositories.CustomerRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomerOutboundPortImpl implements CustomerOutboundPort{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Mono<CustomerEntity> save(Customer customer) {
        return customerRepository
        .save(customerMapper.map(customer));
    }

    @Override
    public Mono<CustomerEntity> update(Customer customer) {
        return customerRepository
        .save(customerMapper.map(customer));
    }

    @Override
    public Mono<Void> delete(String id) {
        log.info("Deleting customer with id: {}", id);
        return customerRepository
        .deleteById(id);   
        
    }

    @Override
    public Mono<CustomerEntity> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Flux<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }


    
}
