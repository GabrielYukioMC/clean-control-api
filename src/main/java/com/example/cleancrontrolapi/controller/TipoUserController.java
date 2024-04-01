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

import com.example.cleancrontrolapi.model.TipoUser;
import com.example.cleancrontrolapi.repository.TipoUserRepository;

@RestController
@RequestMapping("/tipoUser")
public class TipoUserController {

    @Autowired
    private TipoUserRepository repository;

    @GetMapping
    public ResponseEntity<List<TipoUser>> getAll() {
        List<TipoUser> lstTipoUser = repository.findAll();
        return lstTipoUser.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lstTipoUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUser> getTipoUserById(@PathVariable("id") Integer id) {
        TipoUser tipoUser = repository.findById(id).orElse(null);
        return tipoUser == null ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(tipoUser);
    }

    @PostMapping
    public ResponseEntity<TipoUser> save(@RequestBody TipoUser tipoUser) {
        TipoUser tipoUserSaved = repository.save(tipoUser);
        return ResponseEntity.status(201).body(tipoUserSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUser> update(@RequestBody TipoUser tipoUser) {
        TipoUser tipoUserUpdated = repository.save(tipoUser);
        return ResponseEntity.status(200).body(tipoUserUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody TipoUser tipoUser) {
        repository.delete(tipoUser);
        return ResponseEntity.status(200).build();
    }
}
