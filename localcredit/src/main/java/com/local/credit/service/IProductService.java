package com.local.credit.service;

import com.local.credit.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    Optional<Product> findById(int id);

    void save(Product product);

    void deleteById(int id);

}
