package com.example.cleancrontrolapi.domain.entity.empresa;

import org.hibernate.validator.constraints.br.CNPJ;

import com.example.cleancrontrolapi.api.dto.empresa.EmpresaRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idEmpresa")
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Integer idEmpresa;

   
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
   
    @CNPJ(message = "CNPJ inválido")
    private String cnpj;
   
    @Email(message = "Email inválido")
    private String email_comercial;
   
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    public Empresa(EmpresaRequest data) {
        this(null, data.nome(), data.cnpj(), data.email_comercial(), data.telefone());
    }

    
}
