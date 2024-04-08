package com.example.cleancrontrolapi.model.empresa;

public record EmpresaResponse( String nome, String cnpj, String email_comercial, String telefone) {

    public EmpresaResponse(Empresa empresa) {
        this(empresa.getNome(), empresa.getCnpj(), empresa.getEmail_comercial(), empresa.getTelefone());
    }

}
