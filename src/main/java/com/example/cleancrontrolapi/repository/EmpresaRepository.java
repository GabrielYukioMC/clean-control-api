package com.example.cleancrontrolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancrontrolapi.model.empresa.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

}
