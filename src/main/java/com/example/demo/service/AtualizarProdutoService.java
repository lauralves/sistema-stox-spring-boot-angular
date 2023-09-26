package com.example.demo.service;

import com.example.demo.domain.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto exec(Produto resource) {
        Produto produto = produtoRepository.findById(resource.getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado" + resource.getId()));
        produto.setPrecoVendaUnitario(produto.getPrecoVendaUnitario());
        produto.setPrecoCompraUnitario(produto.getPrecoCompraUnitario());


    }
}
