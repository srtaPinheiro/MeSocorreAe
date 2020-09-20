package com.example.mesocorreae;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import factory.Funcoes;
import factory.MaskEditUtil;
import modelDominio.Autonomo;
import modelDominio.Cliente;
import modelDominio.Servico;

public class SolicitacaoActivity extends AppCompatActivity {
    InformacoesApp informacoesApp;
    Button bSolicitacaoSolicitar;
    TextInputEditText etSolicitacaoData, etSolicitacaoHora, etSolicitacaoDescricao;
    Autonomo autonomo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        informacoesApp = (InformacoesApp) getApplicationContext();

        etSolicitacaoData = findViewById(R.id.etSolicitacaoData);
        etSolicitacaoHora = findViewById(R.id.etSolicitacaoHora);
        bSolicitacaoSolicitar = findViewById(R.id.bSolicitacaoSolicitar);
        etSolicitacaoDescricao = findViewById(R.id.etSolicitacaoDescricao);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etSolicitacaoData.addTextChangedListener(MaskEditUtil.mask(etSolicitacaoData, MaskEditUtil.FORMAT_DATE));
        etSolicitacaoHora.addTextChangedListener(MaskEditUtil.mask(etSolicitacaoHora, MaskEditUtil.FORMAT_HOUR));

        Intent it = getIntent();
        if (it != null) {
            if (it.hasExtra("autonomo")) {
                autonomo = (Autonomo) it.getSerializableExtra("autonomo");
                this.setTitle(autonomo.getNome());
            }
        }

        bSolicitacaoSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ConsisteCampos()) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Autonomo autonomoPedido = new Autonomo(autonomo.getCpf());
                            Cliente clientePedido = new Cliente(informacoesApp.usuarioLogado.getCpf());
                            String dataHoraQua = Funcoes.dateNormalToSql(etSolicitacaoData.getText().toString()) +
                                    " " + etSolicitacaoHora.getText().toString();

                            Servico servico = new Servico(etSolicitacaoDescricao.getText().toString(),
                                    clientePedido, autonomoPedido, dataHoraQua);
                            if (informacoesApp.conexaoController.servicoInserir(servico)) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(SolicitacaoActivity.this);
                                        dlgAlert.setTitle("Sucesso!!!");
                                        dlgAlert.setMessage("Agora é só esperar o autônomo responder.");

                                        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                finish();
                                            }
                                        });

                                        dlgAlert.setCancelable(false);
                                        dlgAlert.create().show();
                                    }
                                });
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(SolicitacaoActivity.this);
                                        dlgAlert.setTitle("Erro");
                                        dlgAlert.setMessage("Aconteceu um erro ao resgistrar sua solicitação de orçamento.");

                                        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        });

                                        dlgAlert.setCancelable(false);
                                        dlgAlert.create().show();
                                    }
                                });
                            }
                        }
                    });
                    thread.start();
                }
            }
        });

    }

    public boolean ConsisteCampos() {
        if (etSolicitacaoDescricao.getText().toString().equals("")) {
            etSolicitacaoDescricao.requestFocus();
            etSolicitacaoDescricao.setError("Favor informar a descrição para que o autônomo saiba o que você deseja!");
            return false;
        }
        if (etSolicitacaoData.getText().toString().equals("")) {
            etSolicitacaoData.requestFocus();
            etSolicitacaoData.setError("Favor informar a data para que o autônomo saiba quando lhe ajudar!");
            return false;
        }
        if (etSolicitacaoHora.getText().toString().equals("")) {
            etSolicitacaoHora.requestFocus();
            etSolicitacaoHora.setError("Favor informar a hora para que o autônomo saiba quando lhe ajudar!");
            return false;
        }
        if (!Funcoes.validaData(etSolicitacaoData.getText().toString())) {
            etSolicitacaoData.requestFocus();
            etSolicitacaoData.setError("Favor informe uma data válida!");
            return false;
        }
        if (!Funcoes.validaHora(etSolicitacaoHora.getText().toString())) {
            etSolicitacaoHora.requestFocus();
            etSolicitacaoHora.setError("Favor informe uma hora válida!");
            return false;
        }

        return true;
    }

}
