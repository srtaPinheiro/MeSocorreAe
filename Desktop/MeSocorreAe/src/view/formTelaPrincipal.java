package view;

import java.util.ArrayList;
import modelDominio.Servico;
import view.tablemodel.ProximosPedidosTableModel;
import static view.MeSocorreAeCliente.conexaoController;

public class formTelaPrincipal extends javax.swing.JFrame {
    ProximosPedidosTableModel pedidosModel;
    ArrayList<Servico> listaProximosPeds;

    public formTelaPrincipal() {
        initComponents();
        
        atualizaTabela();
    }
    
    private void atualizaTabela() {
        listaProximosPeds = new ArrayList<>();
        listaProximosPeds = conexaoController.getListaProximosServicos(conexaoController.getUsuarioLogado().getCpf());
        pedidosModel = new ProximosPedidosTableModel(listaProximosPeds);
        jTPedidos.setModel(pedidosModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPedidos = new javax.swing.JTable();
        jLProximos = new javax.swing.JLabel();
        jPMenuLateral = new javax.swing.JPanel();
        jBAgenda = new javax.swing.JButton();
        jBEditarPerfil = new javax.swing.JButton();
        jBSobreSoft = new javax.swing.JButton();
        jLSubtitulo = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        jLLogo = new javax.swing.JLabel();
        jBAterarSenha = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jLProximos1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MeSocorreAê - Painel de controle");
        setMinimumSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTPedidos.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTPedidos);

        jLProximos.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLProximos.setText("Próximos socorros a realizar");

        jPMenuLateral.setBackground(new java.awt.Color(255, 255, 255));

        jBAgenda.setBackground(new java.awt.Color(0, 160, 186));
        jBAgenda.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBAgenda.setForeground(new java.awt.Color(255, 255, 255));
        jBAgenda.setText("Agenda de socorros");
        jBAgenda.setBorder(null);
        jBAgenda.setBorderPainted(false);
        jBAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgendaActionPerformed(evt);
            }
        });

        jBEditarPerfil.setBackground(new java.awt.Color(0, 160, 186));
        jBEditarPerfil.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBEditarPerfil.setForeground(new java.awt.Color(255, 255, 255));
        jBEditarPerfil.setText("Editar perfil");
        jBEditarPerfil.setBorder(null);
        jBEditarPerfil.setBorderPainted(false);
        jBEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarPerfilActionPerformed(evt);
            }
        });

        jBSobreSoft.setBackground(new java.awt.Color(0, 160, 186));
        jBSobreSoft.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBSobreSoft.setForeground(new java.awt.Color(255, 255, 255));
        jBSobreSoft.setText("Sobre o MeSocorreAê");
        jBSobreSoft.setBorder(null);
        jBSobreSoft.setBorderPainted(false);
        jBSobreSoft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSobreSoftActionPerformed(evt);
            }
        });

        jLSubtitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLSubtitulo.setText("Sua salvação, na palma da mão!");

        jLTitulo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLTitulo.setText("MeSocorreAê");

        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/logoMenor.png"))); // NOI18N

        jBAterarSenha.setBackground(new java.awt.Color(0, 160, 186));
        jBAterarSenha.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBAterarSenha.setForeground(new java.awt.Color(255, 255, 255));
        jBAterarSenha.setText("Alterar Senha");
        jBAterarSenha.setBorder(null);
        jBAterarSenha.setBorderPainted(false);
        jBAterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAterarSenhaActionPerformed(evt);
            }
        });

        jBSair.setBackground(new java.awt.Color(0, 160, 186));
        jBSair.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBSair.setForeground(new java.awt.Color(255, 255, 255));
        jBSair.setText("Sair");
        jBSair.setBorder(null);
        jBSair.setBorderPainted(false);
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPMenuLateralLayout = new javax.swing.GroupLayout(jPMenuLateral);
        jPMenuLateral.setLayout(jPMenuLateralLayout);
        jPMenuLateralLayout.setHorizontalGroup(
            jPMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMenuLateralLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLLogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPMenuLateralLayout.createSequentialGroup()
                .addGroup(jPMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMenuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBEditarPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBSobreSoft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBAgenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPMenuLateralLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLTitulo)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPMenuLateralLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLSubtitulo)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMenuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBAterarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMenuLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPMenuLateralLayout.setVerticalGroup(
            jPMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMenuLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAterarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLTitulo)
                .addGap(1, 1, 1)
                .addComponent(jLSubtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSobreSoft, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLProximos1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLProximos1.setForeground(new java.awt.Color(0, 160, 186));
        jLProximos1.setText("Atualizar");
        jLProximos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLProximos1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPMenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLProximos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLProximos1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLProximos)
                    .addComponent(jLProximos1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPMenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(816, 631));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSobreSoftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSobreSoftActionPerformed
        formSobreSoftware fss = new formSobreSoftware();
        fss.setModal(true);
        fss.setVisible(true);
    }//GEN-LAST:event_jBSobreSoftActionPerformed

    private void jBEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarPerfilActionPerformed
        formEditarPerfil fep = new formEditarPerfil(conexaoController.getUsuarioLogado().getCpf());
        fep.setModal(true);
        fep.setVisible(true);
    }//GEN-LAST:event_jBEditarPerfilActionPerformed

    private void jTPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPedidosMouseClicked
        if (jTPedidos.getSelectedRow() > -1) {
            int codPed = listaProximosPeds.get(jTPedidos.getSelectedRow()).getCod();
            formDetalheServico fds = new formDetalheServico(codPed);
            fds.setModal(true);
            fds.setVisible(true);
        }
    }//GEN-LAST:event_jTPedidosMouseClicked

    private void jBAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgendaActionPerformed
        formAgendaPedidos fap = new formAgendaPedidos();
        fap.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBAgendaActionPerformed

    private void jLProximos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLProximos1MouseClicked
        atualizaTabela();
    }//GEN-LAST:event_jLProximos1MouseClicked

    private void jBAterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAterarSenhaActionPerformed
        formAlterarSenha fas = new formAlterarSenha(conexaoController.getUsuarioLogado());
        fas.setModal(true);
        fas.setVisible(true);  
    }//GEN-LAST:event_jBAterarSenhaActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        conexaoController.setUsuarioLogado(null);
        formLogin fl = new formLogin();
        fl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBSairActionPerformed

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
            java.util.logging.Logger.getLogger(formTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formTelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgenda;
    private javax.swing.JButton jBAterarSenha;
    private javax.swing.JButton jBEditarPerfil;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBSobreSoft;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLProximos;
    private javax.swing.JLabel jLProximos1;
    private javax.swing.JLabel jLSubtitulo;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JPanel jPMenuLateral;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPedidos;
    // End of variables declaration//GEN-END:variables
}
