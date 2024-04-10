package com.example.cleancrontrolapi.domain.entity.tipoUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idTipoUser")
public class TipoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Integer idTipoUser;
   
    private String name;
   
    private String descricao;

}