package com.example.demo.controller;

import com.example.demo.dto.CustomerViewDto;
import com.example.demo.service.CustomerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void retrieveCustomerById() throws Exception {

        CustomerViewDto customerViewDto = CustomerViewDto.builder()
                .firstName("Niko")
                .lastName("Stretto")
                .old(18).build();

        Mockito.when(customerService.retrieveCustomerById(Mockito.anyLong()))
                        .thenReturn(customerViewDto);

        mockMvc.perform(get("/find").param("id", "1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.firstName", Matchers.is("Niko")))
                .andExpect(jsonPath("$.lastName", Matchers.is("Stretto")))
                .andExpect(jsonPath("$.old", Matchers.is(18)));

    }
}