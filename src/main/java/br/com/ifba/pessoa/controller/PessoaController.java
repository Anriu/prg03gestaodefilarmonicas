/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pessoa.controller;

import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.pessoa.service.PessoaIService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author anriu
 */
@Controller
@RequiredArgsConstructor
public class PessoaController implements PessoaIController {

    private final PessoaIService pessoaService;
    
    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaService.save(pessoa);
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
      return pessoaService.update(pessoa);
    }

    @Override
    public void delete(Pessoa pessoa) {
        pessoaService.delete(pessoa);
    } 

    @Override
    public List<Pessoa> findAll() {
       return pessoaService.findAll(); 
    }

    @Override
    public Pessoa findById(Long id) {
      return pessoaService.findById(id);
    }
    
}

