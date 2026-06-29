/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.fardamento.service;

import br.com.ifba.fardamento.entity.Cordao;
import br.com.ifba.fardamento.repository.CordaoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Service
@RequiredArgsConstructor
public class CordaoService implements CordaoIService {
    
    // Injeção de dependência automática via Lombok do Repository genérico
    private final CordaoRepository cordaoRepository;
 
    @Override
    public Cordao save(Cordao cordao) {
        return cordaoRepository.save(cordao);
    }

    @Override
    public Cordao update(Cordao cordao) {


        return cordaoRepository.save(cordao);
    }

    @Override
    public void delete(Cordao cordao) {


        cordaoRepository.delete(cordao);
    }

    @Override
    public List<Cordao> findAll() {
        
        return cordaoRepository.findAll();
    }

    @Override
    public Cordao findById(Long id) {

        return cordaoRepository.findById(id).orElse(null);
    }
}
