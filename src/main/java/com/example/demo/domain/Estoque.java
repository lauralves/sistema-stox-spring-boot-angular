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
@Table(name = "ESTOQUE")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long quantidadeEntrada;
    private Long quantidadeSaida;
    private LocalDateTime dtEntrada;
    private LocalDateTime dtSaida;
    @ManyToOne
    @NonNull
    @JoinColumn(name = "FUNCIONARIO_ID")
    @JsonSerialize
    @JsonDeserialize
    private Funcionario funcionario;



    public Estoque() {
    }
}
