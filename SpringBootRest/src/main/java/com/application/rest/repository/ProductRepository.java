package com.application.rest.repository;

import com.application.rest.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    // Para realizar metodos fuera del repository podemos usar notacion  QUERY y QUERYMETHODS
    // PARA QUERYS CUSTOM LOSQUERY METHODS TE PERMITEN ORGANIZAR ALGO ESPECIFICO
    //QUERY METHODS
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    //QUERY  JPQL  (p.price >= ?1 AND p.price <= ?2) TAMBIEN PODEMOS APLICAR BETWEEN
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

}
