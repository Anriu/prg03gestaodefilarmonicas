package br.com.ifba.pessoa.service;

import br.com.ifba.pessoa.entity.Pessoa;
import java.util.List;

/**
 *
 * @author anriu
 */
public interface PessoaIService {
    
    Pessoa save(Pessoa pessoa);
    
    Pessoa update(Pessoa pessoa);
    
    void delete(Pessoa pessoa);
    
    List<Pessoa> findAll();
    
    Pessoa findById(Long id); 
    
}
