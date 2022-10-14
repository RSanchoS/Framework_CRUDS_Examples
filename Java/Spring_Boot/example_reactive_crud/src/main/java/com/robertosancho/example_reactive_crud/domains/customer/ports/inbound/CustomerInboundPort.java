package com.robertosancho.example_reactive_crud.domains.customer.ports.inbound;

import com.robertosancho.example_reactive_crud.application.requestObject.CustomerRequest;
import com.robertosancho.example_reactive_crud.domains.customer.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerInboundPort {

    Mono<Customer> save(CustomerRequest customer);
        
    Mono<Customer> update(String id, CustomerRequest customer);

    Mono<Void> delete(String id);

    Mono<Customer> findById(String id);

    Flux<Customer> findAll();
    
}
