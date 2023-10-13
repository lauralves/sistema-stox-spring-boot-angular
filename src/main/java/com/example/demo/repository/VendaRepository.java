package com.example.demo.repository;

import com.example.demo.domain.Produto;
import com.example.demo.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {


}
