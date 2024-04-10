package com.example.cleancrontrolapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancrontrolapi.domain.entity.empresa.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

}
