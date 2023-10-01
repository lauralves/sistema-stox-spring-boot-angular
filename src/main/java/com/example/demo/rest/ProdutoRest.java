package com.example.demo.rest;


import com.example.demo.domain.Estoque;
import com.example.demo.domain.Produto;
import com.example.demo.domain.vw.HistoricoProdutoListView;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.repository.vw.HistoricoProdutoListViewRepository;
import com.example.demo.service.AtualizarProdutoService;
import com.example.demo.service.CadastrarProdutoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoRest {

    @Autowired
    private CadastrarProdutoService produtoService;

    @Autowired
    private AtualizarProdutoService atualizarProdutoService;

//    @Autowired
    @Autowired
    private ProdutoRepository produtoRepository;
//    @Autowired
    private HistoricoProdutoListViewRepository historicoProdutoListViewRepository;
    @GetMapping
    public ResponseEntity<Page<?>> findAllProdutos(Pageable pageable) {
        Page<?> produtos = this.produtoRepository.findAll(pageable);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findprodutoById(@PathVariable Long id) {
        return ResponseEntity.ok(
                produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."))
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createProduto(@RequestBody Produto produto, Estoque estoque) {
        return ResponseEntity.ok(produtoService.exec(produto, estoque));
    }

    @PatchMapping("/{id}/atualizar")
    public ResponseEntity<Produto> updateProdutoEmEstoque(@PathVariable Long id, @RequestBody Produto produto) {
        return ResponseEntity.ok(atualizarProdutoService.exec(id, produto));
    }

    @GetMapping("/{produtoId}/historico-produto")
    private ResponseEntity<List<HistoricoProdutoListView>> findHistoricoProdutoById(@PathVariable Long produtoId){
        return ResponseEntity.ok(historicoProdutoListViewRepository.findHistoricoProdutoListViewsByProduto(produtoId));
    }
//    @PatchMapping("/{id}/vender-produto")
//    public ResponseEntity<Produto> venderProduto(@PathVariable Long id, @RequestBody Produto produto){
//        return ResponseEntity.ok(venderProdutoService.exec(id, produto));
//    }
}
