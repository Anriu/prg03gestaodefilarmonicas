package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Farda;
import br.com.ifba.fardamento.service.FardaIService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FardaController implements FardaIController {

    private final FardaIService fardaService;

    @Override
    public Farda save(Farda farda) {
        log.info("Controller recebeu solicitação para salvar farda");
        return fardaService.save(farda);
    }

    @Override
    public Farda update(Farda farda) {
        log.info("Controller recebeu solicitação para atualizar farda ID {}", farda.getId());
        return fardaService.update(farda);
    }

    @Override
    public void delete(Farda farda) {
        log.info("Controller recebeu solicitação para remover farda ID {}", farda.getId());
        fardaService.delete(farda);
    }

    @Override
    public List<Farda> findAll() {
        log.info("Controller recebeu solicitação para listar todas as fardas");
        return fardaService.findAll();
    }

    @Override
    public Farda findById(Long id) {
        log.info("Controller recebeu solicitação para buscar farda ID {}", id);
        return fardaService.findById(id);
    }
}