package com.exemplo.projetosistemagerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exemplo.projetosistemagerenciamento.models.Usuario;

import java.util.List;


public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query(value = "SELECT * FROM Usuario WHERE  nome = ?1", nativeQuery = true)
    List<Usuario> findUsuariosByNome(String nome);

    @Query(value ="SELECT * FROM Usuario WHERE email = ?1 and senha = ?2", nativeQuery = true)
    Usuario findByEmailAndSenha(String email, String senha);
}
