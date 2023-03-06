package com.example.demo.service;

import com.example.demo.dto.CustomerViewDto;

public interface CustomerService {

    CustomerViewDto retrieveCustomerById(Long id);

}
