package br.com.ifba.instrumento.service;

import br.com.ifba.instrumento.entity.Instrumento;
import br.com.ifba.instrumento.repository.InstrumentoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Classe que implementa as regras de negócio e logs de Instrumento.
 * * @author anriu
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class InstrumentoService implements InstrumentoIService {

    // Injeção de dependência automática via Lombok do Repository genérico
    private final InstrumentoRepository instrumentoRepository;

    @Override
    public Instrumento save(Instrumento instrumento) {
        // Log atualizado utilizando o novo atributo nome
        log.info("Salvando novo instrumento: {}", instrumento.getNome());

        // Salva a subclasse concreta na tabela única do Supabase
        return instrumentoRepository.save(instrumento);
    }

    @Override
    public Instrumento update(Instrumento instrumento) {
        // Log atualizado com o ID e o nome do instrumento
        log.info("Atualizando instrumento ID {} - Nome: {}", 
                instrumento.getId(), 
                instrumento.getNome());

        return instrumentoRepository.save(instrumento);
    }

    @Override
    public void delete(Instrumento instrumento) {
        // Log atualizado para a remoção
        log.info("Removendo instrumento ID {} - Nome: {}", 
                instrumento.getId(), 
                instrumento.getNome());

        instrumentoRepository.delete(instrumento);
    }

    @Override
    public List<Instrumento> findAll() {
        log.info("Listando todos os instrumentos da filarmônica");
        return instrumentoRepository.findAll();
    }

    @Override
    public Instrumento findById(Long id) {
        log.info("Buscando instrumento pelo ID: {}", id);
        return instrumentoRepository.findById(id).orElse(null);
    }
}