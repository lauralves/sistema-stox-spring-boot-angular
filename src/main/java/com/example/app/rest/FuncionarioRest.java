package com.example.app.rest;


import com.example.app.domain.Funcionario;
import com.example.app.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/funcionario")
@AllArgsConstructor
public class FuncionarioRest {

    private FuncionarioRepository funcionarioRepository;
    @GetMapping
    public ResponseEntity<Page<Funcionario>> findAllFuncionarios(Pageable pageable) {
        return ResponseEntity.ok(funcionarioRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findFuncionarioById(@PathVariable Long id) {
        return ResponseEntity.ok(
                funcionarioRepository.findById(id).orElseThrow(() ->
                        new EntityNotFoundException("Funcionário não encontrado.")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(
                funcionarioRepository.save(funcionario)
        );
    }

    @PatchMapping("/{id}/atualizar")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        if(!funcionarioRepository.existsById(id)) throw new EntityNotFoundException("Funcionario não encontrado" + id);
        return ResponseEntity.ok(funcionarioRepository.save(funcionario));
    }

}
