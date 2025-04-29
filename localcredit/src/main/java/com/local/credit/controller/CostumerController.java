package com.local.credit.controller;
import com.local.credit.controller.dto.CustomerDto;
import com.local.credit.entities.Customer;
import com.local.credit.mapper.CustomerMapper;
import com.local.credit.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/local/credit/customer")
@Tag(name = "Customer - Controller", description = "Controlador de clientes (Customer)")
public class CostumerController {

    @Autowired
    private ICustomerService customerService;

    @Operation(
            summary = "CONSULTA COMPLETA DE CLIENTES / FINDALL",
            description =  "Método creado para consultar toda la información de todos los clientes existentes",
            tags = {"BÚSQUEDA COMPLETA"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "No necesita body para la ejecución del método de consulta / GET",
                    required = false
            ),
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Successful (OK)",
                        content = @Content(
                                     mediaType = "application/json",
                                     schema = @Schema(implementation = CustomerDto.class)
                        )
                )
            }
    )
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<CustomerDto> customerDto = CustomerMapper.
                INSTANCE.customerList(customerService.findAll());
        /*List<CustomerDto> customerDtos = customerService.findAll()
                .stream()
                .map(customer -> CustomerDto.builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .address(customer.getAddress())
                        .phone(customer.getPhone())
                        .email(customer.getEmail())
                        .description(customer.getDescription())
                        .build()).
                toList();
        /*List<Customer> customerList = customerService.findAll();
        ResponseEntityGlobal response = new ResponseEntityGlobal();
        response.setMessage("Ok");
        response.setType(1);
        response.setData(customerList);*/
        return ResponseEntity.ok(customerDto);
    }

    @Operation(
            summary = "CONSULTA DE CLIENTES POR ID (CUSTOMERS) / FIND BY ID",
            description =  "Método creado para consultar toda la información de un cliente en especifico",
            tags = {"BÚSQUEDA POR IDENTIFICADOR"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "No necesita body para la ejecución del método de consulta / GET",
                    required = false
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful (OK)",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CustomerDto.class)
                            )
                    )
            }
    )
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
       Optional<Customer> optionalCustomer = customerService.findById((long)id);

       if (optionalCustomer.isPresent()) {
           Customer customer = optionalCustomer.get();

           CustomerDto customerDto = CustomerMapper.
                   INSTANCE.customerToCustomerDto(customer);
           /*CustomerDto
                   .builder()
                       .id(customer.getId())
                       .name(customer.getName())
                       .address(customer.getAddress())
                       .phone(customer.getPhone())
                       .email(customer.getEmail())
                       .description(customer.getDescription())
                   .build();*/

           return ResponseEntity.ok(customerDto);

       }
       return ResponseEntity.notFound().build();
    }

    @Operation(
            summary = "ALTA DE UN CLIENTE / SAVE",
            description =  "Método creado para almacenar toda la información de un cliente en especifico",
            tags = {"ALTA DE CLIENTE"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Estructura del cuerpo en formato Json de la clase Customer / POST",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDto.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "201 Created"
                    )
            }
    )
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid CustomerDto customerDto) throws URISyntaxException {
        if(customerDto.getName().isBlank()){ return ResponseEntity.badRequest().build(); }

        customerService.save(CustomerMapper.
                INSTANCE.customerDtoToCustomer(customerDto));
                /*Customer
                .builder()
                    .name(customerDto.getName())
                    .address(customerDto.getAddress())
                    .phone(customerDto.getPhone())
                    .email(customerDto.getEmail())
                    .description(customerDto.getDescription())
                .build());*/
        return ResponseEntity.created(new URI("/api/local/credit")).build();
    }

    @Operation(
            summary = "BAJA DE CLIENTES POR ID (ID-CUSTOMER) / DELETE",
            description =  "Método creado para dar de baja a un cliente por identificador especifico",
            tags = {"BAJA DE CLIENTE"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "No necesita body para la ejecución del método de consulta / DELETE",
                    required = false
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Elemento eliminado como suceso",
                            content = @Content(
                                    schema = @Schema(format = "Elemento eliminado como suceso")
                            )
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws URISyntaxException {
        Optional<Customer> OptionalCustomer = customerService.findById((long)id);
        if (OptionalCustomer.isPresent()) {
            customerService.deleteById((long)id);
            return ResponseEntity.ok("Elemento eliminado como suceso");
        }
        return ResponseEntity.badRequest().build();
    }
}