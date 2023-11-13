package com.example.app.rest;


import com.example.app.domain.Fornecedor;
import com.example.app.repository.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/fornecedor")
@AllArgsConstructor
public class FornecedorRest {

    private FornecedorRepository fornecedorRepository;

    @GetMapping
    public ResponseEntity<Page<Fornecedor>> findAllFornecedor(Pageable pageable) {
        return ResponseEntity.ok(fornecedorRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findFornecedorById(@PathVariable Long id) {
        return ResponseEntity.ok(
                fornecedorRepository.findById(id).orElseThrow(() ->
                        new EntityNotFoundException("Funcionário não encontrado.")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok().body(fornecedor);
    }


}
