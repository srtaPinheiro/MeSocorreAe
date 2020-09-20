package view;

import factory.Funcoes;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import static view.MeSocorreAeCliente.conexaoController;

public class formRespServico extends javax.swing.JDialog {

    int codSer;
    /** Creates new form formRespServico */
    public formRespServico(int codSer) {
        initComponents();
        this.codSer = codSer;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jLNome1 = new javax.swing.JLabel();
        jLNome2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAResposta = new javax.swing.JTextArea();
        jBFechar = new javax.swing.JButton();
        jRBSim = new javax.swing.JRadioButton();
        jRBNao = new javax.swing.JRadioButton();
        jFTFPreco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MeSocorreAê - Resp. pedido");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNome.setText("Aceita");

        jLNome1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNome1.setText("Preço");

        jLNome2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNome2.setText("Resposta");

        jTAResposta.setColumns(20);
        jTAResposta.setRows(5);
        jScrollPane1.setViewportView(jTAResposta);

        jBFechar.setBackground(new java.awt.Color(0, 160, 186));
        jBFechar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBFechar.setForeground(new java.awt.Color(255, 255, 255));
        jBFechar.setText("É isso aê");
        jBFechar.setBorderPainted(false);
        jBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFecharActionPerformed(evt);
            }
        });

        jRBSim.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRBSim);
        jRBSim.setSelected(true);
        jRBSim.setText("Sim");
        jRBSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBSimActionPerformed(evt);
            }
        });

        jRBNao.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRBNao);
        jRBNao.setText("Não");
        jRBNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBNaoActionPerformed(evt);
            }
        });

        jFTFPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFTFPreco.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLNome)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jBFechar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addComponent(jLNome1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRBSim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRBNao))
                            .addComponent(jLNome2)
                            .addComponent(jFTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBSim)
                    .addComponent(jRBNao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNome2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(272, 360));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFecharActionPerformed
        if (ConsisteCampos()) {
            if (jRBSim.isSelected()) {
                conexaoController.aceitarServico(codSer, Double.parseDouble(Funcoes.strOnlyNumbers(jFTFPreco.getText())), jTAResposta.getText());
            } else {
                conexaoController.recusarServico(codSer, jTAResposta.getText());
            }
            this.dispose();
        }
    }//GEN-LAST:event_jBFecharActionPerformed

    private boolean ErroConsisteCampo(JComponent campo, String erro, int tipoMsg){
        JOptionPane.showMessageDialog(this, erro, this.getTitle(), tipoMsg);
        campo.requestFocus();
        return false;
    }
	
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    private boolean ConsisteCampos() {
        if (!isNumeric(jFTFPreco.getText()) && jRBSim.isSelected()) {
            return ErroConsisteCampo(jFTFPreco, "Informe um valor válido.", JOptionPane.ERROR_MESSAGE);
        }
        if (jTAResposta.getText().equals("")) {
            return ErroConsisteCampo(jTAResposta, "Informe uma resposta.", JOptionPane.ERROR_MESSAGE); 
        }
        
        return true;
    }
    
    private void jRBNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBNaoActionPerformed
        if (jRBNao.isSelected()) {
            jFTFPreco.setText("");
            jFTFPreco.setEnabled(false);
        }
    }//GEN-LAST:event_jRBNaoActionPerformed

    private void jRBSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBSimActionPerformed
        if (jRBSim.isSelected()) {
            jFTFPreco.setEnabled(true);
        }
    }//GEN-LAST:event_jRBSimActionPerformed

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
            java.util.logging.Logger.getLogger(formRespServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formRespServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formRespServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formRespServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formRespServico(-1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBFechar;
    private javax.swing.JFormattedTextField jFTFPreco;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLNome1;
    private javax.swing.JLabel jLNome2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBNao;
    private javax.swing.JRadioButton jRBSim;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAResposta;
    // End of variables declaration//GEN-END:variables

}
