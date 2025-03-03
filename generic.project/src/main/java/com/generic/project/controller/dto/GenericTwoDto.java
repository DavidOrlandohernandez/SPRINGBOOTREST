package com.generic.project.controller.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class GenericTwoDto {

    private Long id;
    private String name;
    private String address;
}
