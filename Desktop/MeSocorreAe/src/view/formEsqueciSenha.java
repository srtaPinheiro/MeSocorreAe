package view;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import static view.MeSocorreAeCliente.conexaoController;
import factory.Funcoes;

public class formEsqueciSenha extends javax.swing.JDialog {

    public formEsqueciSenha() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jFTFCpf = new javax.swing.JFormattedTextField();
        jLCpf = new javax.swing.JLabel();
        jBRestaurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MeSocorreAê - Esqueci minha senha");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        try {
            jFTFCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCpf.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLCpf.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLCpf.setText("Informe seu CPF");

        jBRestaurar.setBackground(new java.awt.Color(0, 160, 186));
        jBRestaurar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBRestaurar.setForeground(new java.awt.Color(255, 255, 255));
        jBRestaurar.setText("Restaurar senha");
        jBRestaurar.setBorderPainted(false);
        jBRestaurar.setFocusPainted(false);
        jBRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCpf)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBRestaurar)
                        .addComponent(jFTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLCpf)
                .addGap(6, 6, 6)
                .addComponent(jFTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(263, 157));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean ErroConsisteCampo(JComponent campo, String erro, int tipoMsg){
        JOptionPane.showMessageDialog(this, erro, this.getTitle(), tipoMsg);
        campo.requestFocus();
        return false;
    }
    
    private boolean ConsisteCampos(){
        if (jFTFCpf.getText().equals("")){
            return ErroConsisteCampo(jFTFCpf, "Informe seu CPF.", JOptionPane.WARNING_MESSAGE);
        }
        
        return true;
    }
    
    private void jBRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRestaurarActionPerformed
        if (ConsisteCampos()){
            if (conexaoController.recuperarSenha(Long.parseLong(Funcoes.strOnlyNumbers(jFTFCpf.getText())))) {
                JOptionPane.showMessageDialog(this, 
                        "Sua senha foi enviada por email, verifique sua caixa de entrada.", 
                        this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, 
                        "Ocorreu um erro ao recuperar sua senha.", 
                        this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBRestaurarActionPerformed

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
            java.util.logging.Logger.getLogger(formEsqueciSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formEsqueciSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formEsqueciSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formEsqueciSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formEsqueciSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBRestaurar;
    private javax.swing.JFormattedTextField jFTFCpf;
    private javax.swing.JLabel jLCpf;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
