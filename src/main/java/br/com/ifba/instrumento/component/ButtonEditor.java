package br.com.ifba.instrumento.component;

import br.com.ifba.instrumento.controller.InstrumentoIController;
import br.com.ifba.instrumento.entity.Instrumento;
import br.com.ifba.instrumento.entity.InstrumentoMadeira;
import br.com.ifba.instrumento.entity.InstrumentoMetal;
import br.com.ifba.instrumento.entity.InstrumentoPercussao;
import br.com.ifba.instrumento.view.CadastroInstrumentoMadeira;
import br.com.ifba.instrumento.view.CadastroInstrumentoMetal;
import br.com.ifba.instrumento.view.CadastroInstrumentoPercussivo;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Componente responsável por gerenciar os eventos de clique
 * dos botões presentes na tabela de instrumentos.
 *
 * @author anriu
 */
public class ButtonEditor extends DefaultCellEditor {

    private final InstrumentoIController instrumentoController;
    protected JButton button;
    private int col;
    private int row;
    private JTable table;
    private Object valor;
    
    private int excluir = 5;
    private int editar = 4;
    private int verDetalhes = 3;
    
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

        // Recupera o identificador do instrumento selecionado.
        Long id = Long.valueOf(model.getValueAt(linhaModel, 6).toString());

        // Obtém o instrumento correspondente por meio da camada de controle.
        Instrumento instrumento = instrumentoController.findById(id);

        if (instrumento == null) {
            JOptionPane.showMessageDialog(button, "Erro: Instrumento não encontrado.");
            return;
        }

        // Exibe as informações do instrumento selecionado.
        if (col == 3) {

            JOptionPane.showMessageDialog(button,
                    "Abrindo detalhes do instrumento: " + instrumento.getNome() + "\n" +
                    "Marca: " + instrumento.getMarca() + " | Modelo: " + instrumento.getModelo(),
                    "Ver Detalhes",
                    JOptionPane.INFORMATION_MESSAGE);

        }

        // Abre o formulário correspondente para edição do instrumento.
        else if (col == 4) {

            instrumento = instrumentoController.findById(id);

            if (instrumento.getTipo().equals("Madeira")) {
                new CadastroInstrumentoMadeira((InstrumentoMadeira) instrumento, instrumentoController).setVisible(true);
            }
            else if (instrumento.getTipo().equals("Metal")) {
                new CadastroInstrumentoMetal((InstrumentoMetal) instrumento, instrumentoController).setVisible(true);
            }
            else if (instrumento.getTipo().equals("Percussão")) {
                new CadastroInstrumentoPercussivo((InstrumentoPercussao) instrumento, instrumentoController).setVisible(true);
            }
        }

        // Remove o instrumento após confirmação do usuário.
        else if (col == 5) {

            int resposta = JOptionPane.showConfirmDialog(
                    button,
                    "Deseja realmente excluir o instrumento " + instrumento.getNome() + "?",
                    "Confirmação de Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {

                // Remove o registro da base de dados.
                instrumentoController.delete(instrumento);

                // Atualiza a tabela removendo a linha correspondente.
                model.removeRow(linhaModel);

                JOptionPane.showMessageDialog(button, "Instrumento removido com sucesso!");
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