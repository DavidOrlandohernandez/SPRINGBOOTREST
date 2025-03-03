package com.local.credit.service;

import com.local.credit.entities.Product;
import com.local.credit.persistence.IProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productService;

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productService.findById(id);
    }

    @Override
    public void save(Product product) {
        productService.save(product);
    }

    @Override
    public void deleteById(int id) {
        productService.deleteById(id);
    }

}
