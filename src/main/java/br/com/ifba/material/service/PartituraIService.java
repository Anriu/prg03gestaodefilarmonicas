package br.com.ifba.material.service;

import br.com.ifba.infrastructure.service.GenericService;
import br.com.ifba.material.entity.Partitura;

import java.util.List;

public interface PartituraIService extends GenericService<Partitura> {
    List<Partitura> findByNome(String nome);
    List<Partitura> findByCompositor(String compositor);
}