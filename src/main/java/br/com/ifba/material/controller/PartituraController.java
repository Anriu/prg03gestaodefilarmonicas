package br.com.ifba.material.controller;

import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import br.com.ifba.material.entity.Partitura;
import br.com.ifba.material.service.PartituraIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PartituraController extends GenericController<Partitura> implements PartituraIController {

    @Autowired
    private PartituraIService partituraService;

    @Override
    protected GenericService<Partitura> getService() {
        return partituraService;
    }

    @Override
    public List<Partitura> findByNome(String nome) {
        return partituraService.findByNome(nome);
    }

    @Override
    public List<Partitura> findByCompositor(String compositor) {
        return partituraService.findByCompositor(compositor);
    }
}