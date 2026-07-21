package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.PecaFardamento;
import br.com.ifba.fardamento.entity.TipoPecaFardamento;
import br.com.ifba.fardamento.service.PecaFardamentoIService;
import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PecaFardamentoController extends GenericController<PecaFardamento> implements PecaFardamentoIController {

    @Autowired
    private PecaFardamentoIService pecaFardamentoService;

    @Override
    protected GenericService<PecaFardamento> getService() {
        return pecaFardamentoService;
    }

    @Override
    public List<PecaFardamento> findByTipoPeca(TipoPecaFardamento tipoPeca) {
        return pecaFardamentoService.findByTipoPeca(tipoPeca);
    }

    @Override
    public List<PecaFardamento> findByTamanho(String tamanho) {
        return pecaFardamentoService.findByTamanho(tamanho);
    }
}