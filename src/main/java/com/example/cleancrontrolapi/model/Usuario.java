package com.example.cleancrontrolapi.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer idUsuario;
    @Getter
    @Setter
    @NotBlank(message = "Nome é obrigatório")
    @Length(min = 3, max = 50)
    private String nome;
    @Getter
    @Setter
    @NotBlank(message = "Sobrenome é obrigatório")
    @Length(min = 3, max = 50)
    private String sobrenome;

    @Email
    @Getter
    @Setter
    @NotBlank(message = "Email é obrigatório")
    private String email;
    @Getter
    @Setter
    @NotBlank(message = "Telefone é obrigatório")
    @Length(min = 8, max = 15)
    private String telefone;
    @Getter
    @Setter
    @NotBlank(message = "Senha é obrigatória")
    @Length(min = 8, max = 15)
    private String senha;
    @Getter
    @Setter
    @NotBlank(message = "Nickname é obrigatório")
    @Length(min = 3, max = 50)
    private String nickname;
    @Getter
    @Setter
    @NotNull(message = "Tipo de usuário é obrigatório")
    private Integer fkTipoUser;
    @Getter
    @Setter
    @NotNull(message = "Empresa é obrigatória")
    private Integer fkEmpresa;

}