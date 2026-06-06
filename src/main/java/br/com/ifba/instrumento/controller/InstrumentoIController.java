package br.com.ifba.instrumento.controller;

import br.com.ifba.instrumento.entity.Instrumento;
import java.util.List;

/**
 * Interface de contrato para o Controller de Instrumento.
 * * @author anriu
 */
public interface InstrumentoIController {

    // Salva um novo instrumento
    Instrumento save(Instrumento instrumento);

    // Atualiza os dados de um instrumento
    Instrumento update(Instrumento instrumento);

    // Remove um instrumento
    void delete(Instrumento instrumento);

    // Retorna todos os instrumentos cadastrados
    List<Instrumento> findAll();

    // Busca um instrumento pelo ID
    Instrumento findById(Long id);
}