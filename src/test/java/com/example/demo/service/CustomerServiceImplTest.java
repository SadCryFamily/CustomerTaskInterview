package com.example.demo.service;

import com.example.demo.dto.CustomerViewDto;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void retrieveCustomerById() {

        CustomerViewDto expectedCustomerDto = CustomerViewDto.builder()
                .firstName("Nick")
                .lastName("Newell")
                .old(18).build();

        Customer testableCustomer = customerMapper.toCustomerEntity(expectedCustomerDto);
        Mockito.when(customerRepository.getCustomerById(Mockito.anyLong()))
                .thenReturn(testableCustomer);

        CustomerViewDto actualCustomerDto =
                customerService.retrieveCustomerById(Mockito.anyLong());

        assertEquals(expectedCustomerDto.toString(), actualCustomerDto.toString());

    }
}