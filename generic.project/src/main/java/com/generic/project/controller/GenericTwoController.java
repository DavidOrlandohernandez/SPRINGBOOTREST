package com.generic.project.controller;


import com.generic.project.controller.dto.GenericOneDto;
import com.generic.project.controller.dto.GenericTwoDto;
import com.generic.project.entities.GenericOne;
import com.generic.project.entities.GenericTwo;
import com.generic.project.service.IGenericTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController()
@RequestMapping("/api/generic/almacenes")
public class GenericTwoController {

    @Autowired
    private IGenericTwoService genericTwoService;


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<GenericTwoDto> genericTwoDtoList = genericTwoService.findAll()
                .stream()
                .map(genericTwo -> GenericTwoDto.builder()
                        .id(genericTwo.getId())
                        .name(genericTwo.getName())
                        .address(genericTwo.getAddress())
                        .build())
                .toList();
        return ResponseEntity.ok(genericTwoDtoList);
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody GenericTwoDto genericTwoDto) throws URISyntaxException {

        if(genericTwoDto.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        genericTwoService.save(GenericTwo
                .builder()
                        .name(genericTwoDto.getName())
                        .address(genericTwoDto.getAddress())
                .build());

        return ResponseEntity.created(new URI("/api/local/credit")).build();
    }
}
