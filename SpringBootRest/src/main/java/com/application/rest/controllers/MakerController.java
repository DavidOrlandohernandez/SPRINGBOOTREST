package com.application.rest.controllers;

import com.application.rest.controllers.dto.MakerDto;
import com.application.rest.entities.Maker;
import com.application.rest.repository.MakerRepository;
import com.application.rest.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {

    @Autowired
    private IMakerService makerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
      Optional<Maker> makerOptional = makerService.findById(id);
        //Es mala practtica retornar o recibir entidades de una vez.
        //Por buenas practicas de programacion se tiene que enviar un DTO.
        // return ResponseEntity.ok(makerOptional.get());
      if (makerOptional.isPresent()) {
          Maker maker = makerOptional.get();

          MakerDto makerDto =  MakerDto.builder()
                  .id(maker.getId())
                  .name(maker.getName())
                  .productList(maker.getProductList())
                  .build();

          return ResponseEntity.ok(makerDto);
      }
      return ResponseEntity.notFound().build();
    }

    @GetMapping("/findALL")
    public ResponseEntity<?> findALL(){
        List<MakerDto> makerList = makerService.findAll()
                .stream()
                .map(maker -> MakerDto.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build())
                .toList();
        return ResponseEntity.ok(makerList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDto makerDto) throws URISyntaxException {

        if(makerDto.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
            makerService.save(Maker.builder()
                    .name(makerDto.getName())
                    .build());
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody MakerDto makerDto) throws URISyntaxException {

        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setName(makerDto.getName());
            makerService.save(maker);
            return ResponseEntity.ok("Registro Actualizado como sucesso");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) throws URISyntaxException {
        if(id!=null){
            makerService.deleteById(id);
            return ResponseEntity.ok("Registro Excluido como sucesso");
        }
        return ResponseEntity.badRequest().build();
    }
}
