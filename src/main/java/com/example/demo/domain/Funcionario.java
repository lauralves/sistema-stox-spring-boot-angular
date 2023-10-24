package com.example.demo.domain;

import com.example.demo.domain.databind.TipoFuncionarioDatabind;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIO")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_FUNCIONARIO")
    private Long id;
    private String nome;
    private String login;
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "TIPO_FUNCIONARIO_ID")
    @JsonSerialize(using = TipoFuncionarioDatabind.IdSerializer.class)
    @JsonDeserialize(using = TipoFuncionarioDatabind.IdDeserializer.class)
    private TipoFuncionario tipoFuncionario;

    public Funcionario() {
    }
}
