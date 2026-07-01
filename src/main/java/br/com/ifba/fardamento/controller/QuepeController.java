package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Quepe;
import br.com.ifba.fardamento.service.QuepeIService;
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
public class QuepeController extends GenericController<Quepe> implements QuepeIController {

    private final QuepeIService quepeService;

    @Override
    protected GenericService<Quepe> getService() {
        return quepeService;
    }

}
