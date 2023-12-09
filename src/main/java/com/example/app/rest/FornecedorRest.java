package com.example.app.rest;

import com.example.app.domain.Fornecedor;
import com.example.app.domain.vw.FornecedorListView;
import com.example.app.repository.FornecedorRepository;
import com.example.app.repository.vw.FornecedorListViewRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/api/fornecedor")
@AllArgsConstructor
public class FornecedorRest {

    private FornecedorRepository fornecedorRepository;
    private FornecedorListViewRepository fornecedorListViewRepository;

    @GetMapping
    public ResponseEntity<Page<FornecedorListView>> findAllFornecedor(Pageable pageable) {
        return ResponseEntity.ok(fornecedorListViewRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findFornecedorById(@PathVariable Long id) {
        return ResponseEntity.ok(
                fornecedorRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado.")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok(fornecedorRepository.save(fornecedor));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Requisição de exclusão do registro fornecedor (id={})", id);
        if (!fornecedorRepository.existsById(id))
            throw new EntityNotFoundException("Fornecedor não encontrado.");
        fornecedorRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor resource) {
        log.info("Requisição para atualizar o registro fornecedor (id={})", id);
        var fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado"));
        log.info("teste id ", fornecedor.getId());
        fornecedor.setNome(resource.getNome());
        return ResponseEntity.ok(fornecedorRepository.save(fornecedor));
    }
}
