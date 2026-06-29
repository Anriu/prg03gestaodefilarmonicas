package br.com.ifba.instrumento.service;

import br.com.ifba.infrastructure.service.GenericServiceImpl;
import br.com.ifba.instrumento.entity.Instrumento;
import br.com.ifba.instrumento.repository.InstrumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Classe que implementa as regras de negócio e logs de Instrumento.
 * * @author anriu
 */

@Service
@RequiredArgsConstructor
public class InstrumentoService extends GenericServiceImpl<Instrumento> implements InstrumentoIService {

    private final InstrumentoRepository repository;

    @Override
   protected JpaRepository<Instrumento, Long> getRepository() {
        return repository;
    }
}