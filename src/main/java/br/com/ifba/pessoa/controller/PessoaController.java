/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pessoa.controller;

import br.com.ifba.infrastructure.controller.GenericController;
import br.com.ifba.infrastructure.service.GenericService;
import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.pessoa.service.PessoaIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author anriu
 */

@Controller
@RequiredArgsConstructor
public class PessoaController extends GenericController<Pessoa> implements PessoaIController {

    private final PessoaIService pessoaService;

    @Override
    protected GenericService<Pessoa> getService() {
        return pessoaService;
    }

}
