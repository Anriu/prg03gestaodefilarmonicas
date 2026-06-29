package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Calca;
import br.com.ifba.fardamento.service.CalcaIService;
import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CalcaController extends GenericController<Calca> implements CalcaIController {

    private final CalcaIService calcaService;

    @Override
    protected GenericService<Calca> getService() {
        return calcaService;
    }

}