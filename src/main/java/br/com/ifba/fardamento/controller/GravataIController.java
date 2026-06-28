package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Farda;
import br.com.ifba.fardamento.entity.Gravata;
import java.util.List;

/**
 * Interface de contrato para o Controller de gravata.
 * * @author anriu
 */

public interface GravataIController {

    // Salva um novo instrumento
    Gravata save(Gravata gravata);

    // Atualiza os dados de um instrumento
    Gravata update(Gravata gravata);

    // Remove um instrumento
    void delete(Gravata gravata);

    // Retorna todos os instrumentos cadastrados
    List<Gravata> findAll();

    // Busca um instrumento pelo ID
    Gravata findById(Long id);
}