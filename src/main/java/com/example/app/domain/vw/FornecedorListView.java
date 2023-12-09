package com.example.app.domain.vw;

import org.hibernate.annotations.Subselect;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "FORNECEDOR")
@Subselect("" +
"SELECT F.ID, F.NOME FROM FORNECEDOR F ORDER BY F.NOME")
public class FornecedorListView {
    @Id
    private Long id;
    private String nome;
    
}
