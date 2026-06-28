package br.com.ifba.pessoa.service;

import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.pessoa.repository.PessoaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Service
@RequiredArgsConstructor
public class PessoaService implements PessoaIService{
    
    // Injeção de dependência automática via Lombok do Repository genérico
    private final PessoaRepository pessoaRepository;
 
    @Override
    public Pessoa save(Pessoa pessoa) {

        // Salva a subclasse concreta na tabela única do Supabase
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa update(Pessoa pessoa) {


        return pessoaRepository.save(pessoa);
    }

    @Override
    public void delete(Pessoa instrumento) {


        pessoaRepository.delete(instrumento);
    }

    @Override
    public List<Pessoa> findAll() {
        
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa findById(Long id) {

        return pessoaRepository.findById(id).orElse(null);
    }
    
}
