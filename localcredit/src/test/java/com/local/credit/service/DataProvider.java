package com.local.credit.service;

import com.local.credit.entities.Customer;

import java.util.List;

public class DataProvider {

    public static List<Customer> customerListMocks(){
        System.out.println("-> Test Customer | Mocks");
        return List.of(
                new Customer(1L, "David Orlando uno", "Vistas del lago","6674941679", "david@gmail.com", "Mujer"),
                new Customer(2L, "David Orlando dos", "Vistas del lago","6674941679", "david@gmail.com", "Mujer"),
                new Customer(3L, "David Orlando tres", "Vistas del lago","6674941679", "david@gmail.com", "Mujer")
        );
    }
}
