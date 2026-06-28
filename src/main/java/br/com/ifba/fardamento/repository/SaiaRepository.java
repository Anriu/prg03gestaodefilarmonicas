package br.com.ifba.fardamento.repository;

import br.com.ifba.fardamento.entity.Saia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anriu
 */
@Repository
public interface SaiaRepository extends JpaRepository<Saia, Long>{
    
}
