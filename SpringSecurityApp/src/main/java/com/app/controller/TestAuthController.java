package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@PreAuthorize("denyAll()")
public class TestAuthController {

   /*@GetMapping("/hello")
    @PreAuthorize("permitAll()")
    public String Hello(){
        return "Hello World";
    }


    @GetMapping("/hello-secured")
    @PreAuthorize("hasAuthority('REA6D')")
    public String HelloSecured(){
        return "Hello World-Secured";
    }

    @GetMapping("/hello-secured2")
    @PreAuthorize("hasAuthority('CREATE ')")
    public String HelloSecured2(){
        return "Hello World-Secured2";
    }*/

    @GetMapping("/get")
    //@PreAuthorize("hasAuthority('READ')")
    public String helloGet(){
        return "Hello World GET";
    }

    @PostMapping("/post")
    //@PreAuthorize("hasAuthority('CREATE') || hasAuthority('READ')")
    public String helloPost(){
        return "Hello World POST";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello World PUT";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello World DELETE";
    }

    @PatchMapping("/patch")
    //@PreAuthorize("hasAuthority('REFACTOR')")
    public String helloPath(){
        return "Hello World PATCH";
    }


}
