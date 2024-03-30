package com.exemplo.projetosistemagerenciamento.models;

import jakarta.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String senha;
    private String nickname;
    private Integer fktipouser;
    private Integer fkempresa;

    public Integer getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getfkTipoUser() {
        return fktipouser;
    }

    public void setfkTipoUser(Integer fkTipoUser) {
        this.fktipouser = fkTipoUser;
    }
    public Integer getFkEmpresa() {
        return fkempresa;
    }

    public void setFkEmpresa(Integer fkTipoUser) {
        this.fkempresa = fkTipoUser;
    }


    
}