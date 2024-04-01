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

import com.example.cleancrontrolapi.model.Empresa;
import com.example.cleancrontrolapi.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {


    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public ResponseEntity<List<Empresa>> getAll() {
        List<Empresa> lstEmpresa = repository.findAll();
        return lstEmpresa.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lstEmpresa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("id") Integer id) {
        Empresa empresa = repository.findById(id).orElse(null);
        return empresa == null ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(empresa);
    }

    @PostMapping
    public ResponseEntity<Empresa> save(@RequestBody Empresa empresa) {
        Empresa empresaSaved = repository.save(empresa);
        return ResponseEntity.status(201).body(empresaSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@RequestBody Empresa empresa) {
        Empresa empresaUpdated = repository.save(empresa);
        return ResponseEntity.status(200).body(empresaUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody Empresa empresa) {
        repository.delete(empresa);
        return ResponseEntity.status(200).build();
    }
}
