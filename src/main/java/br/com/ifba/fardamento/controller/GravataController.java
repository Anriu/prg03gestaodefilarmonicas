package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Gravata;
import br.com.ifba.fardamento.service.GravataIService;
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
public class GravataController extends GenericController<Gravata> implements GravataIController {

    private final GravataIService gravataService;

    @Override
    protected GenericService<Gravata> getService() {
        return gravataService;
    }

}
