package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Saia;
import br.com.ifba.fardamento.repository.SaiaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Service
@RequiredArgsConstructor
public class SaiaService implements SaiaIService {

    // Injeção de dependência automática via Lombok do Repository genérico
    private final SaiaRepository saiaRepository;

    @Override
    public Saia save(Saia saia) {
        return saiaRepository.save(saia);
    }

    @Override
    public Saia update(Saia saia) {

        return saiaRepository.save(saia);
    }

    @Override
    public void delete(Saia saia) {

        saiaRepository.delete(saia);
    }

    @Override
    public List<Saia> findAll() {

        return saiaRepository.findAll();
    }

    @Override
    public Saia findById(Long id) {

        return saiaRepository.findById(id).orElse(null);
    }
}