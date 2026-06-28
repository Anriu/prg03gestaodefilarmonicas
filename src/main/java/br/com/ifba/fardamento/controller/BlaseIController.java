package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Blase;
import java.util.List;

/**
 * Interface de contrato para o Controller de blase.
 * * @author anriu
 */
public interface BlaseIController {

    // Salva um novo instrumento
    Blase save(Blase blase);

    // Atualiza os dados de um instrumento
    Blase update(Blase blase);

    // Remove um instrumento
    void delete(Blase blase);

    // Retorna todos os instrumentos cadastrados
    List<Blase> findAll();

    // Busca um instrumento pelo ID
    Blase findById(Long id);
}