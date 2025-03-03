package com.local.credit.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name =  "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "sale_products_list", joinColumns = @JoinColumn(name = "sale_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonIgnore
    private List<Product> productsList;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
