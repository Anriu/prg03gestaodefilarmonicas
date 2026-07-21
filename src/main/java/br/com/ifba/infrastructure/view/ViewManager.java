package br.com.ifba.infrastructure.view;

import br.com.ifba.instrumento.view.TelaInstrumento;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ViewManager {

    private final ApplicationContext context;

    public ViewManager(ApplicationContext context) {
        this.context = context;
    }

    public <T> T abrirTela(Class<T> telaClass) {

        T tela = context.getBean(telaClass);

        if (tela instanceof javax.swing.JFrame frame) {
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        return tela;
    }


    public void abrirTela(javax.swing.JFrame tela) {

        tela.setLocationRelativeTo(null);
        tela.setVisible(true);

    }


    public void atualizarTelaInstrumento() {

        TelaInstrumento tela =
                context.getBean(TelaInstrumento.class);

        tela.listarInstrumentos();

    }
}