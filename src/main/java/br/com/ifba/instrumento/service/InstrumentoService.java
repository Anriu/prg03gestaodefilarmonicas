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

    // Injeção de dependência automática via Lombok
    private final InstrumentoRepository instrumentoRepository;

    @Override
    public Instrumento save(Instrumento instrumento) {
        // Log corrigido para bater com os atributos da sua classe abstrata
        log.info("Salvando novo instrumento - Marca: {} | Modelo: {}", 
                instrumento.getMarca(), 
                instrumento.getModelo());

        // Salva a subclasse concreta na tabela tb_instrumento do Supabase
        return instrumentoRepository.save(instrumento);
    }

    @Override
    public Instrumento update(Instrumento instrumento) {
        log.info("Atualizando instrumento ID {} - Marca: {} | Modelo: {}", 
                instrumento.getId(), 
                instrumento.getMarca(),
                instrumento.getModelo());

        return instrumentoRepository.save(instrumento);
    }

    @Override
    public void delete(Instrumento instrumento) {
        log.info("Removendo instrumento ID {} - N/S: {}", 
                instrumento.getId(), 
                instrumento.getNumSerie());

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