package com.example.app.domain;

import com.example.app.domain.enums.TipoFuncionario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FUNCIONARIO")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIO")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_FUNCIONARIO")
    private Long id;
    private String nome;
    private String login;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "TIPO_FUNCIONARIO_ID")
    private TipoFuncionario tipoFuncionario;

}
