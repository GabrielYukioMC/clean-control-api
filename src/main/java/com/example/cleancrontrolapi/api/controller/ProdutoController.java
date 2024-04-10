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

import com.example.cleancrontrolapi.domain.entity.produto.Produto;
import com.example.cleancrontrolapi.domain.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    @Autowired  
    private ProdutoRepository repository;


    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        List<Produto> lstProduto = repository.findAll();
        return lstProduto.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lstProduto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Integer id) {
        Produto produto = repository.findById(id).orElse(null);
        return produto == null ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(produto);
    }


    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        Produto produtoSaved = repository.save(produto);
        return ResponseEntity.status(201).body(produtoSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        Produto produtoUpdated = repository.save(produto);
        return ResponseEntity.status(200).body(produtoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody Produto produto) {
        repository.delete(produto);
        return ResponseEntity.status(200).build();
    }
}
