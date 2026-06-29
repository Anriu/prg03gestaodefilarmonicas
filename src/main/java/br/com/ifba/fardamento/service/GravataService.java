package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Gravata;
import br.com.ifba.fardamento.repository.GravataRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Service
@RequiredArgsConstructor
public class GravataService implements GravataIService {

    // Injeção de dependência automática via Lombok do Repository genérico
    private final GravataRepository gravataRepository;

    @Override
    public Gravata save(Gravata gravata) {
        return gravataRepository.save(gravata);
    }

    @Override
    public Gravata update(Gravata gravata) {

        return gravataRepository.save(gravata);
    }

    @Override
    public void delete(Gravata gravata) {

        gravataRepository.delete(gravata);
    }

    @Override
    public List<Gravata> findAll() {

        return gravataRepository.findAll();
    }

    @Override
    public Gravata findById(Long id) {

        return gravataRepository.findById(id).orElse(null);
    }
}