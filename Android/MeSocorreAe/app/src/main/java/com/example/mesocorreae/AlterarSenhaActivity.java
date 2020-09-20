package com.example.mesocorreae;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import factory.Criptografia;
import factory.Funcoes;

public class AlterarSenhaActivity extends AppCompatActivity {
    InformacoesApp informacoesApp;
    TextInputEditText etAltSenhaAtual, etAltSenhaNova1, etAltSenhaNova2;
    Button bAltSenhaAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_senha);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();

        etAltSenhaAtual = findViewById(R.id.etAltSenhaAtual);
        etAltSenhaNova1 = findViewById(R.id.etAltSenhaNova1);
        etAltSenhaNova2 = findViewById(R.id.etAltSenhaNova2);
        bAltSenhaAlterar = findViewById(R.id.bAltSenhaAlterar);

        etAltSenhaAtual.setTransformationMethod(new PasswordTransformationMethod());
        etAltSenhaNova1.setTransformationMethod(new PasswordTransformationMethod());
        etAltSenhaNova2.setTransformationMethod(new PasswordTransformationMethod());

        bAltSenhaAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ConsisteCampos()) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int alfabeto = Funcoes.montaAlfabetoCrip(informacoesApp.usuarioLogado.getCpf());
                            String chave = Funcoes.montaChaveCrip(informacoesApp.usuarioLogado.getDataNasc(),
                                    informacoesApp.usuarioLogado.getCpf());
                            Criptografia criptografia = new Criptografia(alfabeto, chave);

                            String senhaAtual = criptografia.decrypto(informacoesApp.usuarioLogado.getSenha());

                            if (senhaAtual.equals(etAltSenhaAtual.getText().toString())) {
                                String senhaNova = criptografia.crypto(etAltSenhaNova1.getText().toString());
                                informacoesApp.usuarioLogado.setSenha(senhaNova);

                                if (informacoesApp.conexaoController.alterarSenha(informacoesApp.usuarioLogado.getCpf(), informacoesApp.usuarioLogado.getSenha())) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(AlterarSenhaActivity.this);
                                            dlgAlert.setTitle("Sucesso!!!");
                                            dlgAlert.setMessage("Sua senha foi alterada.");

                                            dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    Intent it = new Intent(AlterarSenhaActivity.this, PrincipalActivity.class);
                                                    startActivity(it);
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
                                            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(AlterarSenhaActivity.this);
                                            dlgAlert.setTitle("Erro");
                                            dlgAlert.setMessage("Ocorreu um erro ao alterar sua senha.");

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

                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        etAltSenhaAtual.setError("Senha atual incorreta.");
                                        etAltSenhaAtual.requestFocus();
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

    private boolean ConsisteCampos() {
        if (etAltSenhaAtual.getText().toString().equals("")){
            etAltSenhaAtual.setError("Informe a senha atual.");
            etAltSenhaAtual.requestFocus();
            return false;
        }
        if (etAltSenhaNova1.getText().toString().equals("")){
            etAltSenhaNova1.setError("Informe a senha nova.");
            etAltSenhaNova1.requestFocus();
            return false;
        }
        if (etAltSenhaNova2.getText().toString().equals("")){
            etAltSenhaNova2.setError("Repita a senha nova.");
            etAltSenhaNova2.requestFocus();
            return false;
        }
        if (!etAltSenhaNova1.getText().toString().equals(etAltSenhaNova2.getText().toString())){
            etAltSenhaNova1.setError("As senha não coincidem.");
            etAltSenhaNova1.requestFocus();
            return false;
        }

        return true;
    }

}
