package view;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelDominio.Autonomo;
import modelDominio.Categoria;
import modelDominio.Cidade;
import modelDominio.Endereco;
import static view.MeSocorreAeCliente.conexaoController;
import view.util.ComboboxCategoria;
import view.util.ComboboxCidade;
import view.util.ComboboxEstado;
import factory.Funcoes;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.util.Imagem;

public class formEditarPerfil extends javax.swing.JDialog {
    private Autonomo autonomo;
    private Imagem imagem = null;
    
    public formEditarPerfil(long codUsu) {
        initComponents();
        autonomo = (Autonomo) conexaoController.getUsuarioCompleto(codUsu);
        CarregaDados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPParte1 = new javax.swing.JPanel();
        jLLabelFoto = new javax.swing.JLabel();
        jLFoto = new javax.swing.JLabel();
        jBTrocarFoto = new javax.swing.JButton();
        jBRemoverFoto = new javax.swing.JButton();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jLNota = new javax.swing.JLabel();
        jTFNota = new javax.swing.JTextField();
        jLVisibilidade = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jCKVisibilidade = new javax.swing.JCheckBox();
        jLCategoria = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jPParte3 = new javax.swing.JPanel();
        jLEstado = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox<>();
        jLCidade = new javax.swing.JLabel();
        jCBCidade = new javax.swing.JComboBox<>();
        jLEndereco = new javax.swing.JLabel();
        jTFEndereco = new javax.swing.JTextField();
        jLNumero = new javax.swing.JLabel();
        jLBairro = new javax.swing.JLabel();
        jTFBairro = new javax.swing.JTextField();
        jLComplemento = new javax.swing.JLabel();
        jTFComplemento = new javax.swing.JTextField();
        jLCep = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jLTelefone = new javax.swing.JLabel();
        jFTFNumero = new javax.swing.JFormattedTextField();
        jFTFCep = new javax.swing.JFormattedTextField();
        jFTFTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MeSocorreAê - Editar perfil");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPParte1.setBackground(new java.awt.Color(255, 255, 255));

        jLLabelFoto.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLLabelFoto.setText("Foto");

        jLFoto.setBackground(new java.awt.Color(204, 204, 204));
        jLFoto.setMaximumSize(new java.awt.Dimension(115, 115));
        jLFoto.setMinimumSize(new java.awt.Dimension(115, 115));
        jLFoto.setPreferredSize(new java.awt.Dimension(115, 115));

        jBTrocarFoto.setBackground(new java.awt.Color(0, 160, 186));
        jBTrocarFoto.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBTrocarFoto.setForeground(new java.awt.Color(255, 255, 255));
        jBTrocarFoto.setText("Trocar");
        jBTrocarFoto.setBorderPainted(false);
        jBTrocarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTrocarFotoActionPerformed(evt);
            }
        });

        jBRemoverFoto.setBackground(new java.awt.Color(0, 160, 186));
        jBRemoverFoto.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBRemoverFoto.setForeground(new java.awt.Color(255, 255, 255));
        jBRemoverFoto.setText("Remover");
        jBRemoverFoto.setBorderPainted(false);
        jBRemoverFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoverFotoActionPerformed(evt);
            }
        });

        jLNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNome.setText("Nome");

        jTFNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLDescricao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLDescricao.setText("Descrição");

        jTADescricao.setColumns(20);
        jTADescricao.setLineWrap(true);
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jLNota.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNota.setText("Minha nota");

        jTFNota.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFNota.setEnabled(false);

        jLVisibilidade.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLVisibilidade.setText("Visibilidade do perfil");

        jCKVisibilidade.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jCKVisibilidade.setText("Ativa");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCKVisibilidade)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCKVisibilidade, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jLCategoria.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLCategoria.setText("Categoria de serviços");

        jCBCategoria.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPParte1Layout = new javax.swing.GroupLayout(jPParte1);
        jPParte1.setLayout(jPParte1Layout);
        jPParte1Layout.setHorizontalGroup(
            jPParte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPParte1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPParte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFNome)
                    .addGroup(jPParte1Layout.createSequentialGroup()
                        .addComponent(jLFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPParte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBTrocarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBRemoverFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addComponent(jTFNota)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPParte1Layout.createSequentialGroup()
                        .addGroup(jPParte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLLabelFoto)
                            .addComponent(jLNome)
                            .addComponent(jLDescricao)
                            .addComponent(jLNota)
                            .addComponent(jLVisibilidade)
                            .addComponent(jLCategoria))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPParte1Layout.setVerticalGroup(
            jPParte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPParte1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLLabelFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPParte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPParte1Layout.createSequentialGroup()
                        .addComponent(jBTrocarFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemoverFoto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNota, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLVisibilidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPParte3.setBackground(new java.awt.Color(255, 255, 255));

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

        jLEndereco.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLEndereco.setText("Endereço");

        jTFEndereco.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLNumero.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNumero.setText("Número");

        jLBairro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLBairro.setText("Bairro");

        jTFBairro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLComplemento.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLComplemento.setText("Complemento");

        jTFComplemento.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLCep.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLCep.setText("CEP");

        jBSalvar.setBackground(new java.awt.Color(0, 160, 186));
        jBSalvar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jBSalvar.setText("Tudo certo, pode salvar");
        jBSalvar.setBorderPainted(false);
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jLTelefone.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLTelefone.setText("Telefone");

        jFTFNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFTFNumero.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        try {
            jFTFCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCep.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        try {
            jFTFTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFTelefone.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPParte3Layout = new javax.swing.GroupLayout(jPParte3);
        jPParte3.setLayout(jPParte3Layout);
        jPParte3Layout.setHorizontalGroup(
            jPParte3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPParte3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPParte3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFEndereco)
                    .addComponent(jTFBairro)
                    .addComponent(jTFComplemento)
                    .addComponent(jBSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jFTFNumero)
                    .addComponent(jFTFCep)
                    .addGroup(jPParte3Layout.createSequentialGroup()
                        .addGroup(jPParte3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLEstado)
                            .addComponent(jLCidade)
                            .addComponent(jLEndereco)
                            .addComponent(jLNumero)
                            .addComponent(jLBairro)
                            .addComponent(jLComplemento)
                            .addComponent(jLCep)
                            .addComponent(jLTelefone))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jFTFTelefone))
                .addContainerGap())
        );
        jPParte3Layout.setVerticalGroup(
            jPParte3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPParte3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNumero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLBairro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLComplemento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFCep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jBSalvar)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPParte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPParte3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPParte3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPParte1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(586, 622));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if (ConsisteCampos()) {
            Categoria categoria = conexaoController.getCategoriaPorCod(ComboboxCategoria.getSelectedIndex(jCBCategoria));
            Cidade cidade = conexaoController.getCidadePorCod(ComboboxCidade.getSelectedIndex(jCBCidade));
            Endereco endereco = new Endereco(jTFEndereco.getText(),
                    Integer.parseInt(Funcoes.strOnlyNumbers(jFTFNumero.getText())), 
                    jTFBairro.getText(), 
                    jTFComplemento.getText(), 
                    cidade, 
                    Integer.parseInt(Funcoes.strOnlyNumbers(jFTFCep.getText())));
            Autonomo autonomoAux = null;
            if (imagem != null) {
                 autonomoAux = new Autonomo(
                    conexaoController.getUsuarioLogado().getCpf(), 
                    jTFNome.getText(), 
                    conexaoController.getUsuarioLogado().getEmail(), 
                    conexaoController.getUsuarioLogado().getSenha(), 
                    imagem.getImagem(), 
                    conexaoController.getUsuarioLogado().getDataNasc(),
                    endereco, 
                    Long.parseLong(Funcoes.strOnlyNumbers(jFTFTelefone.getText())), 
                    conexaoController.getUsuarioLogado().getStatus(),
                    categoria,
                    jTADescricao.getText(),
                    0);
            } else {
                autonomoAux = new Autonomo(
                    conexaoController.getUsuarioLogado().getCpf(), 
                    jTFNome.getText(), 
                    conexaoController.getUsuarioLogado().getEmail(), 
                    conexaoController.getUsuarioLogado().getSenha(), 
                    null,
                    conexaoController.getUsuarioLogado().getDataNasc(),
                    endereco, 
                    Long.parseLong(Funcoes.strOnlyNumbers(jFTFTelefone.getText())), 
                    conexaoController.getUsuarioLogado().getStatus(),
                    categoria,
                    jTADescricao.getText(),
                    0);
            }

            if (conexaoController.getUsuarioLogado().getStatus().equals("I")) {
                autonomoAux.setStatus("P");
            } else if (jCKVisibilidade.isSelected()) {
                autonomoAux.setStatus("N");
            } else {
                autonomoAux.setStatus("O");
            }

            if (conexaoController.autonomoAlterar(autonomoAux)) {
                conexaoController.setUsuarioLogado(conexaoController.getUsuario(autonomoAux.getCpf()));

                if (conexaoController.getUsuarioLogado().getStatus().equals("P")) {
                    JOptionPane.showMessageDialog(this,
                            "Seu cadastro está em análise para aprovação. Por favor, aguarde.",
                            this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                    conexaoController.setUsuarioLogado(null);
                    formLogin fl = new formLogin();
                    fl.setVisible(true);
                    this.dispose();
                } else {
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                            "Ocorreu um erro ao alterar seus dados.",
                            this.getTitle(), JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBTrocarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTrocarFotoActionPerformed
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        jFileChooser.addChoosableFileFilter(imageFilter);
        if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            imagem = new Imagem(jFileChooser.getSelectedFile());
            jLFoto.setIcon(imagem.getImageIcon());
        }
    }//GEN-LAST:event_jBTrocarFotoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void jBRemoverFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoverFotoActionPerformed
        imagem = null;
        ImageIcon icon = new ImageIcon(getClass().getResource("/view/images/semFoto.png"));
        Image image = icon.getImage().getScaledInstance(115, 115, Image.SCALE_SMOOTH);
        jLFoto.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_jBRemoverFotoActionPerformed

    private void jCBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEstadoActionPerformed
        ArrayList<Cidade> lista = conexaoController.getListaCidades(
                ComboboxEstado.getSelectedIndex(jCBEstado));
        ComboboxCidade.preencheComboboxCidade(-1, jCBCidade, lista);
        jCBCidade.setSelectedIndex(0);
    }//GEN-LAST:event_jCBEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(formEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formEditarPerfil(-1).setVisible(true);
            }
        });
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
    
    private boolean ErroConsisteCampo(JComponent campo, String erro, int tipoMsg){
        JOptionPane.showMessageDialog(this, erro, this.getTitle(), tipoMsg);
        campo.requestFocus();
        return false;
    }
    
    private boolean ConsisteCampos() {
        if (jTFNome.getText().equals("")) {
            return ErroConsisteCampo(jTFNome, "Preencha o campo nome.", JOptionPane.ERROR_MESSAGE);
        }
        if (jTADescricao.getText().equals("")) {
            return ErroConsisteCampo(jTADescricao, "Preencha o campo descrição.", JOptionPane.ERROR_MESSAGE);
        }
        if (jCBCategoria.getSelectedIndex() == -1) {
            return ErroConsisteCampo(jCBCategoria, "Selecione uma categoria.", JOptionPane.ERROR_MESSAGE);
        }
        if (jCBEstado.getSelectedIndex() == -1) {
            return ErroConsisteCampo(jCBEstado, "Selecione um estado.", JOptionPane.ERROR_MESSAGE);
        }
        if (jCBCidade.getSelectedIndex() == -1) {
            return ErroConsisteCampo(jCBCidade, "Selecione uma cidade.", JOptionPane.ERROR_MESSAGE);
        }
        if (jTFEndereco.getText().equals("")) {
            return ErroConsisteCampo(jTFEndereco, "Informe seu endereço.", JOptionPane.ERROR_MESSAGE);
        }
        if (!isNumeric(jFTFNumero.getText())) {
            return ErroConsisteCampo(jFTFNumero, "Informe um número válido.", JOptionPane.ERROR_MESSAGE);
        }
        if (jTFBairro.getText().equals("")) {
            return ErroConsisteCampo(jTFBairro, "Informe seu bairro.", JOptionPane.ERROR_MESSAGE);
        }
        if (jFTFCep.getText().equals("     -   ")) {
            return ErroConsisteCampo(jFTFCep, "Informe seu CEP.", JOptionPane.ERROR_MESSAGE);
        }
        if (jFTFTelefone.getText().equals("(  )      -    ")) {
            return ErroConsisteCampo(jFTFTelefone, "Informe seu telefone.", JOptionPane.ERROR_MESSAGE);
        }
        
        return true;
    }
    
    private void CarregaDados(){
        ArrayList listaCat = conexaoController.getListaCategorias();
        ArrayList listaEst = conexaoController.getListaEstados();
        ArrayList listaCid = conexaoController.getListaCidades(
                autonomo.getEndereco().getCidade().getEstado().getId());
        
        if (!autonomo.getStatus().equals("I")) {
            ComboboxCategoria.preencheComboboxCategoria(
                    autonomo.getCategoria().getId(), jCBCategoria, listaCat);
            if (autonomo.getStatus().equals("O")) {
                jCKVisibilidade.setSelected(false);
            } else if (autonomo.getStatus().equals("N")) {
                jCKVisibilidade.setSelected(true);
            }
        } else {
            ComboboxCategoria.preencheComboboxCategoria(-1, jCBCategoria, listaCat);
            jCKVisibilidade.setEnabled(false);
            jCKVisibilidade.setSelected(false);
        }
        
        ComboboxEstado.preencheComboboxEstado(
                autonomo.getEndereco().getCidade().getEstado().getId(), jCBEstado, listaEst);
        ComboboxCidade.preencheComboboxCidade(
                autonomo.getEndereco().getCidade().getId(), jCBCidade, listaCid);
        
        jTFNome.setText(autonomo.getNome());
        jTADescricao.setText(autonomo.getDescricao());
        jFTFTelefone.setText(String.valueOf(autonomo.getTelefone()));
        jTFNota.setText(String.valueOf(autonomo.getAvaliacao()));
        jTFEndereco.setText(autonomo.getEndereco().getRua());
        jFTFNumero.setText(String.valueOf(autonomo.getEndereco().getNumero()));
        jTFBairro.setText(autonomo.getEndereco().getBairro());
        jTFComplemento.setText(autonomo.getEndereco().getComplemento());
        jFTFCep.setText(String.valueOf(autonomo.getEndereco().getCep()));
        
        if (autonomo.getFoto() != null) {
            imagem = new Imagem(autonomo.getFoto());
            jLFoto.setIcon(imagem.getImageIcon());
        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("/view/images/semFoto.png"));
            Image image = icon.getImage().getScaledInstance(115, 115, Image.SCALE_SMOOTH);
            jLFoto.setIcon(new ImageIcon(image));
        }
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBRemoverFoto;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jBTrocarFoto;
    private javax.swing.JComboBox<String> jCBCategoria;
    private javax.swing.JComboBox<String> jCBCidade;
    private javax.swing.JComboBox<String> jCBEstado;
    private javax.swing.JCheckBox jCKVisibilidade;
    private javax.swing.JFormattedTextField jFTFCep;
    private javax.swing.JFormattedTextField jFTFNumero;
    private javax.swing.JFormattedTextField jFTFTelefone;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLBairro;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JLabel jLCep;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLComplemento;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLLabelFoto;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLNota;
    private javax.swing.JLabel jLNumero;
    private javax.swing.JLabel jLTelefone;
    private javax.swing.JLabel jLVisibilidade;
    private javax.swing.JPanel jPParte1;
    private javax.swing.JPanel jPParte3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFComplemento;
    private javax.swing.JTextField jTFEndereco;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNota;
    // End of variables declaration//GEN-END:variables
}
