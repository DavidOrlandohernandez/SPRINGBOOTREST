package com.local.credit.controller;

import com.local.credit.controller.dto.CustomerDto;
import com.local.credit.controller.dto.ProductDto;
import com.local.credit.entities.Customer;
import com.local.credit.entities.Product;
import com.local.credit.persistence.IProductDao;
import com.local.credit.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/local/credit/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<ProductDto> productDto = productService.findAll()
                .stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .quantity(product.getQuantity())
                        .build())
                .sorted(Comparator.comparing(ProductDto::getId)).
                toList();
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Product> optionalProduct = productService.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            ProductDto productDto = ProductDto
                    .builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .description(product.getDescription())
                    .quantity(product.getQuantity())
                    .build();
            return ResponseEntity.ok(productDto);

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) throws URISyntaxException {

        if(productDto.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        productService.save(Product
                .builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .quantity(productDto.getQuantity())
                .build());
        return ResponseEntity.created(new URI("/api/local/credit")).build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws URISyntaxException {
        Optional<Product> optionalProduct = productService.findById(id);

        if (optionalProduct.isPresent()) {
            productService.deleteById(id);
            return ResponseEntity.ok("Elemento eliminado como suceso");
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody ProductDto productDto) throws URISyntaxException {

        Optional<Product> optionalProduct = productService.findById(id);

        if(!optionalProduct.isPresent()){
            ResponseEntity.badRequest().body("Elemento no encontrado para actualizar");
        }

        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        productService.save(product);

        return ResponseEntity.ok(productDto);
    }

}
