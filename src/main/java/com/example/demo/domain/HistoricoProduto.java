package com.example.demo.domain;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dtCriacao;
    private LocalDateTime dtVenda;
    private LocalDateTime dtEntrada;
    private LocalDateTime dtSaida;
    private Long quantidadeEntrada;
    private Long quantidadeSaida;
    private String vendaPor;
    private Long quantidade;
    private Double comissao;
    private Double valorTotalVenda;
    private Double valorTotalPorProduto;
    private String nome;
    private Double precoVendaUnitario;
    private Double precoCompraUnitario;
    private String fornecedor;


    public HistoricoProduto() {
    }
}
