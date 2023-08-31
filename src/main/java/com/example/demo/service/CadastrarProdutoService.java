package com.example.demo.service;


import com.example.demo.domain.Fornecedor;
import com.example.demo.domain.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CadastrarProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAllProduto (){
        return this.produtoRepository.findAll();
    }

    public Produto exec(Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado" + produtoId));

       return produtoRepository.save(produto);
    }

}
