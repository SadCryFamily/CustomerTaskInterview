package com.example.demo.controller;

import com.example.demo.dto.CustomerViewDto;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/find")
    public CustomerViewDto retrieveCustomerById(@RequestParam("id") Long id) {
        return customerService.retrieveCustomerById(id);
    }

}
