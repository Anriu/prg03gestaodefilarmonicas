package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Calca;
import java.util.List;

/**
 * Interface de contrato para o Controller de calca.
 * * @author anriu
 */
public interface CalcaIController {

    // Salva um novo instrumento
    Calca save(Calca calca);

    // Atualiza os dados de um instrumento
    Calca update(Calca calca);

    // Remove um instrumento
    void delete(Calca calca);

    // Retorna todos os instrumentos cadastrados
    List<Calca> findAll();

    // Busca um instrumento pelo ID
    Calca findById(Long id);
}