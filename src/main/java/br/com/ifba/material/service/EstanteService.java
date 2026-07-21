package br.com.ifba.material.service;

import br.com.ifba.infrastructure.service.GenericServiceImpl;
import br.com.ifba.material.entity.Estante;
import br.com.ifba.material.repository.EstanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstanteService extends GenericServiceImpl<Estante> implements EstanteIService {

    @Autowired
    private EstanteRepository estantePartituraRepository;

    @Override
    protected JpaRepository<Estante, Long> getRepository() {
        return estantePartituraRepository;
    }

    @Override
    public List<Estante> findByModelo(String modelo) {
        return estantePartituraRepository.findByModeloContainingIgnoreCase(modelo);
    }
}