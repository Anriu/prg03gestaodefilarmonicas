package br.com.ifba.instrumento.component;

import br.com.ifba.instrumento.controller.InstrumentoIController;
import br.com.ifba.instrumento.entity.Instrumento;
import br.com.ifba.instrumento.entity.InstrumentoMadeira;
import br.com.ifba.instrumento.entity.InstrumentoMetal;
import br.com.ifba.instrumento.entity.InstrumentoPercussao;
import br.com.ifba.instrumento.view.CadastroInstrumentoMadeira;
import br.com.ifba.instrumento.view.CadastroInstrumentoMetal;
import br.com.ifba.instrumento.view.CadastroInstrumentoPercussao;
import br.com.ifba.instrumento.view.ExibirDetalhesMadeira;
import br.com.ifba.instrumento.view.ExibirDetalhesMetal;
import br.com.ifba.instrumento.view.ExibirDetalhesPercussao;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.table.DefaultTableModel;

/**
 * Componente responsável por gerenciar os eventos de clique
 * dos botões presentes na tabela de instrumentos.
 *
 * @author anriu
 */
public class ButtonEditor extends DefaultCellEditor {

    private static final int COL_DETALHES = 3;
    private static final int COL_EDITAR = 4;
    private static final int COL_EXCLUIR = 5;

    private final InstrumentoIController instrumentoController;
    private final JButton button;

    private int col;
    private int row;
    private JTable table;
    private Object valor;

    /**
     * Inicializa o editor responsável pelo tratamento das ações
     * executadas a partir dos botões da tabela.
     *
     * @param checkBox componente exigido pela classe DefaultCellEditor.
     * @param instrumentoController controlador responsável pelas
     * operações relacionadas aos instrumentos.
     */
    public ButtonEditor(JCheckBox checkBox, InstrumentoIController instrumentoController) {
        super(checkBox);
        this.instrumentoController = instrumentoController;

        button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);

        button.addActionListener(e -> {
            executarAcao();
            fireEditingStopped();
        });
    }

    /**
     * Captura as informações da célula selecionada para posterior
     * execução da ação correspondente ao botão acionado.
     */
    @Override
    public Component getTableCellEditorComponent(
            JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {

        this.table = table;
        this.row = row;
        this.col = column;
        this.valor = value;

        return button;
    }

    /**
     * Executa a ação correspondente à coluna selecionada na tabela.
     */
    private void executarAcao() {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int linhaModel = table.convertRowIndexToModel(row);

        Long id = Long.valueOf(model.getValueAt(linhaModel, 6).toString());

        Instrumento instrumento = instrumentoController.findById(id);

        if (instrumento == null) {
            JOptionPane.showMessageDialog(
                    button,
                    "Erro: Instrumento não encontrado."
            );
            return;
        }

        if (col == COL_DETALHES) {

            if ("Madeira".equals(instrumento.getTipo())) {
                new ExibirDetalhesMadeira(
                        (InstrumentoMadeira) instrumento
                ).setVisible(true);
            }
            
            if ("Metal".equals(instrumento.getTipo())) {
                new ExibirDetalhesMetal(
                        (InstrumentoMetal) instrumento
                ).setVisible(true);
            }
            
            if ("Percussão".equals(instrumento.getTipo())) {
                new ExibirDetalhesPercussao(
                        (InstrumentoPercussao) instrumento
                ).setVisible(true);
            }

        } else if (col == COL_EDITAR) {

            if ("Madeira".equals(instrumento.getTipo())) {

                new CadastroInstrumentoMadeira(
                        (InstrumentoMadeira) instrumento,
                        instrumentoController
                ).setVisible(true);

            } else if ("Metal".equals(instrumento.getTipo())) {

                new CadastroInstrumentoMetal(
                        (InstrumentoMetal) instrumento,
                        instrumentoController
                ).setVisible(true);

            } else if ("Percussão".equals(instrumento.getTipo())) {
                System.out.println("Ola");
                new CadastroInstrumentoPercussao(
                        (InstrumentoPercussao) instrumento,
                        instrumentoController
                ).setVisible(true);
            }

        } else if (col == COL_EXCLUIR) {

            int resposta = JOptionPane.showConfirmDialog(
                    button,
                    "Deseja realmente excluir o instrumento "
                    + instrumento.getNome() + "?",
                    "Confirmação de Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {

                instrumentoController.delete(instrumento);

                model.removeRow(linhaModel);

                JOptionPane.showMessageDialog(
                        button,
                        "Instrumento removido com sucesso!"
                );
            }
        }
    }

    /**
     * Retorna o valor associado à célula em edição.
     *
     * @return valor da célula.
     */
    @Override
    public Object getCellEditorValue() {
        return valor;
    }
}