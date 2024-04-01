package com.example.cleancrontrolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancrontrolapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
