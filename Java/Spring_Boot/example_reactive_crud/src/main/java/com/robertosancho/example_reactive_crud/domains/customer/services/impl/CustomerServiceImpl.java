package com.robertosancho.example_reactive_crud.domains.customer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertosancho.example_reactive_crud.domains.customer.Customer;
import com.robertosancho.example_reactive_crud.domains.customer.mappers.CustomerMapper;
import com.robertosancho.example_reactive_crud.domains.customer.ports.outbound.CustomerOutboundPort;
import com.robertosancho.example_reactive_crud.domains.customer.services.CustomerService;
import com.robertosancho.example_reactive_crud.infrastructure.repositories.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerOutboundPort customerOutboundPort;

    @Autowired
    CustomerMapper customerMapper;

    public Mono<Customer> save(Customer customer) {

        return customerOutboundPort
        .save(customer)
        .flatMap(c -> Mono.just(customerMapper.map(c)));

    }

    public Mono<Void> delete(String id) {
        
        return customerOutboundPort
        .findById(id)
        .flatMap(c -> customerOutboundPort.delete(c.getId()));
    }

    public Mono<Customer> findById(String id) {
        return customerOutboundPort
        .findById(id)
        .flatMap(c -> Mono.just(customerMapper.map(c)));
    }

    public Flux<Customer> findAll() {
        return customerOutboundPort
        .findAll()
        .flatMap(c -> Mono.just(customerMapper.map(c)));
    }

    @Override
    public Mono<Customer> update(String id, Customer customer) {
        return customerOutboundPort
        .findById(id)
        .flatMap(c -> {
            return customerOutboundPort
                .save(Customer.builder()
                    .id(id)
                    .name(customer.getName())
                    .email(customer.getEmail())
                    .build())
                .flatMap(c2 -> Mono.just(customerMapper.map(c2)));
        });
    }
    
}
 