package com.jose.cordoba.formacion.unitTesting.session1.controller;

import com.jose.cordoba.formacion.unitTesting.session1.dto.DivRequest;
import com.jose.cordoba.formacion.unitTesting.session1.dto.SumRequest;
import com.jose.cordoba.formacion.unitTesting.session1.service.OperationsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/session1")
public class MyController {

    private final OperationsService operationsService;

    public MyController(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/alwaysTrue")
    public boolean alwaysTrue() {
        return operationsService.alwaysTrue();
    }

    @GetMapping("/alwaysFalse")
    public boolean alwaysFalse() {
        return operationsService.alwaysFalse();
    }

    @PostMapping("/sum")
    public int sum(@RequestBody SumRequest request) {
        return operationsService.sum(request.a(), request.b());
    }

    @PostMapping("/div")
    public int div(@RequestBody DivRequest request) {
        return operationsService.div(request.a(), request.b());
    }
}
