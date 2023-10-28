package com.example.app.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "ESTOQUE")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUTO" )
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_PRODUTO")
    private Long id;
    private LocalDateTime dtEntrada;
    private LocalDateTime dtSaida;
    private Long quantidadeEntrada;
    private Long quantidadeSaida;

    public Estoque() {
    }
}
