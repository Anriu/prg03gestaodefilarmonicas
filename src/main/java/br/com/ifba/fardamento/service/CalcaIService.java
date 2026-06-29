package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Calca;
import java.util.List;

/**
 *
 * @author anriu
 */
public interface CalcaIService {
    Calca save(Calca calca);
    
    Calca update(Calca calca);
    
    void delete(Calca calca);
    
    List<Calca> findAll();
    
    Calca findById(Long id);
}
