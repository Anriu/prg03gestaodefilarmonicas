package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Saia;
import java.util.List;

/**
 * Interface de contrato para o Controller de saia.
 * * @author anriu
 */

public interface SaiaIController {

    // Salva um novo instrumento
    Saia save(Saia saia);

    // Atualiza os dados de um instrumento
    Saia update(Saia saia);

    // Remove um instrumento
    void delete(Saia saia);

    // Retorna todos os instrumentos cadastrados
    List<Saia> findAll();

    // Busca um instrumento pelo ID
    Saia findById(Long id);
}