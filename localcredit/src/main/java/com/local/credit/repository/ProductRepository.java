package com.local.credit.repository;

import com.local.credit.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    //Buscar Productos por Rango de Precio -- List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findProductsByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);


    //Buscar Productos por Nombre Similar (con LIKE) -- List<Product> findByNameContaining(String name);
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    List<Product> findProductsByNameContains(@Param("name") String name);

    //Buscar Productos con Cantidad Mayor a un Valor -- List<Product> findByQuantityGreaterThan(int quantity);
    @Query("SELECT p FROM Product p WHERE p.quantity > :quantity")
    List<Product> findProductsWithQuantityGreaterThan(@Param("quantity") int quantity);

    // Obtener el Producto con el Precio más Alto -- Product findTopByOrderByPriceDesc();
    @Query("SELECT p FROM Product p ORDER BY p.price DESC")
    List<Product> findTop1ByOrderByPriceDesc(Pageable pageable);

    // Actualizar el Precio de un Producto por su ID

    /*default void updateProductPrice(Long id, BigDecimal price) {
    Product product = findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    product.setPrice(price);
    save(product);
    }*/
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price = :price WHERE p.id = :id")
    void updateProductPrice(@Param("id") Long id, @Param("price") BigDecimal price);

    //Eliminar Productos por su Nombre --void deleteByName(String name);
    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.name = :name")
    void deleteProductsByName(@Param("name") String name);

    //Contar Productos por Rango de Precios -- long countByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    @Query("SELECT COUNT(p) FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    long countProductsByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);


    //Buscar los 5 Productos más Caros -- List<Product> findTop5ByOrderByPriceDesc();
    @Query("SELECT p FROM Product p ORDER BY p.price DESC")
    List<Product> findTop5ByOrderByPriceDesc(Pageable pageable);

}


