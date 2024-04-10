package com.example.cleancrontrolapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancrontrolapi.domain.entity.statusProduto.StatusProduto;

public interface StatusProdutoRepository extends JpaRepository<StatusProduto, Integer>{

}
