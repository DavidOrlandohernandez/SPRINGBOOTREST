package com.local.credit.controller.dto;


import com.local.credit.advice.validation.anotation.ValidName;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerDto {

    private Long id;

    @ValidName()
    private String name;

    @ValidName()
    private String address;
    private String phone;
    private String email;
    private String description;
}
