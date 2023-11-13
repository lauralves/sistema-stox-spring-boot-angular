package com.example.app.service;

import com.example.app.domain.Produto;
import com.example.app.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

import static java.awt.SystemColor.info;

@Service
@AllArgsConstructor
@Slf4j
public class DescontinuarProdutoService {
    private final ProdutoRepository produtoRepository;

    public Produto exec(Long id, Produto resource){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado" + id));
        validateProdutoDescontinuado(produto);
        validateProdutoDescontinuadoObservacao(resource);

        log.info("Descontinuando produto: {}", produto.getNome());
        produto.setDescontinuado(true);
        produto.setDescontinuadoEm(LocalDateTime.now());
        produto.setDescontinuadoObservacao(resource.getDescontinuadoObservacao());
        return produtoRepository.save(produto);
    }

    private void validateProdutoDescontinuado(Produto resource){
        Assert.isTrue(!resource.getDescontinuado() || resource.getDescontinuado() == null,
                "O produto já foi descontinuado. ");
    }
    private void validateProdutoDescontinuadoObservacao(Produto resource){
        Assert.notNull(resource.getDescontinuadoObservacao(),
                "Para descontinuar um produto a observação deve ser preenchida. ");
    }

}
