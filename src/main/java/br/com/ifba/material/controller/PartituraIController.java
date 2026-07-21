package br.com.ifba.material.controller;

import br.com.ifba.infrastructure.controller.GenericIController;
import br.com.ifba.material.entity.Partitura;

import java.util.List;

public interface PartituraIController extends GenericIController<Partitura> {
    List<Partitura> findByNome(String nome);
    List<Partitura> findByCompositor(String compositor);
}