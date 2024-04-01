package com.example.cleancrontrolapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancrontrolapi.model.TipoProduto;
import com.example.cleancrontrolapi.repository.TipoProdutoRepository;

@RestController
@RequestMapping("/tipo_produto")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<TipoProduto>> getAll() {
        List<TipoProduto> lstTipoProduto = repository.findAll();
        return lstTipoProduto.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lstTipoProduto);
    }

    @PostMapping
    public ResponseEntity<TipoProduto> save(@RequestBody TipoProduto tipoProduto) {
        TipoProduto tipoProdutoSaved = repository.save(tipoProduto);
        return ResponseEntity.status(201).body(tipoProdutoSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProduto> update(@RequestBody TipoProduto tipoProduto) {
        TipoProduto tipoProdutoUpdated = repository.save(tipoProduto);
        return ResponseEntity.status(200).body(tipoProdutoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody TipoProduto tipoProduto) {
        repository.delete(tipoProduto);
        return ResponseEntity.status(200).build();
    }
}
