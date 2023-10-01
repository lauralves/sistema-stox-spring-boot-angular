package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@Table(name = "FUNCIONARIO")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_FUNCIONARIO")
    private Long id;
    private String nome;
    private String login;
    private String senha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TIPO_FUNCIONARIO_ID")
    private TipoFuncionario tipoFuncionario;

    public Funcionario() {
    }
}
