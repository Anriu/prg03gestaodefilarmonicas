package br.com.ifba.material.controller;

import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import br.com.ifba.material.entity.Estante;
import br.com.ifba.material.service.EstanteIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EstanteController extends GenericController<Estante> implements EstanteIController {

    @Autowired
    private EstanteIService estantePartituraService;

    @Override
    protected GenericService<Estante> getService() {
        return estantePartituraService;
    }

    @Override
    public List<Estante> findByModelo(String modelo) {
        return estantePartituraService.findByModelo(modelo);
    }
}