package com.local.credit.service;

import com.local.credit.entities.Customer;
import com.local.credit.persistence.ICustomerDao;
import com.local.credit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerDao customerService;

    @Override
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerService.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerService.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerService.deleteById(id);
    }
}
