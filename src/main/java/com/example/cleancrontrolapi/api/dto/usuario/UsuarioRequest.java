package com.example.cleancrontrolapi.api.dto.usuario;



public record UsuarioRequest( String nome, String sobrenome, String email, String telefone, String senha, String nickname, Integer fkTipoUser, Integer fkEmpresa) {

}
