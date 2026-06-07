package br.com.ifba.instrumento.view;

import br.com.ifba.instrumento.component.ButtonEditor;
import br.com.ifba.instrumento.component.ButtonRenderer;
import br.com.ifba.instrumento.controller.InstrumentoIController;
import br.com.ifba.instrumento.entity.Instrumento;
import br.com.ifba.instrumento.entity.InstrumentoMadeira;
import br.com.ifba.instrumento.entity.InstrumentoMetal;
import br.com.ifba.instrumento.entity.InstrumentoPercussao;
import br.com.ifba.instrumento.entity.InstrumentoSopro;
import jakarta.annotation.PostConstruct;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author anriu
 */

@Component
public class TelaInstrumento extends javax.swing.JFrame {

    // Responsável por permitir filtro e ordenação na tabela
    private TableRowSorter<DefaultTableModel> sorter;

    // Controller de Instrumento injetado automaticamente pelo Spring via @Autowired
    @Autowired
    private InstrumentoIController instrumentoController;

    // Contexto da aplicação Spring injetado automaticamente
    @Autowired
    private ApplicationContext context;
    

    
    /**
     * Creates new form CadastroInsturmento
     */
    public TelaInstrumento() {
        initComponents();
        
        // 1. Define o tamanho base padrão (caso o usuário desmaximize a tela)
        this.setSize(1280, 720);

        // 2. Define um tamanho mínimo para o usuário não conseguir esmagar os componentes com o mouse
        this.setMinimumSize(new java.awt.Dimension(1024, 768));

        // 3. Força a tela a abrir 100% MAXIMIZADA (ocupando os 1920x1080 do seu monitor ou qualquer outro)
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        // 4. Se o usuário usar um monitor ultra-wide, garante que a janela abra centralizada
        this.setLocationRelativeTo(null);
        
        
        tblInstrumentos.setRowHeight(35);
        DefaultTableModel model = (DefaultTableModel) tblInstrumentos.getModel();
        sorter = new TableRowSorter<>(model);
        tblInstrumentos.setRowSorter(sorter);
        
        
        
    }
    
    @PostConstruct
    public void iniciarBotoesTabela() {
        // Configura os botões nas colunas 3 (Ver Detalhes), 4 (Editar) e 5 (Excluir) da tblInstrumentos
        for (int i = 3; i <= 5; i++) {
            tblInstrumentos.getColumnModel().getColumn(i).setCellRenderer(new ButtonRenderer());
            tblInstrumentos.getColumnModel().getColumn(i).setCellEditor(new ButtonEditor(new JCheckBox(), instrumentoController));
            tblInstrumentos.getColumnModel().getColumn(i).setMaxWidth(110);
            tblInstrumentos.getColumnModel().getColumn(i).setMinWidth(110);
        }

        // Esconde totalmente a coluna do ID (índice 6) para manter o visual limpo da imagem
        // Como o NetBeans gerou a tabela com 6 colunas no model, o Java adiciona a 7ª na listagem automaticamente.
    }
    
    @jakarta.annotation.PostConstruct
    public void iniciarTela() {
        listarInstrumentos();
    }
    
    public void listarInstrumentos() {
        // Pega o modelo da tblInstrumentos
        DefaultTableModel model = (DefaultTableModel) tblInstrumentos.getModel();

        // Garante que o modelo da tabela aceite a 7ª coluna oculta para o ID se ela não existir no NetBeans
        if (model.getColumnCount() == 6) {
            model.addColumn("ID_OCULTO");
            // Esconde dinamicamente a coluna do ID recém-criada
            tblInstrumentos.getColumnModel().getColumn(6).setMinWidth(0);
            tblInstrumentos.getColumnModel().getColumn(6).setMaxWidth(0);
            tblInstrumentos.getColumnModel().getColumn(6).setWidth(0);
        }

        // Limpa todas as linhas da tabela
        model.setRowCount(0);

        // Busca todos os instrumentos cadastrados usando o controller injetado
        List<Instrumento> listaInstrumentos = instrumentoController.findAll();

        // Percorre a lista aplicando o Polimorfismo
        for (Instrumento instrumento : listaInstrumentos) {
            String tipo = "";
            String afinacao = "-"; 

            // Identifica a subclasse real do instrumento
            if (instrumento instanceof InstrumentoMadeira) {
                tipo = "Madeira";
                afinacao = ((InstrumentoSopro) instrumento).getAfinacao();
            } 
            else if (instrumento instanceof InstrumentoMetal) {
                tipo = "Metal";
                afinacao = ((InstrumentoSopro) instrumento).getAfinacao();
            } 
            else if (instrumento instanceof InstrumentoPercussao) {
                tipo = "Percussão";
            }

            // Adiciona a linha batendo com a ordem das colunas da sua imagem
            model.addRow(new Object[]{
                tipo,                       // Coluna 0 (Tipo)
                instrumento.getNome(),      // Coluna 1 (Nome)
                afinacao,                   // Coluna 2 (Afinação)
                "Ver Detalhes",             // Coluna 3 (Botão)
                "Editar",                   // Coluna 4 (Botão)
                "Excluir",                  // Coluna 5 (Botão)
                instrumento.getId()         // Coluna 6 (ID Oculto)
            });
        }
    }
    
    private void filtrar() {
        String texto = txtPesquisar.getText();

        if (texto.trim().isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            // Filtra os dados com base na coluna 1 (Coluna "Nome") ignorando maiúsculas/minúsculas
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 1));
        }
    }


    
    private void aplicarFiltrosAvancados() {
        // 1. Pega os valores atuais de todos os filtros da tela
        String textoPesquisa = txtPesquisar.getText().trim();
        String tipoSelecionado = cbTipo.getSelectedItem().toString();
        String afinacaoSelecionada = cbAfinacao.getSelectedItem().toString();

        // 2. Cria a lista para combinar os filtros
        java.util.List<RowFilter<Object, Object>> filtros = new java.util.ArrayList<>();

        // 3. Filtro 1: Campo de texto (Busca por Nome na Coluna 1)
        if (!textoPesquisa.isEmpty()) {
            filtros.add(RowFilter.regexFilter("(?i)" + textoPesquisa, 1));
        }

        // 4. Filtro 2: ComboBox de TIPO (Coluna 0)
        if (!tipoSelecionado.equals("Nenhum")) {
            filtros.add(RowFilter.regexFilter("^" + tipoSelecionado + "$", 0));
        }

        // 5. Filtro 3: ComboBox de AFINAÇÃO (Coluna 2)
        if (!afinacaoSelecionada.equals("Nenhum")) {
            if (afinacaoSelecionada.equals("Sem Afinação")) {
                filtros.add(RowFilter.regexFilter("^-$", 2));
            } else {
                filtros.add(RowFilter.regexFilter("^" + afinacaoSelecionada + "$", 2));
            }
        }

        // TRUQUE ANTIDUPLICAÇÃO: Desativa a atualização visual da tabela temporariamente
        tblInstrumentos.setRowSorter(null);

        // 6. Aplica a combinação final usando o AND se houver filtros ativos
        if (filtros.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.andFilter(filtros));
        }

        // Devolve o ordenador atualizado para a tabela renderizar tudo de uma vez só de forma limpa
        tblInstrumentos.setRowSorter(sorter);
    }
    
    
    
    
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInstrumentos = new javax.swing.JTable();
        txtPesquisar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        cbAfinacao = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(3, 28, 48));
        background.setForeground(new java.awt.Color(3, 28, 48));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Instrumentos");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 70, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Instrumento de Madeira");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        background.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 194, 199, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Instrumento de Metal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        background.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 249, 199, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Instrumento Percussivo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        background.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 307, 199, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cadastrar Instrumentos");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 151, -1, -1));

        tblInstrumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Nome", "Afinação", "Ver Detalhes", "Editar", "Excluir"
            }
        ));
        jScrollPane1.setViewportView(tblInstrumentos);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 151, 831, 544));

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        background.add(txtPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 111, 180, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pesquisa por Nome do instrumento:");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 80, -1, -1));

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Madeira", "Metal", "Percussão" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });
        background.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 111, -1, -1));

        cbAfinacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Dó", "Si Bemol", "Mi Bemol", "Fá", "Sem Afinação" }));
        cbAfinacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAfinacaoActionPerformed(evt);
            }
        });
        background.add(cbAfinacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1058, 111, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Filtros:");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 53, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo:");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 85, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Afinação:");
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1058, 85, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
        
        aplicarFiltrosAvancados();
        
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
        
        aplicarFiltrosAvancados();
        
    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbAfinacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAfinacaoActionPerformed
        // TODO add your handling code here:
        
        aplicarFiltrosAvancados();
        
    }//GEN-LAST:event_cbAfinacaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInstrumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInstrumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInstrumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInstrumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInstrumento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JComboBox<String> cbAfinacao;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInstrumentos;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
