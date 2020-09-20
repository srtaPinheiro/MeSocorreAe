package view;

import factory.Funcoes;
import modelDominio.Servico;
import static view.MeSocorreAeCliente.conexaoController;

public class formDetalheServico extends javax.swing.JDialog {
    Servico servico = null;
    int codPed;

    public formDetalheServico(int codPedido) {
        initComponents();
        this.codPed = codPedido;
        CarregaDados();
    }
    
    private void CarregaDados() {
        servico = conexaoController.getServicoPorCod(codPed);
        
        jTFNome.setText(servico.getCliente().getNome());
        jTFSituacao.setText(servico.getSituacaoLiteral());
        
        String data = Funcoes.dateSqlToNormal(servico.getDataHoraQua().substring(0, 10));
        String hora = servico.getDataHoraQua().substring(11, 16);

        jTFData.setText(data + " " + hora);
        
        if (servico.getSituacao() != 'E') {
            jTAResposta.setText(servico.getResposta());
            jBResponder.setEnabled(false);
        }
        if ((servico.getSituacao() == 'A') || servico.getSituacao() == 'C') {
            jTFValor.setText(String.valueOf(servico.getPreco()));
        }
        if (servico.getSituacao() == 'C') {
            jTFNota.setText(String.valueOf(servico.getNota()));
            jTAAvaliacao.setText(servico.getAvaliacao());
        }
        
        jTADescricao.setText(servico.getDescricao());
        jTFEndereco.setText(servico.getCliente().getEndereco().getRua());
        jTFNumero.setText(String.valueOf(servico.getCliente().getEndereco().getNumero()));
        jTFBairro.setText(servico.getCliente().getEndereco().getBairro());
        jTFCidade.setText(servico.getCliente().getEndereco().getCidade().getNome());
        jTFEstado.setText(servico.getCliente().getEndereco().getCidade().getEstado().getNome());
        jTFCep.setText(String.valueOf(servico.getCliente().getEndereco().getCep()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jLEndereco = new javax.swing.JLabel();
        jTFEndereco = new javax.swing.JTextField();
        jLBairro = new javax.swing.JLabel();
        jTFBairro = new javax.swing.JTextField();
        jLEstado = new javax.swing.JLabel();
        jTFEstado = new javax.swing.JTextField();
        jLData = new javax.swing.JLabel();
        jTFData = new javax.swing.JTextField();
        jLNota = new javax.swing.JLabel();
        jTFNota = new javax.swing.JTextField();
        jLValor = new javax.swing.JLabel();
        jTFValor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLSituacao = new javax.swing.JLabel();
        jTFSituacao = new javax.swing.JTextField();
        jBResponder = new javax.swing.JButton();
        jLSituacao1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAResposta = new javax.swing.JTextArea();
        jLNumero = new javax.swing.JLabel();
        jTFNumero = new javax.swing.JTextField();
        jLCidade = new javax.swing.JLabel();
        jTFCidade = new javax.swing.JTextField();
        jLCep = new javax.swing.JLabel();
        jTFCep = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAAvaliacao = new javax.swing.JTextArea();
        jBFechar = new javax.swing.JButton();
        jLAvaliacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MeSocorreAê - Detalhamento pedido");
        setMinimumSize(new java.awt.Dimension(478, 608));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNome.setText("Pessoa que pediu o socorro");

        jTFNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFNome.setFocusable(false);

        jLDescricao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLDescricao.setText("Descrição");

        jTADescricao.setColumns(20);
        jTADescricao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTADescricao.setLineWrap(true);
        jTADescricao.setRows(5);
        jTADescricao.setFocusable(false);
        jScrollPane1.setViewportView(jTADescricao);

        jLEndereco.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLEndereco.setText("Endereço");

        jTFEndereco.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFEndereco.setFocusable(false);

        jLBairro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLBairro.setText("Bairro");

        jTFBairro.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFBairro.setFocusable(false);

        jLEstado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLEstado.setText("Estado");

        jTFEstado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFEstado.setFocusable(false);

        jLData.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLData.setText("Pra quando");

        jTFData.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFData.setFocusable(false);

        jLNota.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNota.setText("Nota");

        jTFNota.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFNota.setFocusable(false);

        jLValor.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLValor.setText("Valor do serviço");

        jTFValor.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFValor.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFNome)
                    .addComponent(jTFData)
                    .addComponent(jScrollPane1)
                    .addComponent(jTFEndereco)
                    .addComponent(jTFBairro)
                    .addComponent(jTFEstado)
                    .addComponent(jTFNota)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLNome)
                            .addComponent(jLDescricao)
                            .addComponent(jLEndereco)
                            .addComponent(jLBairro)
                            .addComponent(jLEstado)
                            .addComponent(jLData)
                            .addComponent(jLNota)
                            .addComponent(jLValor))
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(jTFValor))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLNome)
                .addGap(6, 6, 6)
                .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLData)
                .addGap(6, 6, 6)
                .addComponent(jTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLBairro)
                .addGap(6, 6, 6)
                .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLEstado)
                .addGap(6, 6, 6)
                .addComponent(jTFEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLNota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNota, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLSituacao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLSituacao.setText("Situação");

        jTFSituacao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFSituacao.setFocusable(false);

        jBResponder.setBackground(new java.awt.Color(0, 160, 186));
        jBResponder.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBResponder.setForeground(new java.awt.Color(255, 255, 255));
        jBResponder.setText("Responder");
        jBResponder.setBorderPainted(false);
        jBResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResponderActionPerformed(evt);
            }
        });

        jLSituacao1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLSituacao1.setText("Resposta");

        jTAResposta.setColumns(20);
        jTAResposta.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTAResposta.setLineWrap(true);
        jTAResposta.setRows(5);
        jTAResposta.setFocusable(false);
        jScrollPane3.setViewportView(jTAResposta);

        jLNumero.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLNumero.setText("Número");

        jTFNumero.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFNumero.setFocusable(false);

        jLCidade.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLCidade.setText("Cidade");

        jTFCidade.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFCidade.setFocusable(false);

        jLCep.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLCep.setText("CEP");

        jTFCep.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTFCep.setFocusable(false);

        jTAAvaliacao.setColumns(20);
        jTAAvaliacao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTAAvaliacao.setLineWrap(true);
        jTAAvaliacao.setRows(4);
        jTAAvaliacao.setFocusable(false);
        jScrollPane2.setViewportView(jTAAvaliacao);

        jBFechar.setBackground(new java.awt.Color(0, 160, 186));
        jBFechar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBFechar.setForeground(new java.awt.Color(255, 255, 255));
        jBFechar.setText("Já vi, pode fechar");
        jBFechar.setBorderPainted(false);
        jBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFecharActionPerformed(evt);
            }
        });

        jLAvaliacao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLAvaliacao.setText("Avaliação do cliente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFSituacao)
                    .addComponent(jScrollPane3)
                    .addComponent(jBResponder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFNumero)
                    .addComponent(jTFCidade)
                    .addComponent(jTFCep)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jBFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLSituacao)
                            .addComponent(jLSituacao1)
                            .addComponent(jLNumero)
                            .addComponent(jLCidade)
                            .addComponent(jLCep)
                            .addComponent(jLAvaliacao))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLSituacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLSituacao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNumero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFCep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLAvaliacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(572, 698));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBFecharActionPerformed

    private void jBResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResponderActionPerformed
        formRespServico frs = new formRespServico(codPed);
        frs.setModal(true);
        frs.setVisible(true);
        
        CarregaDados();
    }//GEN-LAST:event_jBResponderActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formDetalheServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formDetalheServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formDetalheServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formDetalheServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formDetalheServico(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBFechar;
    private javax.swing.JButton jBResponder;
    private javax.swing.JLabel jLAvaliacao;
    private javax.swing.JLabel jLBairro;
    private javax.swing.JLabel jLCep;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLNota;
    private javax.swing.JLabel jLNumero;
    private javax.swing.JLabel jLSituacao;
    private javax.swing.JLabel jLSituacao1;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTAAvaliacao;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextArea jTAResposta;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFCep;
    private javax.swing.JTextField jTFCidade;
    private javax.swing.JTextField jTFData;
    private javax.swing.JTextField jTFEndereco;
    private javax.swing.JTextField jTFEstado;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNota;
    private javax.swing.JTextField jTFNumero;
    private javax.swing.JTextField jTFSituacao;
    private javax.swing.JTextField jTFValor;
    // End of variables declaration//GEN-END:variables
}
