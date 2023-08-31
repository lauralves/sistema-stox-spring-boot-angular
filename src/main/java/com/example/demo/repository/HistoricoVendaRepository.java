package com.example.demo.repository;

import com.example.demo.domain.HistoricoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoVendaRepository extends JpaRepository<HistoricoVenda, Long> {
}
