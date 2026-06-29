package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Quepe;
import br.com.ifba.fardamento.repository.QuepeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Service
@RequiredArgsConstructor
public class QuepeService implements QuepeIService {

    // Injeção de dependência automática via Lombok do Repository genérico
    private final QuepeRepository quepeRepository;

    @Override
    public Quepe save(Quepe quepe) {
        return quepeRepository.save(quepe);
    }

    @Override
    public Quepe update(Quepe quepe) {

        return quepeRepository.save(quepe);
    }

    @Override
    public void delete(Quepe quepe) {

        quepeRepository.delete(quepe);
    }

    @Override
    public List<Quepe> findAll() {

        return quepeRepository.findAll();
    }

    @Override
    public Quepe findById(Long id) {

        return quepeRepository.findById(id).orElse(null);
    }
}