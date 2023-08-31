package com.example.demo.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private Boolean descontinuado;
    private Double precoVendaUnitario;
    private Double precoCompraUnitario;
    @ManyToOne
    @JoinColumn(name = "FORNECEDOR_ID")
    @JsonSerialize
    @JsonDeserialize
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "ESTOQUE_ID")
    @JsonSerialize
    @JsonDeserialize
    private Estoque estoque;

    public Produto() {

    }

}

