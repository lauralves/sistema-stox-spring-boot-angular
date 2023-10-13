package com.example.demo.domain;

import com.example.demo.domain.databind.FornecedorDatabind;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "HISTORICO_PRODUTO")
public class HistoricoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HISTORICO_PRODUTO")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_HISTORICO_PRODUTO")
    private Long id;
    private LocalDateTime dtCriacao;
    private LocalDateTime dtEntrada;
    private LocalDateTime dtSaida;
    private Long quantidadeEntrada;
    private Long quantidadeSaida;
    private Double comissao;
    private String nome;
    private Double precoVendaUnitario;
    private Double precoCompraUnitario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FORNECEDOR_ID")
    @JsonSerialize(using = FornecedorDatabind.IdSerializer.class)
    @JsonDeserialize(using = FornecedorDatabind.IdDeserializer.class)
    private Fornecedor fornecedor;


    public HistoricoProduto() {
    }
}
