package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Calca;
import br.com.ifba.fardamento.repository.CalcaRepository;
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
public class CalcaService extends GenericServiceImpl<Calca> implements CalcaIService {

    private final CalcaRepository repository;

    @Override
   protected JpaRepository<Calca, Long> getRepository() {
        return repository;
    }
}