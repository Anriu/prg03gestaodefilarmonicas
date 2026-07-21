package br.com.ifba.material.repository;

import br.com.ifba.material.entity.Partitura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartituraRepository extends JpaRepository<Partitura, Long> {
    List<Partitura> findByNomeContainingIgnoreCase(String nome);
    List<Partitura> findByCompositorContainingIgnoreCase(String compositor);
}