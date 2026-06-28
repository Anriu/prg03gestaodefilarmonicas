package br.com.ifba.fardamento.controller;

import br.com.ifba.fardamento.entity.EntregaFarda;
import java.util.List;

/**
 * Interface de contrato para o Controller de entrega de farda.
 * * @author anriu
 */

public interface EntregaFardaIController {

    // Salva um novo instrumento
    EntregaFarda save(EntregaFarda entregaFarda);

    // Atualiza os dados de um instrumento
    EntregaFarda update(EntregaFarda entregaFarda);

    // Remove um instrumento
    void delete(EntregaFarda entregaFarda);

    // Retorna todos os instrumentos cadastrados
    List<EntregaFarda> findAll();

    // Busca um instrumento pelo ID
    EntregaFarda findById(Long id);
}