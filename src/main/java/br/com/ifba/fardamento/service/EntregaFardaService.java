package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.EntregaFarda;
import br.com.ifba.fardamento.repository.EntregaFardaRepository;
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
public class EntregaFardaService extends GenericServiceImpl<EntregaFarda> implements EntregaFardaIService {

    private final EntregaFardaRepository repository;

    @Override
    protected JpaRepository<EntregaFarda, Long> getRepository() {
        return repository;
    }
}