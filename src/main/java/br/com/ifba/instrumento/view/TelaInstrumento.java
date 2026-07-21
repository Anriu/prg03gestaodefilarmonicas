package br.com.ifba.instrumento.view;

import br.com.ifba.infrastructure.view.ViewManager;
import br.com.ifba.instrumento.component.ButtonEditor;
import br.com.ifba.instrumento.component.ButtonRenderer;
import br.com.ifba.instrumento.controller.InstrumentoIController;
import br.com.ifba.instrumento.entity.Instrumento;
import br.com.ifba.instrumento.entity.InstrumentoMadeira;
import br.com.ifba.instrumento.entity.InstrumentoMetal;
import br.com.ifba.instrumento.entity.InstrumentoSopro;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anriu
 */

@Component
@Scope("prototype")
public class TelaInstrumento extends javax.swing.JFrame {
    
    private final ViewManager viewManager;
    private final InstrumentoIController instrumentoController;

    private TableRowSorter<DefaultTableModel> sorter;

    /**
     * Creates new form CadastroInsturmento
     * @param instrumentoController
     * @param viewManager
     */
    public TelaInstrumento(InstrumentoIController instrumentoController, ViewManager viewManager) {
        
        this.viewManager = viewManager;
        this.instrumentoController = instrumentoController;
        
        initComponents();
        
        
        setDefaultCloseOperation(
              javax.swing.WindowConstants.DISPOSE_ON_CLOSE
        );
        
        /*this.setSize(1280, 720);
        this.setMinimumSize(new java.awt.Dimension(1024, 768));
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);*/
        
        
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
  
    @jakarta.annotation.PostConstruct
    public void iniciarTela() {
        configurarEstruturaColunas();
        listarInstrumentos();
    }
    
    private void configurarEstruturaColunas() {
        DefaultTableModel model = (DefaultTableModel) tblInstrumentos.getModel();

        // 1. Garante que a coluna secreta do ID é adicionada APENAS UMA VEZ na inicialização do sistema
        if (model.getColumnCount() == 6) {
            model.addColumn("ID_OCULTO");
        }

        // 2. Aplica as regras visuais de tamanho e esconde a coluna 6
        tblInstrumentos.getColumnModel().getColumn(6).setMinWidth(0);
        tblInstrumentos.getColumnModel().getColumn(6).setMaxWidth(0);
        tblInstrumentos.getColumnModel().getColumn(6).setWidth(0);

        // 3. Vincula os botões de ação e define as larguras fixas de forma definitiva
        for (int i = 3; i <= 5; i++) {
            tblInstrumentos.getColumnModel().getColumn(i).setCellRenderer(new ButtonRenderer());
            tblInstrumentos.getColumnModel().getColumn(i).setCellEditor(new ButtonEditor(new JCheckBox(), instrumentoController,viewManager));
            tblInstrumentos.getColumnModel().getColumn(i).setMaxWidth(110);
            tblInstrumentos.getColumnModel().getColumn(i).setMinWidth(110);
        }
    }
    
    public void listarInstrumentos() {
        DefaultTableModel model = (DefaultTableModel) tblInstrumentos.getModel();

        // Limpa as linhas sem interferir nas colunas configuradas
        model.setRowCount(0);

        List<Instrumento> listaInstrumentos = instrumentoController.findAll();

        for (Instrumento instrumento : listaInstrumentos) {

            String tipo;
            String tonalidade = "-";

            if (instrumento instanceof InstrumentoMadeira) {
                tipo = "Madeira";
            } else if (instrumento instanceof InstrumentoMetal) {
                tipo = "Metal";
            } else {
                tipo = "Percussão";
            }

            if (instrumento instanceof InstrumentoSopro sopro
                    && sopro.getTonalidade() != null) {
                tonalidade = sopro.getTonalidade().getDescricao();
            }

            model.addRow(new Object[]{
                tipo,                       // Coluna 0
                instrumento.getNome(),      // Coluna 1
                tonalidade,                 // Coluna 2
                "Ver Detalhes",             // Coluna 3
                "Editar",                   // Coluna 4
                "Excluir",                  // Coluna 5
                instrumento.getId()         // Coluna 6
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
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));

        background.setBackground(new java.awt.Color(3, 28, 48));
        background.setForeground(new java.awt.Color(3, 28, 48));
        background.setMaximumSize(new java.awt.Dimension(1280, 720));
        background.setMinimumSize(new java.awt.Dimension(1280, 720));
        background.setPreferredSize(new java.awt.Dimension(1280, 720));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Instrumentos");

        bntCadastrarMadeira.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCadastrarMadeira.setText("Instrumento de Madeira");
        bntCadastrarMadeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarMadeiraActionPerformed(evt);
            }
        });

        bntCadastrarMetal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCadastrarMetal.setText("Instrumento de Metal");
        bntCadastrarMetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarMetalActionPerformed(evt);
            }
        });

        bntCadastrarPercussao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCadastrarPercussao.setText("Instrumento Percussivo");
        bntCadastrarPercussao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarPercussaoActionPerformed(evt);
            }
        });

        lblCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        lblCadastrar.setText("Cadastrar Instrumentos");

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

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });

        lblPesquisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        lblPesquisa.setText("Pesquisa por Nome do instrumento:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Madeira", "Metal", "Percussão" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        cbAfinacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Dó", "Si Bemol", "Mi Bemol", "Fá", "Sem Afinação" }));
        cbAfinacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAfinacaoActionPerformed(evt);
            }
        });

        lblFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFiltro.setForeground(new java.awt.Color(255, 255, 255));
        lblFiltro.setText("Filtros:");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText("Tipo:");

        lblAfinação.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAfinação.setForeground(new java.awt.Color(255, 255, 255));
        lblAfinação.setText("Afinação:");

        bntAtualizarLista.setText("Atualizar Lista");
        bntAtualizarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAtualizarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(630, 630, 630)
                .addComponent(lblTitulo))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(431, 431, 431)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cbAfinacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCadastrar)
                    .addComponent(bntCadastrarMadeira, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntCadastrarMetal, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntCadastrarPercussao, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(bntAtualizarLista))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(lblPesquisa)
                .addGap(370, 370, 370)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFiltro)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(lblTipo)
                        .addGap(79, 79, 79)
                        .addComponent(lblAfinação))))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblPesquisa))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTipo))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblAfinação)))
                .addGap(6, 6, 6)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAfinacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(lblCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(bntCadastrarMadeira)
                        .addGap(28, 28, 28)
                        .addComponent(bntCadastrarMetal)
                        .addGap(31, 31, 31)
                        .addComponent(bntCadastrarPercussao))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(bntAtualizarLista)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntCadastrarMadeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarMadeiraActionPerformed
        // TODO add your handling code here:
        
         viewManager.abrirTela(CadastroInstrumentoMadeira.class);

    }//GEN-LAST:event_bntCadastrarMadeiraActionPerformed

    private void bntCadastrarMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarMetalActionPerformed
        // TODO add your handling code here:

        viewManager.abrirTela(CadastroInstrumentoMetal.class);

    }//GEN-LAST:event_bntCadastrarMetalActionPerformed

    private void bntCadastrarPercussaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarPercussaoActionPerformed
        // TODO add your handling code here:
        
        viewManager.abrirTela(CadastroInstrumentoPercussao.class);
        
        
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
