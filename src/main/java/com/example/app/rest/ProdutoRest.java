package com.example.app.rest;


import com.example.app.domain.Estoque;
import com.example.app.domain.Produto;
import com.example.app.domain.Venda;
import com.example.app.domain.vw.HistoricoProdutoListView;
import com.example.app.repository.ProdutoRepository;
import com.example.app.repository.vw.HistoricoProdutoListViewRepository;
import com.example.app.service.AtualizarProdutoService;
import com.example.app.service.CadastrarProdutoService;
import com.example.app.service.DescontinuarProdutoService;
import com.example.app.service.VenderProdutoService;
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
    @Autowired
    private VenderProdutoService venderProdutoService;
    @Autowired
    private DescontinuarProdutoService descontinuarProdutoService;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
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

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<Produto> updateProdutoEmEstoque(@PathVariable Long id, @RequestBody Produto produto) {
        return ResponseEntity.ok(atualizarProdutoService.exec(id, produto));
    }

    @GetMapping("/{produtoId}/historico-produto")
    private ResponseEntity<List<HistoricoProdutoListView>> findHistoricoProdutoById(@PathVariable Long produtoId){
        return ResponseEntity.ok(historicoProdutoListViewRepository.findHistoricoProdutoListViewsByProduto(produtoId));
    }
    @PatchMapping("/{id}/vender-produto")
    public ResponseEntity<Produto> venderProduto(@PathVariable Long id, @RequestBody Produto produto, Venda venda){
        return ResponseEntity.ok(venderProdutoService.exec(id, produto, venda));
    }
    @PatchMapping("/{id}/descontinuar-produto")
    public ResponseEntity<Produto> descontinuarProduto(@PathVariable Long id, @RequestBody Produto resource){
        return ResponseEntity.ok(descontinuarProdutoService.exec(id, resource));
    }
}
