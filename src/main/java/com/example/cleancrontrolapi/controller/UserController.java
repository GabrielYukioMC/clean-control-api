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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cleancrontrolapi.model.Usuario;
import com.example.cleancrontrolapi.repository.UsuarioRepository;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@RestController
@Validated
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> lstUsuario = repository.findAll();
        return lstUsuario.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lstUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") Integer id) {
        Usuario usuario = repository.findById(id).orElse(null);
        return usuario == null ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUser(@RequestBody UsuarioRequest usuarioRequest) {
        String email = usuarioRequest.getEmail();
        String password = usuarioRequest.getSenha();

        Usuario usuario = repository.findByEmailAndSenha(email, password);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuarios(@Valid @RequestBody Usuario usuario) {

        for (Usuario u : repository.findAll()) {
            if (u.getEmail().equals(usuario.getEmail())) {
                return ResponseEntity.status(204).build();
            }
        }
        repository.save(usuario);
        return ResponseEntity.status(201).body(usuario);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInfoUser(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        for (Usuario u : repository.findAll()) {
            if (u.getIdUsuario().equals(id)) {
                u.setNome(usuario.getNome() != null ? usuario.getNome() : u.getNome());
                u.setSobrenome(usuario.getSobrenome() != null ? usuario.getSobrenome() : u.getSobrenome());
                u.setEmail(usuario.getEmail() != null ? usuario.getEmail() : u.getEmail());
                u.setTelefone(usuario.getTelefone() != null ? usuario.getTelefone() : u.getTelefone());
                u.setSenha(usuario.getSenha() != null ? usuario.getSenha() : u.getSenha());
                u.setNickname(usuario.getNickname() != null ? usuario.getNickname() : u.getNickname());

                repository.save(u);
            }
        }

        return ResponseEntity.status(200).build();
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


    public static class UsuarioRequest {

       @Getter @Setter private String senha;
       @Getter @Setter private String email;
       
    }

}