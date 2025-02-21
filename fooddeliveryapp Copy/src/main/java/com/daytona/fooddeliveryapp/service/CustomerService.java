package com.daytona.fooddeliveryapp.service;
import com.daytona.fooddeliveryapp.dto.CustomerDTO;
import com.daytona.fooddeliveryapp.dto.CustomerResponse;
import com.daytona.fooddeliveryapp.dto.CustomerResponseDTO;
import com.daytona.fooddeliveryapp.repository.CustomerRepository;
import com.daytona.fooddeliveryapp.entity.CustomerDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerService implements ICustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDAO registerCustomer(CustomerDAO customerDAO) {
        log.info("The customer details are :{}", customerDAO);
        return customerRepository.save(customerDAO);
    }

    public CustomerDAO findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }


    public List<CustomerResponse> getAllCustomer(){
        List<CustomerResponse>customerResponse=new ArrayList<CustomerResponse>();

        List<CustomerDAO>customerDAOS=customerRepository.findAll();

        for(CustomerDAO customerDAO:customerDAOS){
            CustomerResponse response=new CustomerResponse();
            response.setEmail(customerDAO.getEmail());
            response.setName(customerDAO.getName());
            customerResponse.add(response);
        }
        return customerResponse;
    }

    public CustomerDAO deleteCustomerById(Long id){
         customerRepository.deleteById(id);
         return null;
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerDTO customerDTO) {

        CustomerDAO customerDAO = mapTOCustomerDAO(customerDTO);
        CustomerDAO getcustomerDAO=customerRepository.save(customerDAO);
        CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
        customerResponseDTO.setId(getcustomerDAO.getId());
        return customerResponseDTO;
    }

    private CustomerDAO mapTOCustomerDAO(CustomerDTO customerDTO) {

        CustomerDAO customerDAO =new CustomerDAO();
        customerDAO.setName(customerDTO.getName());
        customerDAO.setEmail(customerDTO.getEmail());
        customerDAO.setPhoneNumber(customerDTO.getPhoneNumber());
        return customerDAO;
    }
}
