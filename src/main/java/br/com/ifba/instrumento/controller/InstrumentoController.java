package br.com.ifba.instrumento.controller;

import br.com.ifba.instrumento.entity.Instrumento;
import br.com.ifba.instrumento.service.InstrumentoIService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

/**
 * Controller responsável por intermediar as requisições das telas Swing 
 * com as regras de negócio do Service de Instrumento.
 * * @author anriu
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class InstrumentoController implements InstrumentoIController {

    // Service responsável pelas regras de negócio e persistência
    private final InstrumentoIService instrumentoService;

    @Override
    public Instrumento save(Instrumento instrumento) {
        // Log de solicitação de cadastro
        log.info("Controller recebeu solicitação para salvar instrumento");

        // Encaminha para a camada de serviço
        return instrumentoService.save(instrumento);
    }

    @Override
    public Instrumento update(Instrumento instrumento) {
        // Log de solicitação de atualização
        log.info("Controller recebeu solicitação para atualizar instrumento ID {}", 
                instrumento.getId());

        // Encaminha a atualização
        return instrumentoService.update(instrumento);
    }

    @Override
    public void delete(Instrumento instrumento) {
        // Log de solicitação de remoção
        log.info("Controller recebeu solicitação para remover instrumento ID {}", 
                instrumento.getId());

        // Encaminha a remoção
        instrumentoService.delete(instrumento);
    }

    @Override
    public List<Instrumento> findAll() {
        // Log de solicitação de listagem
        log.info("Controller recebeu solicitação para listar todos os instrumentos");

        // Retorna a listagem vinda do banco
        return instrumentoService.findAll();
    }

    @Override
    public Instrumento findById(Long id) {
        // Log de solicitação de busca
        log.info("Controller recebeu solicitação para buscar instrumento ID {}", id);

        // Retorna o instrumento encontrado ou null
        return instrumentoService.findById(id);
    }
}