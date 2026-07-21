package br.com.ifba.material.repository;

import br.com.ifba.material.entity.Estante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstanteRepository extends JpaRepository<Estante, Long> {
    List<Estante> findByModeloContainingIgnoreCase(String modelo);
}