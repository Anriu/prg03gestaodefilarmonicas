package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Blusa;
import java.util.List;

/**
 *
 * @author anriu
 */
public interface BlusaIService {
    Blusa save(Blusa blusa);
    
    Blusa update(Blusa blusa);
    
    void delete(Blusa blusa);
    
    List<Blusa> findAll();
    
    Blusa findById(Long id); 
}
