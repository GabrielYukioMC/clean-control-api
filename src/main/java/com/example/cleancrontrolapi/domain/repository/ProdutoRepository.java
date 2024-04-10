package com.example.cleancrontrolapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancrontrolapi.domain.entity.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
