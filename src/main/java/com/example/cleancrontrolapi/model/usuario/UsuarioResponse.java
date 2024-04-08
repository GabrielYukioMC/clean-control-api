package com.example.cleancrontrolapi.model.usuario;




public record UsuarioResponse(String nome, String sobrenome, String email, String telefone, String senha, String nickname, Integer fkTipoUser, Integer fkEmpresa) {

    //get 

    public UsuarioResponse(Usuario usuario) {
        this(usuario.getNome(), usuario.getSobrenome(), usuario.getEmail(), usuario.getTelefone(), usuario.getSenha(), usuario.getNickname(), usuario.getFkTipoUser(), usuario.getFkEmpresa());
    }
}
