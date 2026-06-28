package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Farda;
import java.util.List;

/**
 * Interface de contrato para o Controller de farda.
 * * @author anriu
 */
public interface FardaIController {

    // Salva um novo instrumento
    Farda save(Farda farda);

    // Atualiza os dados de um instrumento
    Farda update(Farda farda);

    // Remove um instrumento
    void delete(Farda farda);

    // Retorna todos os instrumentos cadastrados
    List<Farda> findAll();

    // Busca um instrumento pelo ID
    Farda findById(Long id);
}