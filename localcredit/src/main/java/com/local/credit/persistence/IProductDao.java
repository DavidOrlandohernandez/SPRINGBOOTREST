package com.local.credit.persistence;

import com.local.credit.entities.Product;
import com.local.credit.entities.Sale;

import java.util.List;
import java.util.Optional;

public interface IProductDao {

    List<Product> findAll();

    Optional<Product> findById(int id);

    void save(Product product);

    void deleteById(int id);
}
