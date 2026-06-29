package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Farda;
import br.com.ifba.fardamento.repository.FardaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Service
@RequiredArgsConstructor
public class FardaService implements FardaIService {

    // Injeção de dependência automática via Lombok do Repository genérico
    private final FardaRepository fardaRepository;

    @Override
    public Farda save(Farda farda) {
        return fardaRepository.save(farda);
    }

    @Override
    public Farda update(Farda farda) {

        return fardaRepository.save(farda);
    }

    @Override
    public void delete(Farda farda) {

        fardaRepository.delete(farda);
    }

    @Override
    public List<Farda> findAll() {

        return fardaRepository.findAll();
    }

    @Override
    public Farda findById(Long id) {

        return fardaRepository.findById(id).orElse(null);
    }
}