package com.example.mesocorreae;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import factory.MaskEditUtil;

public class RecuperarSenhaActivity extends AppCompatActivity {
    TextInputEditText etRecSenhaCpf;
    Button bRecSenhaRecuperar;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();

        etRecSenhaCpf = findViewById(R.id.etRecSenhaCpf);
        bRecSenhaRecuperar = findViewById(R.id.bRecSenhaRecuperar);

        etRecSenhaCpf.addTextChangedListener(MaskEditUtil.mask(etRecSenhaCpf, MaskEditUtil.FORMAT_CPF));

        bRecSenhaRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ConsisteCampos()) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            long cpf = Long.parseLong(MaskEditUtil.unmask(etRecSenhaCpf.getText().toString()));
                            if (informacoesApp.conexaoController.recuperarSenha(cpf)) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(RecuperarSenhaActivity.this);
                                        dlgAlert.setMessage("Sua senha foi enviada por email, verifique sua caixa de entrada.");
                                        dlgAlert.setTitle("Sucesso!!!");
                                        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

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
                                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(RecuperarSenhaActivity.this);
                                        dlgAlert.setMessage("Ocorreu um erro ao recuperar sua senha. Verifique seus dados.");
                                        dlgAlert.setTitle("Erro");
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

    private boolean ConsisteCampos() {
        if (etRecSenhaCpf.getText().toString().equals("")) {
            etRecSenhaCpf.setError("Informe seu CPF.");
            etRecSenhaCpf.requestFocus();
            return false;
        }

        return true;
    }

}
