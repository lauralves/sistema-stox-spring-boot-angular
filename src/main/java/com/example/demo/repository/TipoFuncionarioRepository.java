package com.example.demo.repository;

import com.example.demo.domain.TipoFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFuncionarioRepository extends JpaRepository<TipoFuncionario, Long> {
}
