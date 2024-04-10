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

import com.example.cleancrontrolapi.api.dto.empresa.EmpresaRequest;
import com.example.cleancrontrolapi.api.dto.empresa.EmpresaResponse;
import com.example.cleancrontrolapi.domain.entity.empresa.Empresa;
import com.example.cleancrontrolapi.domain.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {


    @Autowired
    private EmpresaRepository repository;


    @GetMapping
    public ResponseEntity<List<EmpresaResponse>> getAll() {
        List<EmpresaResponse> lstEmpresa = repository.findAll().stream().map(EmpresaResponse::new).toList();
        return lstEmpresa.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lstEmpresa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponse> getEmpresaById(@PathVariable("id") Integer id) {
    
        Empresa empresa = repository.findById(id).orElse(null);
        return empresa == null ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(new EmpresaResponse(empresa));
    }

    @PostMapping
    public ResponseEntity<EmpresaRequest> createEmpresa(@RequestBody EmpresaRequest empresa) {

        Empresa empresaEntity = new Empresa(empresa);
        repository.save(empresaEntity);
        return ResponseEntity.status(201).body(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaRequest> updateEmpresa(@PathVariable("id") Integer id, @RequestBody EmpresaRequest empresa) {

        Empresa empresaEntity = repository.findById(id).orElse(null);
        if (empresaEntity == null) {
            return ResponseEntity.status(204).build();
        }
        empresaEntity.setNome(empresa.nome());
        empresaEntity.setCnpj(empresa.cnpj());
        empresaEntity.setEmail_comercial(empresa.email_comercial());
        empresaEntity.setTelefone(empresa.telefone());
        repository.save(empresaEntity);
        return ResponseEntity.status(200).body(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable("id") Integer id) {

        Empresa empresaEntity = repository.findById(id).orElse(null);
        if (empresaEntity == null) {
            return ResponseEntity.status(204).build();
        }
        repository.delete(empresaEntity);
        return ResponseEntity.status(200).build();
    }




}
