package com.example.demo.rest;


import com.example.demo.domain.Funcionario;
import com.example.demo.service.FuncionarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/funcionario")
public class FuncionarioRest {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Funcionario>> findAllFuncionarios() {
        List<Funcionario> f = funcionarioService.findAllFuncionarios();
        return ResponseEntity.ok().body(f);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findFuncionarioById(@PathVariable Long id) {
        return ResponseEntity.ok(
                funcionarioService.findFuncionarioById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado."))
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(
                funcionarioService.createFuncionario(funcionario)
        );
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.updateFuncionario(id, funcionario));
    }

}
