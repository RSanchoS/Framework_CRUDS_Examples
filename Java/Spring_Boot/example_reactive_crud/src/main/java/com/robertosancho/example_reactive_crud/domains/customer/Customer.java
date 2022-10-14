package com.robertosancho.example_reactive_crud.domains.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private String id;

    private String name;

    private String email;
    
}
