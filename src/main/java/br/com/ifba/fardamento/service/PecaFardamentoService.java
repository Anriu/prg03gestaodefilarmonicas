package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.PecaFardamento;
import br.com.ifba.fardamento.entity.TipoPecaFardamento;
import br.com.ifba.fardamento.repository.PecaFardamentoRepository;
import br.com.ifba.infrastructure.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PecaFardamentoService extends GenericServiceImpl<PecaFardamento> implements PecaFardamentoIService {

    @Autowired
    private PecaFardamentoRepository pecaFardamentoRepository;

    @Override
    protected JpaRepository<PecaFardamento, Long> getRepository() {
        return pecaFardamentoRepository;
    }

    @Override
    public List<PecaFardamento> findByTipoPeca(TipoPecaFardamento tipoPeca) {
        return pecaFardamentoRepository.findByTipoPeca(tipoPeca);
    }

    @Override
    public List<PecaFardamento> findByTamanho(String tamanho) {
        return pecaFardamentoRepository.findByTamanho(tamanho);
    }
}