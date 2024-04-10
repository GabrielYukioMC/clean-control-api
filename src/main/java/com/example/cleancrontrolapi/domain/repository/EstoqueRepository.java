package com.example.cleancrontrolapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancrontrolapi.domain.entity.estoque.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{

}
