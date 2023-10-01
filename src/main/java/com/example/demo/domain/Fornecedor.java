package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FORNECEDOR")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_FORNECEDOR")
    private Long id;
    private String nome;


    public Fornecedor() {
    }
}
