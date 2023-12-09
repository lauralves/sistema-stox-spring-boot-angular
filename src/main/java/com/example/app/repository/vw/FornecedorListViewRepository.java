package com.example.app.repository.vw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.domain.vw.FornecedorListView;

@Repository
public  interface FornecedorListViewRepository extends JpaRepository<FornecedorListView, Long>{
    
}