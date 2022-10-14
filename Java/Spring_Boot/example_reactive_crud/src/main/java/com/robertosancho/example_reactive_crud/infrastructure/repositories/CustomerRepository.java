package com.robertosancho.example_reactive_crud.infrastructure.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.robertosancho.example_reactive_crud.domains.customer.entities.CustomerEntity;

public interface CustomerRepository extends ReactiveMongoRepository<CustomerEntity, String> {

}
    
