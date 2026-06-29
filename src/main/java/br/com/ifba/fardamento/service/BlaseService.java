package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Blase;
import br.com.ifba.fardamento.repository.BlaseRepository;
import br.com.ifba.pessoa.entity.Pessoa;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Service
@RequiredArgsConstructor
public class BlaseService implements BlaseIService {
    
    // Injeção de dependência automática via Lombok do Repository genérico
    private final BlaseRepository blaseRepository;
 
    @Override
    public Blase save(Blase blase) {
        return blaseRepository.save(blase);
    }

    @Override
    public Blase update(Blase blase) {


        return blaseRepository.save(blase);
    }

    @Override
    public void delete(Blase blase) {


        blaseRepository.delete(blase);
    }

    @Override
    public List<Blase> findAll() {
        
        return blaseRepository.findAll();
    }

    @Override
    public Blase findById(Long id) {

        return blaseRepository.findById(id).orElse(null);
    }

    
}
