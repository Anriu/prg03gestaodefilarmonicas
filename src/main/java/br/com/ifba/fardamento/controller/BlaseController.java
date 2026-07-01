package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Blase;
import br.com.ifba.fardamento.service.BlaseIService;
import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * Controller responsável por intermediar as requisições das telas Swing
 * com as regras de negócio do Service de Blase.
 *
 * @author anriu
 */

@Controller
@RequiredArgsConstructor
public class BlaseController extends GenericController<Blase> implements BlaseIController {

    private final BlaseIService blaseService;

    @Override
    protected GenericService<Blase> getService() {
        return blaseService;
    }


}