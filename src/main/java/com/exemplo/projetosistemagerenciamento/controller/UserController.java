package com.exemplo.projetosistemagerenciamento.controller;

import com.exemplo.projetosistemagerenciamento.models.Usuario;
import com.exemplo.projetosistemagerenciamento.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public ResponseEntity<Usuario> loginUser(@RequestBody Usuario loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getSenha();

        Usuario usuario = repository.findByEmailAndSenha(email, password);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuarios(@RequestBody Usuario usuario) {

        for (Usuario u : repository.findAll()) {
            if (u.getEmail().equals(usuario.getEmail())) {
                return ResponseEntity.status(204).build();
            }
        }
        repository.save(usuario);
        return ResponseEntity.status(201).body(usuario);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInfoUser(@PathVariable("id") String id, @RequestBody Usuario usuario) {
        for (Usuario u : repository.findAll()) {
            if (u.getIdUsuario().equals(Integer.parseInt(id))) {
                u.setNome(usuario.getNome() != null ? usuario.getNome() : u.getNome());
                u.setSobrenome(usuario.getSobrenome() != null ? usuario.getSobrenome() : u.getSobrenome());
                u.setEmail(usuario.getEmail() != null ? usuario.getEmail() : u.getEmail());
                u.setTelefone(usuario.getTelefone() != null ? usuario.getTelefone() : u.getTelefone());
                u.setSenha(usuario.getSenha() != null ? usuario.getSenha() : u.getSenha());
                u.setNickname(usuario.getNickname() != null ? usuario.getNickname() : u.getNickname());

                repository.save(u);

                // ^^ !"".equals(usuario.getNome()) ? usuario.getNome() : u.getNome() valida de se o campo foi prenchido se foi ele atualiza se não ele mantem o valor antigo  (～￣▽￣)～
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
}
