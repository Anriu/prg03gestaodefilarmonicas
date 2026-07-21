package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.PecaFardamento;
import br.com.ifba.fardamento.entity.TipoPecaFardamento;
import br.com.ifba.infrastructure.service.GenericService;

import java.util.List;

public interface PecaFardamentoIService extends GenericService<PecaFardamento> {
    List<PecaFardamento> findByTipoPeca(TipoPecaFardamento tipoPeca);
    List<PecaFardamento> findByTamanho(String tamanho);
}