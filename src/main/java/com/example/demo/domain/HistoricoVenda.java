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
@Table(name = "HISTORICO_VENDA")
public class HistoricoVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double valorTotal;
    private LocalDateTime dtVenda;
    private Integer quantidade;
    private Double comissao;

    public HistoricoVenda() {
    }
}
