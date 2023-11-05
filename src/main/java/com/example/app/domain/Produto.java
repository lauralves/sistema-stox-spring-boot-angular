package com.example.app.domain;

import com.example.app.domain.databind.FornecedorDatabind;
import com.example.app.domain.databind.FuncionarioDatabind;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUTO")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_PRODUTO")
    private Long id;
    private String nome;
    private String descricao;
    private Boolean descontinuado;
    private LocalDateTime descontinuadoEm;
    private LocalDateTime descontinuadoPor;
    private String descontinuadoObservacao;
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

    @ManyToOne
    @JoinColumn(name = "FUNCIONARIO_ID")
    @JsonSerialize(using = FuncionarioDatabind.IdSerializer.class)
    @JsonDeserialize(using = FuncionarioDatabind.IdDeserializer.class)
    private Funcionario funcionario;

//    @ManyToOne
//    @JoinColumn(name = "VENDA_ID")
//    @JsonSerialize(using = VendaDatabind.IdSerializer.class)
//    @JsonDeserialize(using = VendaDatabind.IdDeserializer.class)
//    private Venda venda;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PRODUTO_ID")
    private List<HistoricoProduto> historicoProdutos = new ArrayList<>();
    public Produto() {

    }

}

