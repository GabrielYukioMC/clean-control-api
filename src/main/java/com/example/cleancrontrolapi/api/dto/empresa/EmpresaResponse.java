package com.example.cleancrontrolapi.api.dto.empresa;

import com.example.cleancrontrolapi.domain.entity.empresa.Empresa;

public record EmpresaResponse( String nome, String cnpj, String email_comercial, String telefone) {

    public EmpresaResponse(Empresa empresa) {
        this(empresa.getNome(), empresa.getCnpj(), empresa.getEmail_comercial(), empresa.getTelefone());
    }

}
