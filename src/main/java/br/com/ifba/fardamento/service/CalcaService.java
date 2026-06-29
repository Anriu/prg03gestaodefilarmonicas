package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Calca;
import br.com.ifba.fardamento.repository.CalcaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */

@Service
@RequiredArgsConstructor
public class CalcaService implements CalcaIService {
   
    
    // Injeção de dependência automática via Lombok do Repository genérico
    private final CalcaRepository calcaRepository;
 
    @Override
    public Calca save(Calca calca) {
        return calcaRepository.save(calca);
    }

    @Override
    public Calca update(Calca calca) {


        return calcaRepository.save(calca);
    }

    @Override
    public void delete(Calca calca) {


        calcaRepository.delete(calca);
    }

    @Override
    public List<Calca> findAll() {
        
        return calcaRepository.findAll();
    }

    @Override
    public Calca findById(Long id) {

        return calcaRepository.findById(id).orElse(null);
    }
}
