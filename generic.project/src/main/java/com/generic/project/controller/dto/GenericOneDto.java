package com.generic.project.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.generic.project.entities.GenericTwo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class GenericOneDto {

    private Long id;
    private String name;
    private String colonia;
    private int estado;
    private int numero;
    private List<GenericTwo> genericTwo;

}
