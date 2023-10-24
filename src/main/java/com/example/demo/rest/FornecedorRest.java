package com.example.demo.rest;


import com.example.demo.domain.Fornecedor;
import com.example.demo.repository.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api/fornecedor")
public class FornecedorRest {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Fornecedor>> findAllFornecedor() {
        List<Fornecedor> f = fornecedorRepository.findAll();
        return ResponseEntity.ok().body(f);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findFornecedorById(@PathVariable Long id) {
        return ResponseEntity.ok(
                fornecedorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado."))
        );
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok().body(fornecedor);
    }


}
