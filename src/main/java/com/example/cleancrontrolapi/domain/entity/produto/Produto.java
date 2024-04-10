package com.example.cleancrontrolapi.domain.entity.produto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer idProduto;

    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private Integer fkTipoProduto;
    @Getter
    @Setter
    private String urlImg;
    @Getter
    @Setter
    private Double preco;
    @Getter
    @Setter
    private String produtocol;
    @Getter
    @Setter
    private Integer fkEstoque;
    @Getter
    @Setter
    private Integer qtdProduto;
    @Getter
    @Setter
    private Integer fkStatusProduto;

}
