package br.com.ifba.infrastructure.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implementação genérica das operações básicas de CRUD.
 *
 * @author anriu
 * @param <T> Tipo da entidade.
 */
public abstract class GenericServiceImpl<T> implements GenericService<T> {

    /**
     * Retorna o repositório responsável pela entidade.
     *
     * @return JpaRepository da entidade.
     */
    protected abstract JpaRepository<T, Long> getRepository();

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T update(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findById(Long id) {
        return getRepository().findById(id).orElse(null);
    }

}