package br.com.ifba.pessoa.repository;

import br.com.ifba.pessoa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anriu
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
