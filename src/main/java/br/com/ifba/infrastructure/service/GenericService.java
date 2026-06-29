package br.com.ifba.infrastructure.service;

import java.util.List;

/**
 * Interface genérica responsável por definir as operações básicas de CRUD.
 *
 * @author anriu
 * @param <T> Tipo da entidade.
 */
public interface GenericService<T> {

    // Salva uma nova entidade
    T save(T entity);

    // Atualiza uma entidade existente
    T update(T entity);

    // Remove uma entidade
    void delete(T entity);

    // Lista todas as entidades
    List<T> findAll();

    // Busca uma entidade pelo ID
    T findById(Long id);

}