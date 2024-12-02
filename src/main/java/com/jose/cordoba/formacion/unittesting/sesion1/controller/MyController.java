package com.jose.cordoba.formacion.unittesting.sesion1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/session1")
public class MyController {


    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world";
    }
}
