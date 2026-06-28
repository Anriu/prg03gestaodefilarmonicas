package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.Blusa;
import java.util.List;

/**
 * Interface de contrato para o Controller de blusa.
 * * @author anriu
 */
public interface BlusaIController {

    // Salva um novo instrumento
    Blusa save(Blusa blusa);

    // Atualiza os dados de um instrumento
    Blusa update(Blusa blusa);

    // Remove um instrumento
    void delete(Blusa blusa);

    // Retorna todos os instrumentos cadastrados
    List<Blusa> findAll();

    // Busca um instrumento pelo ID
    Blusa findById(Long id);
}