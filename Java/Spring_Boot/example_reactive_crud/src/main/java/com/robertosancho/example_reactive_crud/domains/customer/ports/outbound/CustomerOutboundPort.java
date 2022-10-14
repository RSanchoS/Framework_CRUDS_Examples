package com.robertosancho.example_reactive_crud.domains.customer.ports.outbound;

import com.robertosancho.example_reactive_crud.domains.customer.Customer;
import com.robertosancho.example_reactive_crud.domains.customer.entities.CustomerEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerOutboundPort {
        
            Mono<CustomerEntity> save(Customer customer);
        
            Mono<CustomerEntity> update(Customer customer);
        
            Mono<Void> delete(String id);
        
            Mono<CustomerEntity> findById(String id);
        
            Flux<CustomerEntity> findAll();
    
}
