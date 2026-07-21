package br.com.ifba.material.service;

import br.com.ifba.infrastructure.service.GenericServiceImpl;
import br.com.ifba.material.entity.Partitura;
import br.com.ifba.material.repository.PartituraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartituraService extends GenericServiceImpl<Partitura> implements PartituraIService {

    @Autowired
    private PartituraRepository partituraRepository;

    @Override
    protected JpaRepository<Partitura, Long> getRepository() {
        return partituraRepository;
    }

    @Override
    public List<Partitura> findByNome(String nome) {
        return partituraRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<Partitura> findByCompositor(String compositor) {
        return partituraRepository.findByCompositorContainingIgnoreCase(compositor);
    }
}