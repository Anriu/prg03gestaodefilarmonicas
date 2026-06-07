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

   
    private TableRowSorter<DefaultTableModel> sorter;

    @Autowired
    private InstrumentoIController instrumentoController;

    @Autowired
    private ApplicationContext context;
    

    
    /**
     * Creates new form CadastroInsturmento
     */
    public TelaInstrumento() {
        initComponents();
        
        
        this.setSize(1280, 720);
        this.setMinimumSize(new java.awt.Dimension(1024, 768));
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        
        
        tblInstrumentos.setRowHeight(35);
        DefaultTableModel model = (DefaultTableModel) tblInstrumentos.getModel();
        sorter = new TableRowSorter<>(model);
        tblInstrumentos.setRowSorter(sorter);
        
        
        txtPesquisar.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                aplicarFiltrosAvancados();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                aplicarFiltrosAvancados();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                aplicarFiltrosAvancados();
            }
        });
        
        
        
    }
    
    @PostConstruct
    public void iniciarBotoesTabela() {
        for (int i = 3; i <= 5; i++) {
            tblInstrumentos.getColumnModel().getColumn(i).setCellRenderer(new ButtonRenderer());
            tblInstrumentos.getColumnModel().getColumn(i).setCellEditor(new ButtonEditor(new JCheckBox(), instrumentoController));
            tblInstrumentos.getColumnModel().getColumn(i).setMaxWidth(110);
            tblInstrumentos.getColumnModel().getColumn(i).setMinWidth(110);
        }
    }
    
    @jakarta.annotation.PostConstruct
    public void iniciarTela() {
        listarInstrumentos();
    }
    
    public void listarInstrumentos() {

        DefaultTableModel model = (DefaultTableModel) tblInstrumentos.getModel();


        if (model.getColumnCount() == 6) {
            model.addColumn("ID_OCULTO");

            tblInstrumentos.getColumnModel().getColumn(6).setMinWidth(0);
            tblInstrumentos.getColumnModel().getColumn(6).setMaxWidth(0);
            tblInstrumentos.getColumnModel().getColumn(6).setWidth(0);
        }


        model.setRowCount(0);


        List<Instrumento> listaInstrumentos = instrumentoController.findAll();


        for (Instrumento instrumento : listaInstrumentos) {
            String tipo = "";
            String afinacao = "-"; 


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
       
        String textoPesquisa = txtPesquisar.getText().trim();
        String tipoSelecionado = cbTipo.getSelectedItem().toString();
        String afinacaoSelecionada = cbAfinacao.getSelectedItem().toString();


        java.util.List<RowFilter<Object, Object>> filtros = new java.util.ArrayList<>();


        if (!textoPesquisa.isEmpty()) {
            filtros.add(RowFilter.regexFilter("(?i)" + textoPesquisa, 1));
        }


        if (!tipoSelecionado.equals("Nenhum")) {
            filtros.add(RowFilter.regexFilter("^" + tipoSelecionado + "$", 0));
        }


        if (!afinacaoSelecionada.equals("Nenhum")) {
            if (afinacaoSelecionada.equals("Sem Afinação")) {
                filtros.add(RowFilter.regexFilter("^-$", 2));
            } else {
                filtros.add(RowFilter.regexFilter("^" + afinacaoSelecionada + "$", 2));
            }
        }


        if (filtros.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.andFilter(filtros));
        }
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
        lblTitulo = new javax.swing.JLabel();
        bntCadastrarMadeira = new javax.swing.JButton();
        bntCadastrarMetal = new javax.swing.JButton();
        bntCadastrarPercussao = new javax.swing.JButton();
        lblCadastrar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInstrumentos = new javax.swing.JTable();
        txtPesquisar = new javax.swing.JTextField();
        lblPesquisa = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        cbAfinacao = new javax.swing.JComboBox<>();
        lblFiltro = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblAfinação = new javax.swing.JLabel();
        bntAtualizarLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(3, 28, 48));
        background.setForeground(new java.awt.Color(3, 28, 48));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Instrumentos");
        background.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));

        bntCadastrarMadeira.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCadastrarMadeira.setText("Instrumento de Madeira");
        bntCadastrarMadeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarMadeiraActionPerformed(evt);
            }
        });
        background.add(bntCadastrarMadeira, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 194, 199, -1));

        bntCadastrarMetal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCadastrarMetal.setText("Instrumento de Metal");
        bntCadastrarMetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarMetalActionPerformed(evt);
            }
        });
        background.add(bntCadastrarMetal, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 249, 199, -1));

        bntCadastrarPercussao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCadastrarPercussao.setText("Instrumento Percussivo");
        bntCadastrarPercussao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarPercussaoActionPerformed(evt);
            }
        });
        background.add(bntCadastrarPercussao, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 307, 199, -1));

        lblCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        lblCadastrar.setText("Cadastrar Instrumentos");
        background.add(lblCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 151, -1, -1));

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

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 151, 831, 500));

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        background.add(txtPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 111, 180, -1));

        lblPesquisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        lblPesquisa.setText("Pesquisa por Nome do instrumento:");
        background.add(lblPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 80, -1, -1));

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

        lblFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFiltro.setForeground(new java.awt.Color(255, 255, 255));
        lblFiltro.setText("Filtros:");
        background.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, -1, -1));

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText("Tipo:");
        background.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 85, -1, -1));

        lblAfinação.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAfinação.setForeground(new java.awt.Color(255, 255, 255));
        lblAfinação.setText("Afinação:");
        background.add(lblAfinação, new org.netbeans.lib.awtextra.AbsoluteConstraints(1058, 85, -1, -1));

        bntAtualizarLista.setText("Atualizar Lista");
        bntAtualizarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAtualizarListaActionPerformed(evt);
            }
        });
        background.add(bntAtualizarLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 680, -1, -1));

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

    private void bntCadastrarMadeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarMadeiraActionPerformed
        // TODO add your handling code here:
        
        CadastroInstrumentoMadeira cadastroMadeiras = new CadastroInstrumentoMadeira(instrumentoController);
    
        cadastroMadeiras.setVisible(true);

        listarInstrumentos();
        
    }//GEN-LAST:event_bntCadastrarMadeiraActionPerformed

    private void bntCadastrarMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarMetalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntCadastrarMetalActionPerformed

    private void bntCadastrarPercussaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarPercussaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntCadastrarPercussaoActionPerformed

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

    private void bntAtualizarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAtualizarListaActionPerformed
        // TODO add your handling code here:
        listarInstrumentos(); 
    }//GEN-LAST:event_bntAtualizarListaActionPerformed

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
    private javax.swing.JButton bntAtualizarLista;
    private javax.swing.JButton bntCadastrarMadeira;
    private javax.swing.JButton bntCadastrarMetal;
    private javax.swing.JButton bntCadastrarPercussao;
    private javax.swing.JComboBox<String> cbAfinacao;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAfinação;
    private javax.swing.JLabel lblCadastrar;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblInstrumentos;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
