package com.example.cleancrontrolapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cleancrontrolapi.domain.entity.tipoUser.TipoUser;

public interface TipoUserRepository extends JpaRepository<TipoUser, Integer>{

}
