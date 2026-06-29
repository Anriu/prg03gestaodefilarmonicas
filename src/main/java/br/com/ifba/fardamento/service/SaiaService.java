package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Saia;
import br.com.ifba.fardamento.repository.SaiaRepository;
import br.com.ifba.infrastructure.service.GenericServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Service
@RequiredArgsConstructor
public class SaiaService extends GenericServiceImpl<Saia> implements SaiaIService {

    private final SaiaRepository repository;

    @Override
    protected JpaRepository<Saia, Long> getRepository() {
        return repository;
    }
    
}