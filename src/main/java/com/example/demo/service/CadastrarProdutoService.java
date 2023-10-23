package com.example.demo.service;


import com.example.demo.domain.Estoque;
import com.example.demo.domain.HistoricoProduto;
import com.example.demo.domain.Produto;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
