package com.example.app.service;

import com.example.app.domain.Produto;
import com.example.app.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@AllArgsConstructor
@Slf4j
public class ReverterDescontinuarProdutoService {
    private final ProdutoRepository produtoRepository;

    public Produto exec(Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado" +id));

        validateProdutoDescontinuadoTrue(produto);

        produto.setDescontinuado(false);
        produto.setDescontinuadoEm(null);
        produto.setDescontinuadoObservacao(null);
        produto.setDescontinuadoPor(null);
        return  produtoRepository.save(produto);

    }

    private void validateProdutoDescontinuadoTrue(Produto resource){
        Assert.isTrue(resource.getDescontinuado(),
                "O produto não foi descontinuado. ");
    }
}
