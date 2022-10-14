package com.robertosancho.example_reactive_crud.domains.customer.services;


import com.robertosancho.example_reactive_crud.domains.customer.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    
        Mono<Customer> save(Customer customer);
    
        Mono<Customer> update(String id, Customer customer);
    
        Mono<Void> delete(String id);
    
        Mono<Customer> findById(String id);
    
        Flux<Customer> findAll();
}
