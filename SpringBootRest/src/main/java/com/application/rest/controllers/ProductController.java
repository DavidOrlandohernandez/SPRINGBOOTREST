package com.application.rest.controllers;

import com.application.rest.controllers.dto.ProductDto;
import com.application.rest.entities.Product;
import com.application.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        Optional<Product> productOptional = productService.findById(id);
        //Es mala practtica retornar o recibir entidades de una vez.
        //Por buenas practicas de programacion se tiene que enviar un DTO.
        // return ResponseEntity.ok(makerOptional.get());
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            ProductDto productDto =  ProductDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();

            return ResponseEntity.ok(productDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findALL")
    public ResponseEntity<?> findALL(){
        List<ProductDto> productList = productService.findAll()
                .stream()
                .map(product-> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/findByRange/{min}/{max}")
    public ResponseEntity<?> findByRange(@PathVariable BigDecimal min, @PathVariable BigDecimal max)
    {
        if( min.compareTo(new BigDecimal(0)) <= 0 || max.compareTo(new BigDecimal(0)) <= 0 ){
            return ResponseEntity.badRequest().build();
        }

        List<ProductDto> productDtoList = productService.findByPriceInRange(min, max)
                .stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build()).
                toList();
        return  ResponseEntity.ok(productDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) throws URISyntaxException {

        if(productDto.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        productService.save(Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .maker(productDto.getMaker())
                .build());
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductDto productDto) throws URISyntaxException {

        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setMaker(productDto.getMaker());
            productService.save(product);
            return ResponseEntity.ok("Registro Actualizado como sucesso");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) throws URISyntaxException {
        if(id!=0){
            productService.deleteById(id);
            return ResponseEntity.ok("Registro Excluido como sucesso");
        }
        return ResponseEntity.badRequest().build();
    }

}
