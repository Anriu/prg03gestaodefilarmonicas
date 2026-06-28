package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Quepe;
import java.util.List;

/**
 * Interface de contrato para o Controller de quepe.
 * * @author anriu
 */

public interface QuepeIController {

    // Salva um novo instrumento
    Quepe save(Quepe quepe);

    // Atualiza os dados de um instrumento
    Quepe update(Quepe quepe);

    // Remove um instrumento
    void delete(Quepe quepe);

    // Retorna todos os instrumentos cadastrados
    List<Quepe> findAll();

    // Busca um instrumento pelo ID
    Quepe findById(Long id);
}