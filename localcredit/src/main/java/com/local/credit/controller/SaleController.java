package com.local.credit.controller;

import com.local.credit.controller.dto.SaleDto;
import com.local.credit.controller.dto.SaleInfoDto;
import com.local.credit.entities.Customer;
import com.local.credit.entities.Product;
import com.local.credit.entities.Sale;
import com.local.credit.service.ICustomerService;
import com.local.credit.service.IProductService;
import com.local.credit.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/local/credit/sale")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProductService productService;


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<SaleDto> saleDto = saleService.findAll()
                .stream()
                .map(sale -> SaleDto.builder()
                        .id(sale.getId())
                        .customerId(sale.getCustomer().getId())
                        .date(sale.getDate())
                        .productsList(sale.getProductsList())
                        .build()).
                toList();
        return ResponseEntity.ok(saleDto);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody SaleDto saleDto) throws URISyntaxException {

        if(saleDto.getCustomerId() <= 0){
            return ResponseEntity.badRequest().body("Customer ID inválido");
        }

        Optional customerOptional = customerService.findById(saleDto.getCustomerId());

        if(!customerOptional.isPresent()){
            ResponseEntity.badRequest().body("Customer not found");
        }

        Customer customer = (Customer) customerOptional.get();

        // Recuperar y asociar los productos existentes
        List<Product> managedProducts = new ArrayList<>();
        for (Product product : saleDto.getProductsList()) {
            // Si el producto tiene un ID, asumimos que ya existe en la base de datos
            if (product.getId() != null) {
                Product managedProduct = productService.findById(product.getId().intValue()).orElseThrow(
                        () -> new IllegalArgumentException("Product no encontrado")
                );
                managedProducts.add(managedProduct);
            } else {
                // Si no tiene ID, es un producto nuevo, lo añadimos como nuevo
                managedProducts.add(product);
            }
        }

        // Crear y guardar la venta con los productos gestionados
        Sale sale = Sale.builder()
                .customer(customer) // Asociar el Customer recuperado
                .productsList(managedProducts) // Usar los productos gestionados
                .date(saleDto.getDate())
                .build();

        try {
            saleService.save(sale); // Guardar la venta
        } catch (DataIntegrityViolationException  e) {
            return ResponseEntity.badRequest().body("Error de integridad: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la venta: " + e.getMessage());
        }

        return ResponseEntity.created(new URI("/api/local/credit")).build();
    }

    @GetMapping("/saleInfo")
    public ResponseEntity<?> findSaleInfo() {
        List<SaleInfoDto> saleInfo = saleService.getSalesInfo();
        return ResponseEntity.ok(saleInfo);
    }
}
