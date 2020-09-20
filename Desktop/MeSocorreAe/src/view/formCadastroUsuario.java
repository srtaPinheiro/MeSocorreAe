package view;

import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelDominio.Autonomo;
import modelDominio.Cidade;
import modelDominio.Endereco;
import modelDominio.Estado;
import static view.MeSocorreAeCliente.conexaoController;
import view.util.ComboboxCidade;
import view.util.ComboboxEstado;
import factory.Funcoes;

public class formCadastroUsuario extends javax.swing.JFrame {
    JFrame telaChamou;
    
    public formCadastroUsuario(JFrame telaChamou) {
        ArrayList<Estado> lista = conexaoController.getListaEstados();
        
        initComponents();
        this.telaChamou = telaChamou;
        
        ComboboxEstado.preencheComboboxEstado(-1, jCBEstado, lista);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLEmail = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jPFSenha = new javax.swing.JPasswordField();
        jLRepeteSenha = new javax.swing.JLabel();
        jPFRepeteSenha = new javax.swing.JPasswordField();
        jLDataNasc = new javax.swing.JLabel();
        jFTFDataNasc = new javax.swing.JFormattedTextField();
        jLCpf = new javax.swing.JLabel();
        jFTFCpf = new javax.swing.JFormattedTextField();
        jLEstado = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox<>();
        jLCidade = new javax.swing.JLabel();
        jCBCidade = new javax.swing.JComboBox<>();
        jLEndereco = new javax.swing.JLabel();
        jTFEndereco = new javax.swing.JTextField();
        jLNumero = new javax.swing.JLabel();
        jTFNumero = new javax.swing.JTextField();
        jLBairro = new javax.swing.JLabel();
        jTFBairro = new javax.swing.JTextField();
        jLCep = new javax.swing.JLabel();
        jFTFCep = new javax.swing.JFormattedTextField();
        jLComplemento = new javax.swing.JLabel();
        jTFComplemento = new javax.swing.JTextField();
        jLTelefone = new javax.swing.JLabel();
        jFTFTelefone = new javax.swing.JFormattedTextField();
        jBCancelar = new javax.swing.JButton();
        jBCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MeSocorreAê - Cadastro de autônomos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNome.setText("Nome");

        jTFNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLEmail.setText("E-mail");

        jTFEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLSenha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLSenha.setText("Digite uma senha");

        jPFSenha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLRepeteSenha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLRepeteSenha.setText("Digite novamente a senha");

        jPFRepeteSenha.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLDataNasc.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLDataNasc.setText("Data de nascimento");

        try {
            jFTFDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFDataNasc.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLCpf.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLCpf.setText("CPF");

        try {
            jFTFCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCpf.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLEstado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLEstado.setText("Estado");

        jCBEstado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jCBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEstadoActionPerformed(evt);
            }
        });

        jLCidade.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLCidade.setText("Cidade");

        jCBCidade.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jCBCidade.setToolTipText("");
        jCBCidade.setEnabled(false);
        jCBCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCidadeActionPerformed(evt);
            }
        });

        jLEndereco.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLEndereco.setText("Endereço");

        jTFEndereco.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFEndereco.setEnabled(false);

        jLNumero.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNumero.setText("Número");

        jTFNumero.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFNumero.setEnabled(false);

        jLBairro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLBairro.setText("Bairro");

        jTFBairro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFBairro.setEnabled(false);

        jLCep.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLCep.setText("CEP");

        try {
            jFTFCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCep.setEnabled(false);
        jFTFCep.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLComplemento.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLComplemento.setText("Mais alguma informação?");

        jTFComplemento.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFComplemento.setEnabled(false);

        jLTelefone.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLTelefone.setText("Telefone");

        try {
            jFTFTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFTelefone.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jBCancelar.setBackground(new java.awt.Color(0, 160, 186));
        jBCancelar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jBCancelar.setText("Cancelar");
        jBCancelar.setBorderPainted(false);
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBCadastrar.setBackground(new java.awt.Color(0, 160, 186));
        jBCadastrar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrar.setText("Vamo bora");
        jBCadastrar.setBorderPainted(false);
        jBCadastrar.setFocusPainted(false);
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLDataNasc)
                                    .addComponent(jFTFDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLCpf)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLEstado)
                                .addGap(179, 179, 179)
                                .addComponent(jLCidade))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLNome)
                                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLSenha)
                                    .addComponent(jPFSenha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLRepeteSenha)
                                    .addComponent(jLEmail)
                                    .addComponent(jTFEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(jPFRepeteSenha)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLEndereco)
                                    .addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLBairro)
                                    .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLComplemento)
                                    .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLTelefone)
                                    .addComponent(jLCep)
                                    .addComponent(jLNumero)
                                    .addComponent(jFTFCep, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(jFTFTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(jTFNumero))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLNome)
                        .addGap(6, 6, 6)
                        .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLEmail)
                        .addGap(6, 6, 6)
                        .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSenha)
                    .addComponent(jLRepeteSenha))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPFRepeteSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDataNasc)
                    .addComponent(jLCpf))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLCidade)
                                .addGap(44, 44, 44)))
                        .addComponent(jLEndereco)
                        .addGap(6, 6, 6)
                        .addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLNumero)
                        .addGap(6, 6, 6)
                        .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBairro)
                    .addComponent(jLCep))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFCep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLComplemento)
                    .addComponent(jLTelefone))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(474, 529));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        telaChamou.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        if (ConsisteCampos()){
            long cpf = Long.parseLong(Funcoes.strOnlyNumbers(jFTFCpf.getText()));
            String dataNasc = Funcoes.dateNormalToSql(jFTFDataNasc.getText());
            Estado estado = conexaoController.getEstadoPorCod(ComboboxEstado.getSelectedIndex(jCBEstado));
            Cidade cidade = conexaoController.getCidadePorCod(ComboboxCidade.getSelectedIndex(jCBCidade));
            cidade.setEstado(estado);
            Endereco endereco = new Endereco(jTFEndereco.getText(), 
                    Integer.parseInt(jTFNumero.getText()), jTFBairro.getText(), 
                    jTFComplemento.getText(), cidade, 
                    Integer.parseInt(Funcoes.strOnlyNumbers(jFTFCep.getText())));
            
            int alfabeto = Funcoes.montaAlfabetoCrip(cpf);
            String chave = Funcoes.montaChaveCrip(dataNasc, cpf);
            Criptografia criptografia = new Criptografia(alfabeto, chave);
            String senhaCrip = criptografia.crypto(String.valueOf(jPFSenha.getPassword()));
            
            Autonomo autonomo = new Autonomo(cpf, jTFNome.getText(), 
                    jTFEmail.getText(), senhaCrip, dataNasc, endereco, 
                    Long.parseLong(Funcoes.strOnlyNumbers(jFTFTelefone.getText())));
            
            if (conexaoController.autonomoInserir(autonomo)) {
                conexaoController.setUsuarioLogado(conexaoController.getUsuario(cpf));
                JOptionPane.showMessageDialog(this,
                        "Seu cadastro está incompleto, por favor complete-o para poder utilizar o software.",
                        this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                formEditarPerfil fep = new formEditarPerfil(conexaoController.getUsuarioLogado().getCpf());
                fep.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro no cadastro. Revise os dados informados.", this.getTitle(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        telaChamou.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed
    
    private void jCBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEstadoActionPerformed
        jCBCidade.setEnabled((jCBEstado.getSelectedIndex() > -1));
        ArrayList<Cidade> lista = conexaoController.getListaCidades(
                ComboboxEstado.getSelectedIndex(jCBEstado));
        ComboboxCidade.preencheComboboxCidade(-1, jCBCidade, lista);
    }//GEN-LAST:event_jCBEstadoActionPerformed

    private void jCBCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCidadeActionPerformed
        jTFEndereco.setEnabled((jCBCidade.getSelectedIndex() > -1));
        jTFNumero.setEnabled((jCBCidade.getSelectedIndex() > -1));
        jTFBairro.setEnabled((jCBCidade.getSelectedIndex() > -1));
        jFTFCep.setEnabled((jCBCidade.getSelectedIndex() > -1));
        jTFComplemento.setEnabled((jCBCidade.getSelectedIndex() > -1));
        
        jTFEndereco.setText("");
        jTFNumero.setText("");
        jTFBairro.setText("");
        jFTFCep.setText("     -   ");
        jTFComplemento.setText("");
    }//GEN-LAST:event_jCBCidadeActionPerformed

    /*
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
            java.util.logging.Logger.getLogger(formCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formCadastroUsuario(null).setVisible(true);
            }
        });
    }
    
    private boolean ErroConsisteCampo(JComponent campo, String erro, int tipoMsg){
        JOptionPane.showMessageDialog(this, erro, this.getTitle(), tipoMsg);
        campo.requestFocus();
        return false;
    }
    
    private boolean ConsisteCampos(){
        if (jTFNome.getText().equals("")){
            return ErroConsisteCampo(jTFNome, "Informe o nome.", JOptionPane.WARNING_MESSAGE);
        }
        if (jTFEmail.getText().equals("")){
            return ErroConsisteCampo(jTFEmail, "Informe o e-mail.", JOptionPane.WARNING_MESSAGE);
        }
        if (String.valueOf(jPFSenha.getPassword()).equals("")){
            return ErroConsisteCampo(jPFSenha, "Informe a senha.", JOptionPane.WARNING_MESSAGE);
        }
        if (String.valueOf(jPFRepeteSenha.getPassword()).equals("")){
            return ErroConsisteCampo(jPFRepeteSenha, "Repita a senha.", JOptionPane.WARNING_MESSAGE);
        }
        if (!String.valueOf(jPFSenha.getPassword()).equals(String.valueOf(jPFRepeteSenha.getPassword()))){
            return ErroConsisteCampo(jPFSenha, "As senhas não conferem.", JOptionPane.WARNING_MESSAGE);
        }
        if (jFTFDataNasc.getText().equals("  /  /    ")){
            return ErroConsisteCampo(jFTFDataNasc, "Informe a data de nascimento.", JOptionPane.WARNING_MESSAGE);
        }
        if (jFTFCpf.getText().equals("   .   .   -  ")){
            return ErroConsisteCampo(jFTFCpf, "Informe o CPF.", JOptionPane.WARNING_MESSAGE);
        }
        if (jCBEstado.getSelectedIndex() == -1){
            return ErroConsisteCampo(jCBEstado, "Informe o estado.", JOptionPane.WARNING_MESSAGE);
        }
        if (jCBCidade.getSelectedIndex() == -1){
            return ErroConsisteCampo(jCBCidade, "Informe a cidade.", JOptionPane.WARNING_MESSAGE);
        }
        if (jTFEndereco.getText().equals("")){
            return ErroConsisteCampo(jTFEndereco, "Informe o endereço.", JOptionPane.WARNING_MESSAGE);
        }
        if (jTFNumero.getText().equals("")){
            return ErroConsisteCampo(jTFNumero, "Informe o número.", JOptionPane.WARNING_MESSAGE);
        }
        if (jTFBairro.getText().equals("")){
            return ErroConsisteCampo(jTFBairro, "Informe o bairro.", JOptionPane.WARNING_MESSAGE);
        }
        if (jFTFCep.getText().equals("     -   ")){
            return ErroConsisteCampo(jFTFCep, "Informe o CEP.", JOptionPane.WARNING_MESSAGE);
        }
        if (jFTFTelefone.getText().equals("(  )      -    ")){
            return ErroConsisteCampo(jFTFTelefone, "Informe o telefone.", JOptionPane.WARNING_MESSAGE);
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JComboBox<String> jCBCidade;
    private javax.swing.JComboBox<String> jCBEstado;
    private javax.swing.JFormattedTextField jFTFCep;
    private javax.swing.JFormattedTextField jFTFCpf;
    private javax.swing.JFormattedTextField jFTFDataNasc;
    private javax.swing.JFormattedTextField jFTFTelefone;
    private javax.swing.JLabel jLBairro;
    private javax.swing.JLabel jLCep;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLComplemento;
    private javax.swing.JLabel jLCpf;
    private javax.swing.JLabel jLDataNasc;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLNumero;
    private javax.swing.JLabel jLRepeteSenha;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLTelefone;
    private javax.swing.JPasswordField jPFRepeteSenha;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFComplemento;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFEndereco;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNumero;
    // End of variables declaration//GEN-END:variables
}
