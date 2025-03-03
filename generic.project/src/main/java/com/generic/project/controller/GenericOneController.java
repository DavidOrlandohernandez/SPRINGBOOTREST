package com.generic.project.controller;

import com.generic.project.controller.dto.GenericOneDto;
import com.generic.project.entities.GenericOne;
import com.generic.project.service.IGenericOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/generic/sucursales")
public class GenericOneController {

    @Autowired
    private IGenericOneService genericOneService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<GenericOneDto> productDto = genericOneService.findAll()
                .stream()
                .map(genericOne -> GenericOneDto.builder()
                        .id(genericOne.getId())
                        .name(genericOne.getName())
                        .colonia(genericOne.getColonia())
                        .numero(genericOne.getNumero())
                        .estado(genericOne.getEstado())
                        .genericTwo(genericOne.getGenericTwo())
                        .build())
                .toList();
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<GenericOne> optionalGenericOne = genericOneService.findById(id);

        if (optionalGenericOne.isPresent()) {
            GenericOne genericOne = optionalGenericOne.get();
            GenericOneDto oneDto = GenericOneDto
                    .builder()
                    .id(genericOne.getId())
                    .build();
            return ResponseEntity.ok(oneDto);

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody GenericOneDto genericOneDto) throws URISyntaxException {

        if(genericOneDto.getId() <= 0){
            return ResponseEntity.badRequest().build();
        }
        genericOneService.save(GenericOne
                .builder()
                /*.name(genericOneDto.getName())*/
                .build());
        return ResponseEntity.created(new URI("/api/local/credit")).build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws URISyntaxException {
        Optional<GenericOne> optionalGenericOne = genericOneService.findById(id);

        if (optionalGenericOne.isPresent()) {
            genericOneService.deleteById(id);
            return ResponseEntity.ok("Elemento eliminado como suceso");
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody GenericOneDto genericOneDto) throws URISyntaxException {

        Optional<GenericOne> optionalGenericOne = genericOneService.findById(id);

        if(!optionalGenericOne.isPresent()){
            ResponseEntity.badRequest().body("Elemento no encontrado para actualizar");
        }

        GenericOne genericOne = optionalGenericOne.get();
        /*genericOne.setName(GenericOneDto.getName());*/
        genericOneService.save(genericOne);

        return ResponseEntity.ok(genericOne);
    }

}
