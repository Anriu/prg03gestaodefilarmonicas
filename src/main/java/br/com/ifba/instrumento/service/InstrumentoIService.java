package br.com.ifba.instrumento.service;

import br.com.ifba.instrumento.entity.Instrumento;
import java.util.List;

/**
 * Interface de contrato para as regras de negócio de Instrumento.
 * * @author anriu
 */
public interface InstrumentoIService {

    // Salva um novo instrumento (recebe qualquer subclasse concreta)
    Instrumento save(Instrumento instrumento);

    // Atualiza os dados de um instrumento
    Instrumento update(Instrumento instrumento);

    // Remove um instrumento do sistema
    void delete(Instrumento instrumento);

    // Retorna todos os instrumentos (de todas as subclasses) cadastrados
    List<Instrumento> findAll();

    // Busca um instrumento específico pelo ID
    Instrumento findById(Long id);
}