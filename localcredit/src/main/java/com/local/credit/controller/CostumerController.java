package com.local.credit.controller;
import com.local.credit.controller.dto.CustomerDto;
import com.local.credit.entities.Customer;
import com.local.credit.mapper.CustomerMapper;
import com.local.credit.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/local/credit/customer")
public class CostumerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<CustomerDto> customerDto = CustomerMapper.
                INSTANCE.customersToCustomersDto(customerService.findAll());

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

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CustomerDto customerDto) throws URISyntaxException {
        if(customerDto.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

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