package br.com.ifba.pessoa.controller;

import br.com.ifba.pessoa.entity.Pessoa;
import java.util.List;

/**
 *
 * @author anriu
 */

public interface PessoaIController {
   
    Pessoa save(Pessoa pessoa);
    
    Pessoa update(Pessoa pessoa);
    
    void delete(Pessoa pessoa);
    
    List<Pessoa> findAll();
    
    Pessoa findById(Long id);
    
}
