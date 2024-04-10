package com.example.cleancrontrolapi.domain.entity.statusProduto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "status_produto")
public class StatusProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer idStatusProduto;

    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String descricao;

}
