package com.example.app.repository.vw;

import com.example.app.domain.vw.HistoricoProdutoListView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HistoricoProdutoListViewRepository extends JpaRepository<HistoricoProdutoListView, Long> {
    List<HistoricoProdutoListView> findHistoricoProdutoListViewsByProduto(Long produtoId);
}
