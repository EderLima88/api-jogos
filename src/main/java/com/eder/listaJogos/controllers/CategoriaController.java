package com.eder.listaJogos.controllers;

import com.eder.listaJogos.models.Categoria;
import com.eder.listaJogos.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private  CategoriaService service;

    public CategoriaController(CategoriaService service)  {
    this.service = service;
    }

    @PostMapping
    public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(service.addCategoria(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public  ResponseEntity<List<Categoria>> findAll(){

        return ResponseEntity.ok(service.findAll());
    }

}
