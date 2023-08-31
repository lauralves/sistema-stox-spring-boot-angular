package com.example.demo.rest;


import com.example.demo.domain.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.CadastrarProdutoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoRest {

    @Autowired
    private CadastrarProdutoService produtoService;

    private ProdutoRepository produtoRepository;
    @GetMapping
    public ResponseEntity<List<Produto>> findAllProdutos() {
        return ResponseEntity.ok(
               produtoService.findAllProduto()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findprodutoById(@PathVariable Long id) {
        return ResponseEntity.ok(
                produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."))
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createProduto(@RequestBody Long produto) {
        return ResponseEntity.ok(produtoService.exec(produto));
    }

//    @PutMapping("/{id}/atualizar")
//    public ResponseEntity<Produto> updateproduto(@PathVariable Long id, @RequestBody Produto produto) {
//        return ResponseEntity.ok(produtoService.updateProduto(id, produto));
//    }
}
