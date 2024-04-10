package com.example.cleancrontrolapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancrontrolapi.domain.entity.tipoProduto.TipoProduto;

public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Integer>{

}