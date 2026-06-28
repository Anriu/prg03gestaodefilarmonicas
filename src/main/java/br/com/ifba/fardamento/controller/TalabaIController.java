package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Talaba;
import java.util.List;

/**
 * Interface de contrato para o Controller de talaba.
 * * @author anriu
 */

public interface TalabaIController {

    // Salva um novo instrumento
    Talaba save(Talaba talaba);

    // Atualiza os dados de um instrumento
    Talaba update(Talaba talaba);

    // Remove um instrumento
    void delete(Talaba talaba);

    // Retorna todos os instrumentos cadastrados
    List<Talaba> findAll();

    // Busca um instrumento pelo ID
    Talaba findById(Long id);
}