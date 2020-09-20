package view;

import factory.Funcoes;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import modelDominio.Usuario;
import static view.MeSocorreAeCliente.conexaoController;

public class formAlterarSenha extends javax.swing.JDialog {

    private Usuario meuUsuario;

    public formAlterarSenha(Usuario meuUsuario) {
        initComponents();
        this.meuUsuario = meuUsuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPFAlterarSenhaNovaSenha = new javax.swing.JPasswordField();
        jPFAlterarSenhaNovaSenhaDeNovo = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPFAlterarSenhaSenhaAtual = new javax.swing.JPasswordField();
        jBAlterarSenha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MeSocorreAê - Alterar senha");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Senha atual:");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Nova Senha:");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Repita a senha:");

        jBAlterarSenha.setBackground(new java.awt.Color(0, 160, 186));
        jBAlterarSenha.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBAlterarSenha.setForeground(new java.awt.Color(255, 255, 255));
        jBAlterarSenha.setText("Alterar senha");
        jBAlterarSenha.setBorderPainted(false);
        jBAlterarSenha.setFocusPainted(false);
        jBAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jPFAlterarSenhaSenhaAtual)
                    .addComponent(jPFAlterarSenhaNovaSenha)
                    .addComponent(jPFAlterarSenhaNovaSenhaDeNovo)
                    .addComponent(jBAlterarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPFAlterarSenhaSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPFAlterarSenhaNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPFAlterarSenhaNovaSenhaDeNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBAlterarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        setSize(new java.awt.Dimension(258, 286));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarSenhaActionPerformed
        if (ConsisteCampos()) {
            int alfabeto = Funcoes.montaAlfabetoCrip(meuUsuario.getCpf());
            String chave = Funcoes.montaChaveCrip(meuUsuario.getDataNasc(), meuUsuario.getCpf());
            Criptografia criptografia = new Criptografia(alfabeto, chave);
            
            String senhaAtual = criptografia.decrypto(meuUsuario.getSenha());
            
            String senhaNova = criptografia.crypto(String.valueOf(jPFAlterarSenhaNovaSenha.getPassword()));
            meuUsuario.setSenha(senhaNova);
            
            if (conexaoController.alterarSenha(meuUsuario.getCpf(), meuUsuario.getSenha())) {
                conexaoController.setUsuarioLogado(conexaoController.getUsuario(meuUsuario.getCpf()));
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao alterar a senha.", this.getTitle(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBAlterarSenhaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPFAlterarSenhaNovaSenha;
    private javax.swing.JPasswordField jPFAlterarSenhaNovaSenhaDeNovo;
    private javax.swing.JPasswordField jPFAlterarSenhaSenhaAtual;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private boolean ErroConsisteCampo(JComponent campo, String erro, int tipoMsg){
        JOptionPane.showMessageDialog(this, erro, this.getTitle(), tipoMsg);
        campo.requestFocus();
        return false;
    }
    
    private boolean ConsisteCampos() {
        if (jPFAlterarSenhaSenhaAtual.getPassword().toString().equals("")) {
            return ErroConsisteCampo(jPFAlterarSenhaSenhaAtual, "Campo senha atual está vazio.", JOptionPane.ERROR_MESSAGE);
        }
        if (jPFAlterarSenhaNovaSenha.getPassword().toString().equals("")) {
            return ErroConsisteCampo(jPFAlterarSenhaNovaSenha, "Campo nova senha está vazio.", JOptionPane.ERROR_MESSAGE);
        }
        if (jPFAlterarSenhaNovaSenhaDeNovo.getPassword().toString().equals("")) {
            return ErroConsisteCampo(jPFAlterarSenhaNovaSenhaDeNovo, "Campo repetir nova senha está vazio.", JOptionPane.ERROR_MESSAGE);
        }
        if (!String.valueOf(jPFAlterarSenhaNovaSenhaDeNovo.getPassword()).equals(String.valueOf(jPFAlterarSenhaNovaSenha.getPassword()))) {
            return ErroConsisteCampo(jPFAlterarSenhaNovaSenha, "As novas senha não conferem.", JOptionPane.ERROR_MESSAGE);
        }

        return true;
    }

}
