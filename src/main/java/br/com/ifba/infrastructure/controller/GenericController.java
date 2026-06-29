package br.com.ifba.infrastructure.controller;

import br.com.ifba.infrastructure.service.GenericService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementação genérica dos Controllers.
 *
 * @author anriu
 * @param <T> Tipo da entidade.
 */
@Slf4j
public abstract class GenericController<T> implements GenericIController<T> {

    protected abstract GenericService<T> getService();

    private String getEntityName() {
        return getService().getClass()
                .getSimpleName()
                .replace("Service", "")
                .replace("IService", "");
    }

    @Override
    public T save(T entity) {

        log.info("Controller recebeu solicitação para salvar {}", getEntityName());

        return getService().save(entity);
    }

    @Override
    public T update(T entity) {

        log.info("Controller recebeu solicitação para atualizar {}", getEntityName());

        return getService().update(entity);
    }

    @Override
    public void delete(T entity) {

        log.info("Controller recebeu solicitação para remover {}", getEntityName());

        getService().delete(entity);
    }

    @Override
    public List<T> findAll() {

        log.info("Controller recebeu solicitação para listar {}", getEntityName());

        return getService().findAll();
    }

    @Override
    public T findById(Long id) {

        log.info("Controller recebeu solicitação para buscar {} ID {}", getEntityName(), id);

        return getService().findById(id);
    }

}