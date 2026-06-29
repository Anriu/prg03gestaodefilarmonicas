package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.EntregaFarda;
import java.util.List;

/**
 *
 * @author anriu
 */
public interface EntregaFardaIService {
    
    EntregaFarda save(EntregaFarda entregaFarda);
    
    EntregaFarda update(EntregaFarda entregaFarda);
    
    void delete(EntregaFarda entregaFarda);
    
    List<EntregaFarda> findAll();
    
    EntregaFarda findById(Long id);
}
