package com.example.demo.service;

import com.example.demo.domain.Estoque;
import com.example.demo.domain.HistoricoProduto;
import com.example.demo.domain.Produto;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.repository.HistoricoProdutoRepository;
import com.example.demo.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AtualizarProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private HistoricoProdutoRepository historicoProdutoRepository;
    @Transactional
    public Produto exec(Long id, Produto resource) {
        var produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado" + id));

        var estoque = produto.getEstoque();
        estoque.setDtEntrada(LocalDateTime.now());
        estoque.setQuantidadeEntrada(resource.getEstoque().getQuantidadeEntrada());
        produto.setEstoque(estoque);

        produto.setNome(resource.getNome());
        produto.setDescricao(resource.getDescricao());
        produto.setPrecoVendaUnitario(resource.getPrecoVendaUnitario());
        produto.setPrecoCompraUnitario(resource.getPrecoCompraUnitario());
        produto.setFornecedor(resource.getFornecedor());

        Long qtAtual = produto.getQuantidadeDisponivel();
        Long qtEntradaEstoque = resource.getEstoque().getQuantidadeEntrada();
        //para atualizar a quantidade disponivel de acordo com a quantidade que irá entrar no estoque, acrescida do que já tem
        if (qtAtual != null) {
            produto.setQuantidadeDisponivel(qtAtual + qtEntradaEstoque);
        }
        HistoricoProduto historicoProduto = produto.getHistoricoProdutos().get(0);
//        var historicoProduto = new HistoricoProduto();
        historicoProduto.setDtEntrada(produto.getEstoque().getDtEntrada());
        historicoProduto.setNome(resource.getNome());
        historicoProduto.setQuantidadeEntrada(resource.getEstoque().getQuantidadeEntrada());
        historicoProduto.setFornecedor(resource.getFornecedor());
        historicoProduto.setPrecoCompraUnitario(resource.getPrecoCompraUnitario());
        historicoProduto.setPrecoVendaUnitario(resource.getPrecoVendaUnitario());
        historicoProduto.setDtCriacao(LocalDateTime.now());
        produto.getHistoricoProdutos().add(historicoProduto);
        return produtoRepository.save(produto);

    }
}
