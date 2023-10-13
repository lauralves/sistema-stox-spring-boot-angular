package com.example.demo.domain.vw;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Subselect;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "HISTORICO_PRODUTO")
@Subselect("" +
        "SELECT " +
        "    HP.ID AS ID, " +
        "    P.ID AS PRODUTO, " +
        "    P.PRECO_COMPRA_UNITARIO, " +
        "    P.PRECO_VENDA_UNITARIO, " +
        "    P.QUANTIDADE_DISPONIVEL, " +
        "    ES.DT_ENTRADA AS DATA_ENTRADA, " +
        "    ES.DT_SAIDA, " +
        "    ES.QUANTIDADE_ENTRADA, " +
        "    ES.QUANTIDADE_SAIDA, " +
        "    F.NOME AS NOME_FORNECEDOR, " +
        "    ES.QUANTIDADE_SAIDA * P.PRECO_VENDA_UNITARIO AS VALOR_VENDIDO_POR_PRODUTO " +
        "FROM HISTORICO_PRODUTO HP " +
        "         INNER JOIN PRODUTO P ON HP.PRODUTO_ID = P.ID " +
        "         INNER JOIN ESTOQUE ES ON P.ESTOQUE_ID = ES.ID " +
        "         INNER JOIN FORNECEDOR F ON HP.FORNECEDOR_ID = F.ID ")
public class HistoricoProdutoListView {
    @Id
    private Long id;
    private Long produto;
    private Double precoCompraUnitario;
    private Double precoVendaUnitario;
    private Long quantidadeDisponivel;
    private LocalDateTime dataEntrada;
    private LocalDateTime dtSaida;
    private Long quantidadeSaida;
    private Long quantidadeEntrada;
    private Long valorVendidoPorProduto;
    private String nomeFornecedor;
}
