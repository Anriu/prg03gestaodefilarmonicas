package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Farda;
import br.com.ifba.fardamento.repository.FardaRepository;
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
public class FardaService extends GenericServiceImpl<Farda> implements FardaIService {

    private final FardaRepository repository;

    @Override
    protected JpaRepository<Farda, Long> getRepository() {
        return repository;
    }
}