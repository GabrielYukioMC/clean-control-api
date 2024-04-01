package com.example.cleancrontrolapi.model;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer idEmpresa;

    @Getter
    @Setter
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @Getter
    @Setter
    @CNPJ(message = "CNPJ inválido")
    private String cnpj;
    @Getter
    @Setter
    @Email(message = "Email inválido")
    private String email_comercial;
    @Getter
    @Setter
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;
}
