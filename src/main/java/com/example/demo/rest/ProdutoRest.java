package com.example.demo.rest;


import com.example.demo.domain.Estoque;
import com.example.demo.domain.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.CadastrarProdutoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produto")
public class ProdutoRest {

    @Autowired
    private CadastrarProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;
    @GetMapping
    public ResponseEntity<Page<Produto>> findAllProdutos(Pageable pageable) {
        Page<Produto> produtos = this.produtoRepository.findAll(pageable);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findprodutoById(@PathVariable Long id) {
        return ResponseEntity.ok(
                produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."))
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createProduto(@RequestBody Produto produto, Estoque estoque) {
        return ResponseEntity.ok(produtoService.exec(produto, estoque));
    }

//    @PutMapping("/{id}/atualizar")
//    public ResponseEntity<Produto> updateproduto(@PathVariable Long id, @RequestBody Produto produto) {
//        return ResponseEntity.ok(produtoService.updateProduto(id, produto));
//    }
}
