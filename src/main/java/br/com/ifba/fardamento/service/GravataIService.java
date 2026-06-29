package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Gravata;
import java.util.List;

/**
 *
 * @author anriu
 */
public interface GravataIService {
    
    Gravata save(Gravata gravata);
    
    Gravata update(Gravata gravata);
    
    void delete(Gravata gravata);
    
    List<Gravata> findAll();
    
    Gravata findById(Long id);
}
