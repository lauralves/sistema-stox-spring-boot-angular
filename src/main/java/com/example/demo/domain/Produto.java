package com.example.demo.domain;

import com.example.demo.domain.databind.EstoqueDatabind;
import com.example.demo.domain.databind.FornecedorDatabind;
import com.example.demo.domain.databind.FuncionarioDatabind;
import com.example.demo.domain.databind.HistoricoVendaDatabind;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FORNECEDOR_ID")
    @JsonSerialize(using = FornecedorDatabind.IdSerializer.class)
    @JsonDeserialize(using = FornecedorDatabind.IdDeserializer.class)
    private Fornecedor fornecedor;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ESTOQUE_ID")
    private Estoque estoque;
//
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "PRODUTO_ID")
//    private List<HistoricoVenda> historicoVendas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "FUNCIONARIO_ID")
    @JsonSerialize(using = FuncionarioDatabind.IdSerializer.class)
    @JsonDeserialize(using = FuncionarioDatabind.IdDeserializer.class)
    private Funcionario funcionario;

    public Produto() {

    }

}

