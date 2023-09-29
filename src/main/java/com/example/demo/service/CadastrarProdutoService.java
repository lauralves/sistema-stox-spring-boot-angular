package com.example.demo.service;


import com.example.demo.domain.Estoque;
import com.example.demo.domain.HistoricoProduto;
import com.example.demo.domain.Produto;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;


@Service
public class CadastrarProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Transactional
    public Produto exec(Produto produto, Estoque estoque) {
        //seta as informações do estoque
        Long qtEntrada = produto.getEstoque().getQuantidadeEntrada();
        estoque.setQuantidadeEntrada(qtEntrada);
        estoque.setDtEntrada(LocalDateTime.now());
        Assert.notNull(estoque.getDtEntrada(), "A data de entrada do produto não pode ser nula");
        //salva o produto
        produto.setEstoque(estoque);
        produto.setQuantidadeDisponivel(estoque.getQuantidadeEntrada());

        HistoricoProduto historicoProduto =new HistoricoProduto();
        historicoProduto.setDtEntrada(produto.getEstoque().getDtEntrada());
        historicoProduto.setQuantidadeEntrada(produto.getEstoque().getQuantidadeEntrada());
        historicoProduto.setFornecedor(produto.getFornecedor());
        produto.getHistoricoProdutos().add(historicoProduto);
        return produtoRepository.save(produto);
    }

}
