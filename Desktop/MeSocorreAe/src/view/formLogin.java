package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import modelDominio.Administrador;
import modelDominio.Autonomo;
import modelDominio.Usuario;
import static view.MeSocorreAeCliente.conexaoController;
import factory.Funcoes;

public class formLogin extends javax.swing.JFrame {
    String filepathGuardaDados = "dados";
    File f = new File(filepathGuardaDados);

    public formLogin() {
        initComponents();
        if (f.exists()){
            jCKLembrarDados.setSelected(true);
            jBEntrar.requestFocus();
            int count = 0;
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                while (br.ready()) {
                    if (count == 0){
                        jFTFCpf.setText(br.readLine());
                    } else if (count == 1) {
                        jPFSenha.setText(br.readLine());
                    }
                    count++;
                }
                br.close();
                fr.close();
            } catch (FileNotFoundException ex ) {
                
            } catch (IOException ex) {
                
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLLogo = new javax.swing.JLabel();
        jLSubtitulo = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        jFTFCpf = new javax.swing.JFormattedTextField();
        jPFSenha = new javax.swing.JPasswordField();
        jLSenha = new javax.swing.JLabel();
        jLEsqueciSenha = new javax.swing.JLabel();
        jLUsuario = new javax.swing.JLabel();
        jCKLembrarDados = new javax.swing.JCheckBox();
        jBLimpar = new javax.swing.JButton();
        jBEntrar = new javax.swing.JButton();
        jLCadastro = new javax.swing.JLabel();
        jLCadastroLink = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MeSocorreAê - Login do autônomo");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/logo.png"))); // NOI18N

        jLSubtitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLSubtitulo.setText("Meu login");

        jLTitulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLTitulo.setText("MeSocorreAê");

        try {
            jFTFCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCpf.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jPFSenha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLSenha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLSenha.setText("Senha");

        jLEsqueciSenha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLEsqueciSenha.setForeground(new java.awt.Color(0, 0, 255));
        jLEsqueciSenha.setText("Putz, esqueci...");
        jLEsqueciSenha.setToolTipText("");
        jLEsqueciSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLEsqueciSenhaMouseClicked(evt);
            }
        });

        jLUsuario.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLUsuario.setText("CPF");

        jCKLembrarDados.setBackground(new java.awt.Color(255, 255, 255));
        jCKLembrarDados.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jCKLembrarDados.setSelected(true);
        jCKLembrarDados.setText("Lembrar meus dados");
        jCKLembrarDados.setFocusPainted(false);

        jBLimpar.setBackground(new java.awt.Color(0, 160, 186));
        jBLimpar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBLimpar.setForeground(new java.awt.Color(255, 255, 255));
        jBLimpar.setText("Errei");
        jBLimpar.setBorderPainted(false);
        jBLimpar.setFocusPainted(false);
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jBEntrar.setBackground(new java.awt.Color(0, 160, 186));
        jBEntrar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jBEntrar.setText("Vamo bora");
        jBEntrar.setBorderPainted(false);
        jBEntrar.setFocusPainted(false);
        jBEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrarActionPerformed(evt);
            }
        });

        jLCadastro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLCadastro.setText("É um autônomo e ainda não tem cadastro?");

        jLCadastroLink.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLCadastroLink.setForeground(new java.awt.Color(0, 0, 255));
        jLCadastroLink.setText("Quero fazer parte");
        jLCadastroLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCadastroLinkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLCadastro)
                        .addGap(9, 9, 9)
                        .addComponent(jLCadastroLink))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLSenha)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLEsqueciSenha))
                                .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLUsuario)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCKLembrarDados)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLTitulo)
                            .addComponent(jLSubtitulo)
                            .addComponent(jLLogo))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLSubtitulo)
                .addGap(33, 33, 33)
                .addComponent(jLUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSenha)
                    .addComponent(jLEsqueciSenha))
                .addGap(6, 6, 6)
                .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jCKLembrarDados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCadastro)
                    .addComponent(jLCadastroLink))
                .addContainerGap())
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

        setSize(new java.awt.Dimension(544, 581));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLEsqueciSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLEsqueciSenhaMouseClicked
        formEsqueciSenha fes = new formEsqueciSenha();
        fes.setModal(true);
        fes.setVisible(true);
    }//GEN-LAST:event_jLEsqueciSenhaMouseClicked

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        jFTFCpf.setText("");
        jPFSenha.setText("");
        jCKLembrarDados.setSelected(false);
        jFTFCpf.requestFocus();
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jBEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntrarActionPerformed
        if (ConsisteCampos()){
            long cpf = Long.parseLong(Funcoes.strOnlyNumbers(jFTFCpf.getText()));
            Usuario usuario = conexaoController.fazerLogin(
                    cpf, String.valueOf(jPFSenha.getPassword()));
            if (usuario != null) {
                if (jCKLembrarDados.isSelected()){
                    try {
                        FileWriter fw = new FileWriter(f);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(jFTFCpf.getText());
                        bw.newLine();
                        bw.write(String.valueOf(jPFSenha.getPassword()));
                        bw.close();
                        fw.close();
                    } catch (IOException ex) {
                        
                    }
                } else if (f.exists()) {
                    f.delete();
                }
                
                if (usuario instanceof Autonomo){
                    conexaoController.setUsuarioLogado(usuario);
                    
                    switch(conexaoController.getUsuarioLogado().getStatus()) {
                        case "I": { //Cadastro incompleto
                            JOptionPane.showMessageDialog(this, 
                                    "Seu cadastro está incompleto, por favor complete-o para poder utilizar o software.",
                                    this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                            formEditarPerfil fep = new formEditarPerfil(conexaoController.getUsuarioLogado().getCpf());
                            fep.setVisible(true);
                            this.dispose();
                            break;
                        }
                        case "P": { //Cadastro pendente de aprovacao
                            JOptionPane.showMessageDialog(this, 
                                    "Seu cadastro está em análise para aprovação. Por favor, aguarde.",
                                    this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                            conexaoController.setUsuarioLogado(null);
                            break;
                        }
                        default: {
                            formTelaPrincipal ftp = new formTelaPrincipal();
                            ftp.setVisible(true);
                            this.dispose();
                        }
                    }
                } else if (usuario instanceof Administrador) {
                    conexaoController.setUsuarioLogado(usuario);
                    formTelaAdmin fta = new formTelaAdmin();
                    fta.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Usuário inválido.", this.getTitle(), JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Dados de acesso incorretos.", this.getTitle(), JOptionPane.WARNING_MESSAGE);
            }      
        }
    }//GEN-LAST:event_jBEntrarActionPerformed

    private void jLCadastroLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCadastroLinkMouseClicked
        formCadastroUsuario fcu = new formCadastroUsuario(this);
        fcu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLCadastroLinkMouseClicked

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
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formLogin().setVisible(true);
            }
        });
    }
    
    private boolean ConsisteCampos(){
        if (jFTFCpf.getText().equals("   .   .   -  ")){
            JOptionPane.showMessageDialog(this, "Informe o usuário.", this.getTitle(), JOptionPane.WARNING_MESSAGE);
            jFTFCpf.requestFocus();
            return false;
        }
        if (String.valueOf(jPFSenha.getPassword()).equals("")){
            JOptionPane.showMessageDialog(this, "Informe a senha.", this.getTitle(), JOptionPane.WARNING_MESSAGE);
            jPFSenha.requestFocus();
            return false;
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEntrar;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JCheckBox jCKLembrarDados;
    private javax.swing.JFormattedTextField jFTFCpf;
    private javax.swing.JLabel jLCadastro;
    private javax.swing.JLabel jLCadastroLink;
    private javax.swing.JLabel jLEsqueciSenha;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLSubtitulo;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
