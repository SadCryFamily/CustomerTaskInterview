package com.example.demo.mapper;

import com.example.demo.dto.CustomerViewDto;
import com.example.demo.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerViewDto toCustomerDto(Customer customer);

    Customer toCustomerEntity(CustomerViewDto customerViewDto);

}
