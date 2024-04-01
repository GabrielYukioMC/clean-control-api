package com.example.cleancrontrolapi.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer idEstoque;

    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private Date dataCriacao;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private Integer fkEmpresa;

   
}
