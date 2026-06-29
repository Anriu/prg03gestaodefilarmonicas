package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Gravata;
import br.com.ifba.fardamento.repository.GravataRepository;
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
public class GravataService extends GenericServiceImpl<Gravata> implements GravataIService {

    private final GravataRepository repository;

    @Override
    protected JpaRepository<Gravata, Long> getRepository() {
        return repository;
    }
}