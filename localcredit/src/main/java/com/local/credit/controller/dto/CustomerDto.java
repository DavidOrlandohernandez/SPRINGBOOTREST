package com.local.credit.controller.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerDto {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String description;
}
