package br.com.ifba.pessoa.service;

import br.com.ifba.infrastructure.service.GenericServiceImpl;
import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.pessoa.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Classe que implementa as regras de negócio de Pessoa.
 * * @author anriu
 */

@Service
@RequiredArgsConstructor
public class PessoaService extends GenericServiceImpl<Pessoa> implements PessoaIService {

    private final PessoaRepository repository;

    @Override
   protected JpaRepository<Pessoa, Long> getRepository() {
        return repository;
    }
}
