package br.com.ifba.material.controller;

import br.com.ifba.infrastructure.controller.GenericIController;
import br.com.ifba.material.entity.Estante;

import java.util.List;

public interface EstanteIController extends GenericIController<Estante> {
    List<Estante> findByModelo(String modelo);
}