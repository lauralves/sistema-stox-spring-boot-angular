package com.example.app.service;


import com.example.app.domain.Estoque;
import com.example.app.domain.HistoricoProduto;
import com.example.app.domain.Produto;
import com.example.app.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class CadastrarProdutoService {

    private final ProdutoRepository produtoRepository;
    @Transactional
    public Produto exec(Produto produto, Estoque estoque) {

        estoque.setQuantidadeEntrada(produto.getEstoque().getQuantidadeEntrada());
        estoque.setDtEntrada(LocalDateTime.now());
        produto.setEstoque(estoque);
        produto.setQuantidadeDisponivel(estoque.getQuantidadeEntrada());
        produto.setDescontinuado(false);

        HistoricoProduto historicoProduto =new HistoricoProduto();
        historicoProduto.setDtCriacao(LocalDateTime.now());
        historicoProduto.setDtEntrada(produto.getEstoque().getDtEntrada());
        historicoProduto.setQuantidadeEntrada(produto.getEstoque().getQuantidadeEntrada());
        historicoProduto.setNome(produto.getNome());
        historicoProduto.setFornecedor(produto.getFornecedor());
        historicoProduto.setPrecoVendaUnitario(produto.getPrecoVendaUnitario());
        historicoProduto.setPrecoCompraUnitario(produto.getPrecoCompraUnitario());
        produto.getHistoricoProdutos().add(historicoProduto);
        return produtoRepository.save(produto);
    }

}
