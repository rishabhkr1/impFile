package com.daytona.fooddeliveryapp.dto;

import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Data
public class CustomerDTO {

    private String name;
    private String email;
    private long phoneNumber;
}
