package com.example.cleancrontrolapi.api.controller;


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

import com.example.cleancrontrolapi.domain.entity.statusProduto.StatusProduto;
import com.example.cleancrontrolapi.domain.repository.StatusProdutoRepository;

@RestController
@RequestMapping("/statusproduto")
public class StatusProdutoController {


    @Autowired  
    private StatusProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<StatusProduto>> getAll() {
        List<StatusProduto> lstStatusProduto = repository.findAll();
        return lstStatusProduto.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lstStatusProduto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusProduto> getStatusProdutoById(@PathVariable("id") Integer id) {
        StatusProduto statusProduto = repository.findById(id).orElse(null);
        return statusProduto == null ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(statusProduto);
    }


    @PostMapping
    public ResponseEntity<StatusProduto> save(@RequestBody StatusProduto statusProduto) {
        StatusProduto statusProdutoSaved = repository.save(statusProduto);
        return ResponseEntity.status(201).body(statusProdutoSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusProduto> update(@RequestBody StatusProduto statusProduto) {
        StatusProduto statusProdutoUpdated = repository.save(statusProduto);
        return ResponseEntity.status(200).body(statusProdutoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody StatusProduto statusProduto) {
        repository.delete(statusProduto);
        return ResponseEntity.status(200).build();
    }
}
