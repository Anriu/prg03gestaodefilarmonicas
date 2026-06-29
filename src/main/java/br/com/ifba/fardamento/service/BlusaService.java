/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Blusa;
import br.com.ifba.fardamento.repository.BlusaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */

@Service
@RequiredArgsConstructor
public class BlusaService implements BlusaIService {

    // Injeção de dependência automática via Lombok do Repository genérico
    private final BlusaRepository blusaRepository;
 
    @Override
    public Blusa save(Blusa blusa) {
        return blusaRepository.save(blusa);
    }

    @Override
    public Blusa update(Blusa blusa) {


        return blusaRepository.save(blusa);
    }

    @Override
    public void delete(Blusa blusa) {


        blusaRepository.delete(blusa);
    }

    @Override
    public List<Blusa> findAll() {
        
        return blusaRepository.findAll();
    }

    @Override
    public Blusa findById(Long id) {

        return blusaRepository.findById(id).orElse(null);
    }
}
