package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Farda;
import br.com.ifba.fardamento.service.FardaIService;
import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class FardaController extends GenericController<Farda> implements FardaIController {

    private final FardaIService fardaService;

    @Override
    protected GenericService<Farda> getService() {
        return fardaService;
    }

}