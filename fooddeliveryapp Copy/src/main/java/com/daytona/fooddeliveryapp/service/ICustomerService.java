package com.daytona.fooddeliveryapp.service;
import com.daytona.fooddeliveryapp.dto.CustomerDTO;
import com.daytona.fooddeliveryapp.dto.CustomerResponseDTO;

public interface ICustomerService {

     CustomerResponseDTO createCustomer(CustomerDTO customerDTO);
}
