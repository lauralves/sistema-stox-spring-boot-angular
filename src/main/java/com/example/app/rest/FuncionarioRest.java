package com.example.app.rest;


import com.example.app.domain.Funcionario;
import com.example.app.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/funcionario")
public class FuncionarioRest {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @GetMapping(value = "/all")
    public ResponseEntity<List<Funcionario>> findAllFuncionarios() {
        List<Funcionario> f = funcionarioRepository.findAll();
        return ResponseEntity.ok().body(f);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findFuncionarioById(@PathVariable Long id) {
        return ResponseEntity.ok(
                funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado."))
        );
    }

    @PostMapping("/create")
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