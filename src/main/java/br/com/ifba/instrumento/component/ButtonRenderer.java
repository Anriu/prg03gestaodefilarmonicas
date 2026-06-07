package br.com.ifba.instrumento.component;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Componente responsável por renderizar botões dentro da tabela de Instrumentos.
 * * @author anriu
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        // Mantém a aparência limpa e transparente integrada com o tema escuro
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {

        // Limpa o texto padrão
        setText("");

        try {
            // Verifica o índice da coluna baseado na imagem image_c71ae4.png
            if (column == 3) {
                setText("Ver Detalhes");
            } else if (column == 4) {
                setText("Editar");
            } else if (column == 5) {
                setText("Excluir");
            }
        } catch (Exception e) {
            // Evita quebras de renderização visual
        }

        return this;
    }
}