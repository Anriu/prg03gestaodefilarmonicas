package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Blusa;
import br.com.ifba.fardamento.service.BlusaIService;
import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BlusaController extends GenericController<Blusa> implements BlusaIController {

    private final BlusaIService blusaService;

    @Override
    protected GenericService<Blusa> getService() {
        return blusaService;
    }

}