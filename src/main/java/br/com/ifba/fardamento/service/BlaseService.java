package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Blase;
import br.com.ifba.fardamento.repository.BlaseRepository;
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
public class BlaseService extends GenericServiceImpl<Blase> implements BlaseIService {

    private final BlaseRepository repository;

    @Override
    protected JpaRepository<Blase, Long> getRepository() {
        return repository;
    }
}