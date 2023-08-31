package com.example.demo.service;


import com.example.demo.domain.Fornecedor;
import com.example.demo.repository.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAllFornecedor (){
        return this.fornecedorRepository.findAll();
    }
    public Optional<Fornecedor> findFornecedorById (Long id) {
        return this.fornecedorRepository.findById(id);
    }
    public void deleteFornecedorById (Long id){
        this.fornecedorRepository.deleteById(id);
    }
    public Fornecedor createFornecedor (String nome) {
        Fornecedor f = new Fornecedor();
        f.setNome(nome);


        return this.fornecedorRepository.save(f);
    }
    public Fornecedor updateFornecedor(Long id, Fornecedor fornecedor) {
        Fornecedor f = fornecedorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado."));
        f.setNome(fornecedor.getNome());
        return fornecedorRepository.save(f);
    }
}
