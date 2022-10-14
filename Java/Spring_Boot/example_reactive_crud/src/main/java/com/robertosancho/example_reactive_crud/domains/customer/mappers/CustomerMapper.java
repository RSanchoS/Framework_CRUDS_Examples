package com.robertosancho.example_reactive_crud.domains.customer.mappers;

import org.springframework.stereotype.Component;

import com.robertosancho.example_reactive_crud.application.requestObject.CustomerRequest;
import com.robertosancho.example_reactive_crud.domains.customer.Customer;
import com.robertosancho.example_reactive_crud.domains.customer.entities.CustomerEntity;

import reactor.core.publisher.Mono;

@Component
public class CustomerMapper {

    public Mono<CustomerEntity> map(Mono<Customer> customer){
        return customer.flatMap(c -> Mono.just(CustomerEntity.builder()
                .id(c.getId())
                .name(c.getName())
                .email(c.getEmail())
                .build()));
    }

    public Customer map(CustomerEntity customer){
        
        return Customer.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }

    public Customer map(CustomerRequest customer){
        
        return Customer.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }

    public CustomerEntity map(Customer customer){
        
        return CustomerEntity.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
    
}
