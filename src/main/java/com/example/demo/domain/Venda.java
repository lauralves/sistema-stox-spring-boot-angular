package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Table(name = "VENDA")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_VENDA")
    private Long id;
    private LocalDateTime dtVenda;
    private String vendaPor;
    private Long quantidade;
    private Double comissao;
    private Double valorTotalVenda;
    private Double valorTotalPorProduto;

    public Venda(){}


}
