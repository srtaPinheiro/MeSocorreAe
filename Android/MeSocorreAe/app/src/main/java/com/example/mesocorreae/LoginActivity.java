package com.example.mesocorreae;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

import factory.MaskEditUtil;
import modelDominio.Administrador;
import modelDominio.Autonomo;
import modelDominio.Cliente;
import modelDominio.Usuario;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText etLoginUsuario, etLoginSenha;
    CheckBox cbLoginLembrarSenha;
    Button bLoginEntrar, bLoginCadastrar, bLoginLimpar;
    TextView tvLoginEsqueciSenha;
    InformacoesApp informacoesApp;
    public static final String NOME_PREFERENCE = "INFORMACOES_LOGIN_AUTOMATICO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        informacoesApp = (InformacoesApp) getApplicationContext();

        bLoginEntrar = findViewById(R.id.bLoginEntrar);
        bLoginCadastrar = findViewById(R.id.bLoginCadastrar);
        bLoginLimpar = findViewById(R.id.bLoginLimpar);
        etLoginUsuario = findViewById(R.id.etLoginUsuario);
        etLoginSenha = findViewById(R.id.etLoginSenha);
        cbLoginLembrarSenha = findViewById(R.id.cbLoginLembrarSenha);
        tvLoginEsqueciSenha = findViewById(R.id.tvLoginEsqueciSenha);

        etLoginSenha.setTransformationMethod(new PasswordTransformationMethod());

        SharedPreferences prefs = getSharedPreferences(NOME_PREFERENCE, MODE_PRIVATE);
        String login = prefs.getString("login", null);
        String senha = prefs.getString("senha", null);
        if (login != null) {
            etLoginUsuario.setText(login);
            etLoginSenha.setText(senha);
            cbLoginLembrarSenha.setChecked(true);
        }

        bLoginEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ConsisteCampos()) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Aqui pega os dados login e senha e mandar pro método fazerlogin que ta no conexao e vai retornar
                            //um objeto do tipo usuario com o usuario ou não :D
                            long cpf = Long.parseLong(MaskEditUtil.unmask(etLoginUsuario.getText().toString()));
                            Usuario usuario = informacoesApp.conexaoController.fazerLogin(cpf, etLoginSenha.getText().toString());
                            if (usuario != null) { //verifica se o usuario é null

                                if (usuario instanceof Cliente) {  //verifica se o usuario é cliente

                                    informacoesApp.usuarioLogado = usuario; //fala qual é o usuario para o usuario logogado que ta nas infoApp

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            SharedPreferences.Editor editor = getSharedPreferences(NOME_PREFERENCE, MODE_PRIVATE).edit();
                                            if (cbLoginLembrarSenha.isChecked()) {
                                                editor.putString("login", etLoginUsuario.getText().toString());
                                                editor.putString("senha", etLoginSenha.getText().toString());
                                            } else {
                                                editor.putString("login", null);
                                                editor.putString("senha", null);
                                            }
                                            editor.commit();
                                            Intent it = new Intent(LoginActivity.this, PrincipalActivity.class);
                                            startActivity(it);
                                            finish();
                                        }
                                    });
                                } else if (usuario instanceof Autonomo) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(LoginActivity.this, "Sem suporte para esse tipo de usuário.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else if (usuario instanceof Administrador) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(LoginActivity.this, "Sem suporte para esse tipo de usuário.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "Dados de acesso incorretos.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    });
                    thread.start();
                }
            }
        });

        bLoginCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(it);
            }
        });

        bLoginLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });

        etLoginUsuario.addTextChangedListener(MaskEditUtil.mask(etLoginUsuario, MaskEditUtil.FORMAT_CPF));

        tvLoginEsqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, RecuperarSenhaActivity.class);
                startActivity(it);
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    public void limparCampos() {
        etLoginUsuario.setText("");
        etLoginSenha.setText("");
        cbLoginLembrarSenha.setChecked(false);
        etLoginUsuario.requestFocus();
    }


    public boolean ConsisteCampos() {
        if (etLoginUsuario.getText().toString().equals("")) {
            etLoginUsuario.requestFocus();
            etLoginUsuario.setError("Favor informar seu CPF!");
            return false;
        }
        if (etLoginSenha.getText().toString().equals("")) {
            etLoginSenha.requestFocus();
            etLoginSenha.setError("Favor informar sua senha!");
            return false;
        }

        return true;
    }
}
