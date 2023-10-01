package com.example.demo.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.hibernate.mapping.Set;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
