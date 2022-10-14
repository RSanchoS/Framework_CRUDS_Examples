package com.robertosancho.example_reactive_crud.domains.customer.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "customer-test")
@Builder
public class CustomerEntity {

    @Id
    private String id;

    private String name;

    private String email;


    
}
