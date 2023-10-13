package com.example.demo.service;

import com.example.demo.domain.Estoque;
import com.example.demo.domain.HistoricoProduto;
import com.example.demo.domain.Produto;
import com.example.demo.domain.Venda;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.repository.VendaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@Service
public class VenderProdutoService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Transactional
    public Produto exec(Long id, Produto resource, Venda venda){
        Produto produto = produtoRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Produto não encontrado" + id));

        if(produto.getQuantidadeDisponivel() == null ){
            throw new RuntimeException("Produto não possui estoque disponível no momento");
        }

        var estoque = produto.getEstoque();
        estoque.setDtSaida(LocalDateTime.now());
        estoque.setQuantidadeSaida(resource.getEstoque().getQuantidadeSaida());

        venda.setDtVenda(LocalDateTime.now());
        venda.setVendaPor(produto.getFuncionario().getNome().toString());
        venda.setQuantidade(resource.getEstoque().getQuantidadeSaida());
        venda.getProdutos().add(produto);
        vendaRepository.save(venda);

        var historicoProduto = produto.getHistoricoProdutos().get(0);
        historicoProduto.setDtSaida(venda.getDtVenda());
        historicoProduto.setFornecedor(produto.getFornecedor());
        historicoProduto.setQuantidadeSaida(resource.getEstoque().getQuantidadeSaida());
        produto.getHistoricoProdutos().add(historicoProduto);

        return produtoRepository.save(produto);
    }
}
