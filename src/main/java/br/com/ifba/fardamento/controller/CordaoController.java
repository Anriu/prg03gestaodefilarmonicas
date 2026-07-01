package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Cordao;
import br.com.ifba.fardamento.service.CordaoIService;
import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CordaoController extends GenericController<Cordao> implements CordaoIController {

    private final CordaoIService cordaoService;

    @Override
    protected GenericService<Cordao> getService() {
        return cordaoService;
    }

}