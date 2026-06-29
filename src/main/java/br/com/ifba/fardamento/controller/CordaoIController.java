package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Cordao;
import java.util.List;

/**
 * Interface de contrato para o Controller de cordao.
 * * @author anriu
 */

public interface CordaoIController {

    // Salva um novo instrumento
    Cordao save(Cordao cordao);

    // Atualiza os dados de um instrumento
    Cordao update(Cordao cordao);

    // Remove um instrumento
    void delete(Cordao cordao);

    // Retorna todos os instrumentos cadastrados
    List<Cordao> findAll();

    // Busca um instrumento pelo ID
    Cordao findById(Long id);
}