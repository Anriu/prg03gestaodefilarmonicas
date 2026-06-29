package br.com.ifba.infrastructure.controller;

import java.util.List;

/**
 * Interface genérica responsável pelas operações básicas de CRUD.
 *
 * @author anriu
 * @param <T> Tipo da entidade.
 */

public interface GenericIController<T> {

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    List<T> findAll();

    T findById(Long id);

}