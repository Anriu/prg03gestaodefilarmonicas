package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Quepe;
import br.com.ifba.fardamento.repository.QuepeRepository;
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
public class QuepeService extends GenericServiceImpl<Quepe> implements QuepeIService {

    private final QuepeRepository repository;

    @Override
   protected JpaRepository<Quepe, Long> getRepository() {
        return repository;
    }
}