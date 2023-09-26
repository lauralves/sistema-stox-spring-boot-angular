package com.example.demo.service;

import com.example.demo.domain.Estoque;
import com.example.demo.domain.Produto;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Service
public class AtualizarProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    public Produto exec(Long id, Produto resource) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado" + id));

        Estoque estoque = produto.getEstoque();
        estoque.setDtEntrada(LocalDateTime.now());
        estoque.setQuantidadeEntrada(resource.getEstoque().getQuantidadeEntrada());
        produto.setEstoque(estoque);

        produto.setPrecoVendaUnitario(resource.getPrecoVendaUnitario());
        produto.setPrecoCompraUnitario(resource.getPrecoCompraUnitario());

        Long qtAtual = produto.getQuantidadeDisponivel();
        Long qtEntradaEstoque = resource.getEstoque().getQuantidadeEntrada();
        //para atualizar a quantidade disponivel de acordo com a quantidade que irá entrar no estoque, acrescida do que já tem
        if (qtAtual != null) {
            produto.setQuantidadeDisponivel(qtAtual + qtEntradaEstoque);
        }
        return produtoRepository.save(produto);

    }
}
