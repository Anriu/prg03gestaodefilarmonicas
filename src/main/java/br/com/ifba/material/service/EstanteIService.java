package br.com.ifba.material.service;

import br.com.ifba.infrastructure.service.GenericService;
import br.com.ifba.material.entity.Estante;

import java.util.List;

public interface EstanteIService extends GenericService<Estante> {
    List<Estante> findByModelo(String modelo);
}