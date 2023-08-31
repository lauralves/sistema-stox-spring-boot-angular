package com.example.demo.rest;


import com.example.demo.domain.Fornecedor;
import com.example.demo.service.FornecedorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api/fornecedor")
public class FornecedorRest {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Fornecedor>> findAllFornecedor() {
        List<Fornecedor> f = fornecedorService.findAllFornecedor();
        return ResponseEntity.ok().body(f);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findFornecedorById(@PathVariable Long id) {
        return ResponseEntity.ok(
                fornecedorService.findFornecedorById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado."))
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok().body(fornecedor);
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor Fornecedor) {
        return ResponseEntity.ok(fornecedorService.updateFornecedor(id, Fornecedor));
    }

}
