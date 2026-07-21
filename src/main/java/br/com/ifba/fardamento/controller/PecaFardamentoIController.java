package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.PecaFardamento;
import br.com.ifba.fardamento.entity.TipoPecaFardamento;
import br.com.ifba.infrastructure.controller.GenericIController;

import java.util.List;

public interface PecaFardamentoIController extends GenericIController<PecaFardamento> {
    List<PecaFardamento> findByTipoPeca(TipoPecaFardamento tipoPeca);
    List<PecaFardamento> findByTamanho(String tamanho);
}