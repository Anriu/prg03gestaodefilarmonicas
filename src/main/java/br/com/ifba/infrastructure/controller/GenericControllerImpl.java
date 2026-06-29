package br.com.ifba.infrastructure.controller;

import br.com.ifba.infrastructure.service.GenericService;
import java.util.List;

/**
 * Implementação genérica dos Controllers.
 *
 * @author anriu
 * @param <T> Tipo da entidade.
 */

public abstract class GenericControllerImpl<T> implements GenericController<T> {

    protected abstract GenericService<T> getService();

    @Override
    public T save(T entity) {
        return getService().save(entity);
    }

    @Override
    public T update(T entity) {
        return getService().update(entity);
    }

    @Override
    public void delete(T entity) {
        getService().delete(entity);
    }

    @Override
    public List<T> findAll() {
        return getService().findAll();
    }

    @Override
    public T findById(Long id) {
        return getService().findById(id);
    }
}