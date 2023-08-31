package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "TIPO_FUNCIONARIO")
public class TipoFuncionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;

    public TipoFuncionario() {
    }
}
