package br.com.ifba.instrumento.component;

import br.com.ifba.instrumento.controller.InstrumentoIController;
import br.com.ifba.instrumento.entity.Instrumento;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Componente responsável por gerenciar os cliques nos botões da tabela de Instrumentos.
 * * @author anriu
 */
public class ButtonEditor extends DefaultCellEditor {

    private final InstrumentoIController instrumentoController;
    protected JButton button;
    private int col;
    private int row;
    private JTable table;
    private Object valor;

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
     * Executa a ação correspondente à coluna clicada na tabela de instrumentos.
     */
    private void executarAcao() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int linhaModel = table.convertRowIndexToModel(row);

        // Pega o ID da coluna oculta (índice 6)
        Long id = Long.valueOf(model.getValueAt(linhaModel, 6).toString());

        // Busca o instrumento polimórfico genérico pelo ID
        Instrumento instrumento = instrumentoController.findById(id);

        if (instrumento == null) {
            JOptionPane.showMessageDialog(button, "Erro: Instrumento não encontrado.");
            return;
        }

        // ==========================================
        // COLUNA 3: VER DETALHES
        // ==========================================
        if (col == 3) {
            // Espaço reservado para a tela de detalhes que você irá criar posteriormente
            JOptionPane.showMessageDialog(button, 
                    "Abrindo detalhes do instrumento: " + instrumento.getNome() + "\n" +
                    "Marca: " + instrumento.getMarca() + " | Modelo: " + instrumento.getModelo(),
                    "Ver Detalhes", 
                    JOptionPane.INFORMATION_MESSAGE);
            
            // Exemplo de como chamará no futuro:
            // DetalhesInstrumento telaDetalhes = new DetalhesInstrumento(instrumento);
            // telaDetalhes.setVisible(true);
        } 
        
        // ==========================================
        // COLUNA 4: EDITAR
        // ==========================================
        else if (col == 4) {
            // Abre a tela de edição passando o objeto preenchido vindo do Supabase
            // Nota: substitua 'DadosInstrumento' pelo nome exato da tela de formulário que você criar
            
            JOptionPane.showMessageDialog(button, "Abrindo edição para: " + instrumento.getNome());
            
            // Exemplo de chamada da sua tela de cadastro/edição:
            // DadosInstrumento telaEdicao = new DadosInstrumento(instrumento, instrumentoController);
            // telaEdicao.setVisible(true);
        } 
        
        // ==========================================
        // COLUNA 5: EXCLUIR
        // ==========================================
        else if (col == 5) {
            int resposta = JOptionPane.showConfirmDialog(
                    button,
                    "Deseja realmente excluir o instrumento " + instrumento.getNome() + "?",
                    "Confirmação de Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {
                // Remove o registro da tabela única no Supabase
                instrumentoController.delete(instrumento);

                // Remove a linha visível do grid Swing
                model.removeRow(linhaModel);
                
                JOptionPane.showMessageDialog(button, "Instrumento removido com sucesso!");
            }
        }
    }

    @Override
    public Object getCellEditorValue() {
        return valor;
    }
}