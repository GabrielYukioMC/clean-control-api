package com.example.cleancrontrolapi.api.dto.usuario;

import com.example.cleancrontrolapi.domain.entity.usuario.Usuario;

public record UsuarioResponse(String nome, String sobrenome, String email, String telefone, String senha, String nickname, Integer fkTipoUser, Integer fkEmpresa) {

    

    public UsuarioResponse(Usuario usuario) {
        this(usuario.getNome(), usuario.getSobrenome(), usuario.getEmail(), usuario.getTelefone(), usuario.getSenha(), usuario.getNickname(), usuario.getFkTipoUser(), usuario.getFkEmpresa());
    }
}
