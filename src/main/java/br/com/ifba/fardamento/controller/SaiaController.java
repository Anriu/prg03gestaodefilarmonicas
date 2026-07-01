package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Saia;
import br.com.ifba.fardamento.service.SaiaIService;
import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author anriu
 */

@Controller
@RequiredArgsConstructor
public class SaiaController extends GenericController<Saia> implements SaiaIController {

    private final SaiaIService saiaService;

    @Override
    protected GenericService<Saia> getService() {
        return saiaService;
    }

}
