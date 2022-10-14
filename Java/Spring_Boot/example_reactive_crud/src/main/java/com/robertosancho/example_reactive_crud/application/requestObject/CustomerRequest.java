package com.robertosancho.example_reactive_crud.application.requestObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequest {

    private String name;

    private String email;
    
}
