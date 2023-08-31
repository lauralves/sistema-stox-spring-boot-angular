package com.example.demo.service;


import com.example.demo.domain.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAllFuncionarios (){
        return this.funcionarioRepository.findAll();
    }
    public Optional<Funcionario> findFuncionarioById (Long id) {
        return this.funcionarioRepository.findById(id);
    }
    public void deleteFuncionarioById (Long id){
        this.funcionarioRepository.deleteById(id);
    }
    public Funcionario createFuncionario (Funcionario funcionario) {
        return this.funcionarioRepository.save(funcionario);
    }
    public Funcionario updateFuncionario(Long id, Funcionario funcionario) {
        Funcionario f = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado."));
        f.setNome(funcionario.getNome());
        f.setLogin(funcionario.getLogin());
        f.setSenha(funcionario.getSenha());

        return funcionarioRepository.save(f);
    }
}
