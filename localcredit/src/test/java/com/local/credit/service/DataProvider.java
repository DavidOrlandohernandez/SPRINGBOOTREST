package com.local.credit.service;

import com.local.credit.entities.Customer;

import java.util.List;
import java.util.Optional;

public class DataProvider {

    public static List<Customer> customerListMocks(){
        System.out.println("-> Test Customer | Mocks | findAll");
        return List.of(
                new Customer(1L, "David Orlando uno", "Vistas del lago","6674941679", "david@gmail.com", "Mujer"),
                new Customer(2L, "David Orlando dos", "Vistas del lago","6674941679", "david@gmail.com", "Mujer"),
                new Customer(3L, "David Orlando tres", "Vistas del lago","6674941679", "david@gmail.com", "Mujer")
        );
    }

    public static Customer customerMock(){
        System.out.println("-> Test Customer | Mocks | findAll-one");
        Customer customer = new Customer(1L, "David Orlando uno", "Vistas del lago","6674941679", "david@gmail.com", "Mujer");
        return  customer;
    }

    public static Optional<Customer> optionalCustomerMock(){
        System.out.println("-> Test Customer | Mocks | findById");

        Customer customer = new Customer(3L, "David Orlando tres", "Vistas del lago","6674941679", "david@gmail.com", "Mujer");
        Optional<Customer> optionalCustomer = Optional.of(customer);

        return  optionalCustomer;
    }

    public static Customer customerNewMock(){
        System.out.println("-> Test Customer | Mocks | save");
        return new Customer(4L, "David Orlando cuatro", "Vistas del lago","6674941679", "david@gmail.com", "Hombre");
    }


}
