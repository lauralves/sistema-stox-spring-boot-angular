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
    private Long quantidadeDisponivel;

    @ManyToOne
    @JoinColumn(name = "FORNECEDOR_ID")
    @JsonSerialize
    @JsonDeserialize
    private Fornecedor fornecedor;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "ESTOQUE_ID")
    @JsonSerialize
    @JsonDeserialize
    private Estoque estoque;
//
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUTO_ID")
    private List<HistoricoVenda> historicoVendas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "FUNCIONARIO_ID")
    @JsonSerialize
    @JsonDeserialize
    private Funcionario funcionario;

    public Produto() {

    }

}

