package com.local.credit.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.local.credit.entities.Customer;
import com.local.credit.entities.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDto {

    private Long id;
    private Long customerId;
    private List<Product> productsList;
    private LocalDate date;

}
