package com.eder.listaJogos.controllers;

import com.eder.listaJogos.models.Console;
import com.eder.listaJogos.services.ConsoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    private  ConsoleService service;

    public ConsoleController(ConsoleService service)  {
    this.service = service;
    }

    @PostMapping
    public ResponseEntity<Console> addConsole(@RequestBody Console console) {
        return ResponseEntity.ok(service.addConsole(console));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Console> findById(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public  ResponseEntity<List<Console>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
