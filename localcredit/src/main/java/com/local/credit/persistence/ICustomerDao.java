package com.local.credit.persistence;

import com.local.credit.entities.Customer;
import com.local.credit.entities.Sale;

import java.util.List;
import java.util.Optional;

public interface ICustomerDao {
    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void deleteById(Long id);
}
