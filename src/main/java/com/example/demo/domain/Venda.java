package com.example.demo.domain;

import com.example.demo.domain.databind.ProdutoDatabind;
import com.example.demo.domain.databind.VendaDatabind;
import com.example.demo.repository.ProdutoRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VENDA")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_VENDA")
    private Long id;
    private LocalDateTime dtVenda;
    private String vendaPor;
    private Long quantidade;
    private Double comissao;
    private Double valorTotalVenda;

    @ManyToMany
    @JoinTable(name = "VENDA_PRODUTO",
            joinColumns = @JoinColumn(name = "VENDA_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUTO_ID")
    )
    @JsonSerialize(using = ProdutoDatabind.IdSerializer.class)
    @JsonDeserialize(using = ProdutoDatabind.IdDeserializer.class)
    private List<Produto> produtos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "VENDA_ID")
    private List<HistoricoProduto> historicoProdutos = new ArrayList<>();

    public Venda(){}


}
