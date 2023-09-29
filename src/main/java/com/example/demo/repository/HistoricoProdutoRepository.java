package com.example.demo.repository;

import com.example.demo.domain.HistoricoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoProdutoRepository extends JpaRepository<HistoricoProduto, Long> {
}
