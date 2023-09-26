package com.example.demo.repository;

import com.example.demo.domain.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
