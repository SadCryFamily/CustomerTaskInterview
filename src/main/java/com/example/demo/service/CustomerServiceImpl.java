package com.example.demo.service;

import com.example.demo.dto.CustomerViewDto;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerViewDto retrieveCustomerById(Long id) {

        Customer customer = customerRepository.getCustomerById(id);

        return customerMapper.toCustomerDto(customer);

    }
}
