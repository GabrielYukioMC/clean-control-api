/**
 * File: UserController.java
 * Author: @GabrielYukioMC
 * Created: 12/02/2024
 * Last Modified: 30/03/2024 
 * Description: Classe que controla as requisições feitas para a entidade Usuario,
 *  como cadastro, login, atualização e remoção de usuários. 
 * version: 1.0
 */
package com.example.cleancrontrolapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancrontrolapi.model.usuario.Usuario;
import com.example.cleancrontrolapi.model.usuario.UsuarioRequest;
import com.example.cleancrontrolapi.model.usuario.UsuarioResponse;
import com.example.cleancrontrolapi.repository.UsuarioRepository;

import jakarta.validation.Valid;


import java.util.List;


@RestController
@Validated
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getAll() {
        List<UsuarioResponse> lstUsuario = repository.findAll().stream().map(UsuarioResponse::new).toList();
        return lstUsuario.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lstUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") Integer id) {
        Usuario usuario = repository.findById(id).orElse(null);
        return usuario == null ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(usuario);
    }

    // @PostMapping("/login")
    // public ResponseEntity<Usuario> loginUser(@RequestBody LoginDTO usuarioRequest) {
    //     String email = usuarioRequest.getEmail();
    //     String password = usuarioRequest.getSenha();

    //     Usuario usuario = repository.findByEmailAndSenhaAndEmpresa(email, password);

    //     if (usuario == null) {
    //         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    //     }

    //     return ResponseEntity.status(HttpStatus.OK).body(usuario);
    // }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<UsuarioRequest> cadastrarUsuarios(@Valid @RequestBody UsuarioRequest usuario) {

        Usuario usuarioEntity = new Usuario(usuario);
        repository.save(usuarioEntity);
        return ResponseEntity.status(201).body(usuario);

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Integer id) {
        for (Usuario u : repository.findAll()) {
            if (u.getIdUsuario().equals(id)) {
                repository.delete(u);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(204).build();

    }


    

}