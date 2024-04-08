package com.example.cleancrontrolapi.model.usuario;



public record UsuarioRequest( String nome, String sobrenome, String email, String telefone, String senha, String nickname, Integer fkTipoUser, Integer fkEmpresa) {

}
