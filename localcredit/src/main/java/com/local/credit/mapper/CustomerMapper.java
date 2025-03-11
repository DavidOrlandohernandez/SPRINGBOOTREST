package com.local.credit.mapper;

import com.local.credit.controller.dto.CustomerDto;
import com.local.credit.entities.Customer;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    /*Mapper de la clase Customer Objeto por Objeto One to One; */
    CustomerDto customerToCustomerDto(Customer customer);

    /*Mapper de la clase Customer Objeto por Objeto : Especificación de campos/ One to One; */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "email")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "description", target = "description")
    CustomerDto customerToCustomerEspecificDto(Customer customer);

    /*Mapper de la clase Customer Listas de muchos a muchos; */
    List<CustomerDto> customersToCustomersDto(List<Customer> customer);

    /*Mapper de la clase Customer Objeto por Objeto One to One; */
    Customer customerDtoToCustomer(CustomerDto customerDto);

}
