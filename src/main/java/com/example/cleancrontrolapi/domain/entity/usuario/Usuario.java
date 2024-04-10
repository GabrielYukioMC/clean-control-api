package com.example.cleancrontrolapi.domain.entity.usuario;

import org.hibernate.validator.constraints.Length;

import com.example.cleancrontrolapi.api.dto.usuario.UsuarioRequest;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Integer idUsuario;
   
    @NotBlank(message = "Nome é obrigatório")
    @Length(min = 3, max = 50)
    private String nome;
   
    @NotBlank(message = "Sobrenome é obrigatório")
    @Length(min = 3, max = 50)
    private String sobrenome;

    @Email
   
    @NotBlank(message = "Email é obrigatório")
    private String email;
   
    @NotBlank(message = "Telefone é obrigatório")
    @Length(min = 8, max = 15)
    private String telefone;
   
    @NotBlank(message = "Senha é obrigatória")
    @Length(min = 8, max = 15)
    private String senha;
   
    @NotBlank(message = "Nickname é obrigatório")
    @Length(min = 3, max = 50)
    private String nickname;
   
    @NotNull(message = "Tipo de usuário é obrigatório")
    private Integer fkTipoUser;
   
    @NotNull(message = "Empresa é obrigatória")
    private Integer fkEmpresa;

    public Usuario(UsuarioRequest data) {
        this(null, data.nome(), data.sobrenome(), data.email(), data.telefone(), data.senha(), data.nickname(), data.fkTipoUser(), data.fkEmpresa());
    }

}