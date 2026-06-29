package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.EntregaFarda;
import br.com.ifba.fardamento.service.EntregaFardaIService;
import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EntregaFardaController extends GenericController<EntregaFarda> implements EntregaFardaIController {

    private final EntregaFardaIService blusaService;

    @Override
    protected GenericService<EntregaFarda> getService() {
        return blusaService;
    }

}