package br.com.ifba;

import br.com.ifba.view.MenuPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author anriu
 */

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // Log de inicialização do sistema
        log.info("Inicializando sistema Spring Boot + Swing");

        // Inicializa o Spring Boot permitindo interface gráfica Swing
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(Application.class)
                        .headless(false)
                        .run(args);

        // Log de contexto iniciado
        log.info("Contexto Spring inicializado com sucesso");

        // Recupera a tela principal gerenciada pelo Spring
        MenuPrincipal tela = context.getBean(MenuPrincipal.class);

        // Log de abertura da tela principal
        log.info("Abrindo tela principal do sistema");

        // Exibe a tela principal
        tela.setVisible(true);
        

        
    }
}