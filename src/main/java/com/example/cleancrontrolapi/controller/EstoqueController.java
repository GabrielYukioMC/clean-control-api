package com.example.cleancrontrolapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancrontrolapi.model.Estoque;
import com.example.cleancrontrolapi.repository.EstoqueRepository;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository repository;

    @GetMapping
    public ResponseEntity<List<Estoque>> getAll() {
        List<Estoque> lstEstoque = repository.findAll();
        return lstEstoque.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lstEstoque);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getEstoqueById(@PathVariable("id") Integer id) {
        Estoque estoque = repository.findById(id).orElse(null);
        return estoque == null ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(estoque);
    }

    @PostMapping
    public ResponseEntity<Estoque> save(@RequestBody Estoque estoque) {
        Estoque estoqueSaved = repository.save(estoque);
        return ResponseEntity.status(201).body(estoqueSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> update(@RequestBody Estoque estoque) {
        Estoque estoqueUpdated = repository.save(estoque);
        return ResponseEntity.status(200).body(estoqueUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody Estoque estoque) {
        repository.delete(estoque);
        return ResponseEntity.status(200).build();
    }

}
