package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Blusa;
import br.com.ifba.fardamento.repository.BlusaRepository;
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
public class BlusaService extends GenericServiceImpl<Blusa> implements BlusaIService {

    private final BlusaRepository repository;

    @Override
    protected JpaRepository<Blusa, Long> getRepository() {
        return repository;
    }
}