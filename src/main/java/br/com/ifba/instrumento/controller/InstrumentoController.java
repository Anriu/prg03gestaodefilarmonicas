package br.com.ifba.instrumento.controller;

import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import br.com.ifba.instrumento.entity.Instrumento;
import br.com.ifba.instrumento.service.InstrumentoIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * Controller responsável por intermediar as requisições das telas Swing 
 * com as regras de negócio do Service de Instrumento.
 * * @author anriu
 */

@Controller
@RequiredArgsConstructor
public class InstrumentoController extends GenericController<Instrumento> implements InstrumentoIController {

    private final InstrumentoIService instrumentoService;

    @Override
    protected GenericService<Instrumento> getService() {
        return instrumentoService;
    }

}