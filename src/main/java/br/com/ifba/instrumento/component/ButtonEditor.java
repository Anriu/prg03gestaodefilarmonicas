package br.com.ifba.instrumento.component;

import br.com.ifba.infrastructure.view.ViewManager;
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
    private final ViewManager viewManager;
    private final JButton button;

    
    private int col;
    private int row;
    private JTable table;
    private Object valor;


    public ButtonEditor(
            JCheckBox checkBox,
            InstrumentoIController instrumentoController,
            ViewManager viewManager
  
    ) {

        super(checkBox);

        this.instrumentoController = instrumentoController;
        this.viewManager = viewManager;

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


    @Override
    public Component getTableCellEditorComponent(
            JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column
    ) {

        this.table = table;
        this.row = row;
        this.col = column;
        this.valor = value;

        return button;
    }


    private void executarAcao() {

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        int linhaModel = table.convertRowIndexToModel(row);

        Long id = Long.valueOf(
                model.getValueAt(linhaModel, 6).toString()
        );


        Instrumento instrumento =
                instrumentoController.findById(id);


        if (instrumento == null) {

            JOptionPane.showMessageDialog(
                    button,
                    "Erro: Instrumento não encontrado."
            );

            return;
        }


        // =========================
        // DETALHES
        // =========================

        if (col == COL_DETALHES) {


            if ("Madeira".equals(instrumento.getTipo())) {


                viewManager.abrirTela(
                        new ExibirDetalhesMadeira(
                                (InstrumentoMadeira) instrumento
                        )
                );


            } else if ("Metal".equals(instrumento.getTipo())) {


                viewManager.abrirTela(
                        new ExibirDetalhesMetal(
                                (InstrumentoMetal) instrumento
                        )
                );


            } else if ("Percussão".equals(instrumento.getTipo())) {


                viewManager.abrirTela(
                        new ExibirDetalhesPercussao(
                                (InstrumentoPercussao) instrumento
                        )
                );

            }

        }


        // =========================
        // EDITAR
        // =========================

        else if (col == COL_EDITAR) {


            if ("Madeira".equals(instrumento.getTipo())) {


                viewManager.abrirTela(
                        new CadastroInstrumentoMadeira((InstrumentoMadeira) instrumento, instrumentoController, viewManager)
                );


            } else if ("Metal".equals(instrumento.getTipo())) {


                viewManager.abrirTela(
                        new CadastroInstrumentoMetal( (InstrumentoMetal) instrumento, instrumentoController, viewManager)
                );


            } else if ("Percussão".equals(instrumento.getTipo())) {


                viewManager.abrirTela(
                        new CadastroInstrumentoPercussao((InstrumentoPercussao) instrumento, instrumentoController, viewManager)
                );

            }

        }


        // =========================
        // EXCLUIR
        // =========================

        else if (col == COL_EXCLUIR) {


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


    @Override
    public Object getCellEditorValue() {
        return valor;
    }
}