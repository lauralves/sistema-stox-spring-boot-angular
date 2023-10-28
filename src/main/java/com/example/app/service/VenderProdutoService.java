package com.example.app.service;

import com.example.app.domain.HistoricoProduto;
import com.example.app.domain.Produto;
import com.example.app.domain.Venda;
import com.example.app.repository.ProdutoRepository;
import com.example.app.repository.VendaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@Service
public class VenderProdutoService {

    //todo refatorar o service
    private final VendaRepository vendaRepository;
    private final ProdutoRepository produtoRepository;
    @Transactional
    public Produto exec(Long id, Produto resource, Venda venda){
        Produto produto = produtoRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Produto não encontrado" + id));

        validateProdutoDescontinuado(produto);
        validateQtdDisponivel(produto);

        var estoque = produto.getEstoque();
        estoque.setDtSaida(LocalDateTime.now());
        estoque.setQuantidadeSaida(resource.getEstoque().getQuantidadeSaida());

        venda.setDtVenda(LocalDateTime.now());
        venda.setVendaPor(produto.getFuncionario().getNome().toString());
        venda.setQuantidade(resource.getEstoque().getQuantidadeSaida());
        venda.getProdutos().add(produto);
        vendaRepository.save(venda);

        var historicoProduto = new HistoricoProduto();
        historicoProduto.setDtCriacao(LocalDateTime.now());
        historicoProduto.setDtSaida(venda.getDtVenda());
        historicoProduto.setFornecedor(produto.getFornecedor());
        historicoProduto.setQuantidadeSaida(resource.getEstoque().getQuantidadeSaida());
        produto.getHistoricoProdutos().add(historicoProduto);

        return produtoRepository.save(produto);
    }

    private void validateQtdDisponivel(Produto resource){
        Assert.isTrue(resource.getQuantidadeDisponivel() != null || resource.getQuantidadeDisponivel() > 0,
                "Produto não possui estoque disponível no momento ");
    }
    private void validateProdutoDescontinuado(Produto resource){
        Assert.isTrue(resource.getDescontinuado() != true,
                "O produto foi descontinuado. ");
    }
}
