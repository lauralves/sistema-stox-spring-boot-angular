package com.example.demo.service;


import com.example.demo.domain.Estoque;
import com.example.demo.domain.Funcionario;
import com.example.demo.domain.Produto;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;


@Service
public class CadastrarEstoqueService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstoqueRepository estoqueRepository;
    public Produto exec(Produto produto, Estoque estoque) {
        //seta as informações do estoque
        Long qtEntrada = produto.getEstoque().getQuantidadeEntrada();
        estoque.setQuantidadeEntrada(qtEntrada);
        estoque.setDtEntrada(LocalDateTime.now());
        Assert.notNull(estoque.getDtEntrada(), "A data de entrada do produto não pode ser nula");
        //salva o produto
        produto.setQuantidadeDisponivel(estoque.getQuantidadeEntrada());
        return produtoRepository.save(produto);
    }

}
