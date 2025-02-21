package com.daytona.fooddeliveryapp.controller;

import com.daytona.fooddeliveryapp.dto.CustomerDTO;
import com.daytona.fooddeliveryapp.dto.CustomerResponseDTO;
import com.daytona.fooddeliveryapp.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")
@AllArgsConstructor
public class CustomerController {

    public ICustomerService customerService;
     @PostMapping("/register")
      public ResponseEntity<CustomerResponseDTO>  createCustomer(@RequestBody CustomerDTO customerDTO ){
        return ResponseEntity.ok( customerService.createCustomer(customerDTO));
     }
}
