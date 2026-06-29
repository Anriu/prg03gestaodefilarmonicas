package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.EntregaFarda;
import br.com.ifba.fardamento.repository.EntregaFardaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Service
@RequiredArgsConstructor
public class EntregaFardaService implements EntregaFardaIService {

    // Injeção de dependência automática via Lombok do Repository genérico
    private final EntregaFardaRepository entregaFardaRepository;

    @Override
    public EntregaFarda save(EntregaFarda entregaFarda) {
        return entregaFardaRepository.save(entregaFarda);
    }

    @Override
    public EntregaFarda update(EntregaFarda entregaFarda) {

        return entregaFardaRepository.save(entregaFarda);
    }

    @Override
    public void delete(EntregaFarda entregaFarda) {

        entregaFardaRepository.delete(entregaFarda);
    }

    @Override
    public List<EntregaFarda> findAll() {

        return entregaFardaRepository.findAll();
    }

    @Override
    public EntregaFarda findById(Long id) {

        return entregaFardaRepository.findById(id).orElse(null);
    }
}