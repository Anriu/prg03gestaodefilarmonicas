package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Cordao;
import br.com.ifba.fardamento.repository.CordaoRepository;
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
public class CordaoService extends GenericServiceImpl<Cordao> implements CordaoIService {

    private final CordaoRepository repository;

    @Override
   protected JpaRepository<Cordao, Long> getRepository() {
        return repository;
    }
}