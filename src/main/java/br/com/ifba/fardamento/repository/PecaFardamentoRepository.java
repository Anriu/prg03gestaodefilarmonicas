package br.com.ifba.fardamento.repository;

import br.com.ifba.fardamento.entity.PecaFardamento;
import br.com.ifba.fardamento.entity.TipoPecaFardamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PecaFardamentoRepository extends JpaRepository<PecaFardamento, Long> {
    List<PecaFardamento> findByTipoPeca(TipoPecaFardamento tipoPeca);
    List<PecaFardamento> findByTamanho(String tamanho);
}