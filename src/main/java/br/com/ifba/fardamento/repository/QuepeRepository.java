package br.com.ifba.fardamento.repository;

import br.com.ifba.fardamento.entity.Quepe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anriu
 */
@Repository
public interface QuepeRepository extends JpaRepository<Quepe, Long>{
    
}
