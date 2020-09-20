package com.example.mesocorreae;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import factory.Criptografia;
import factory.Funcoes;
import factory.MaskEditUtil;
import modelDominio.Cidade;
import modelDominio.Cliente;
import modelDominio.Endereco;
import modelDominio.Estado;

public class CadastroActivity extends AppCompatActivity {
    InformacoesApp informacoesApp;
    ArrayList<Estado> listaEstados;
    String[] estados;
    ArrayList<Cidade> listaCidades;
    String[] cidades;

    Spinner sCadastroEstado, sCadastroCidade;
    Button bCadastroCadastrar;
    TextInputEditText etCadastroNome, etCadastroEmail, etCadastroCpf, etCadastroDataNasc, etCadastroSenha,
            etCadastroRepSenha, etCadastroTelefone, etCadastroEndereco, etCadastroNumero,
            etCadastroBairro, etCadastroCep, etCadastroComplemento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();

        etCadastroNome = findViewById(R.id.etCadastroNome);
        etCadastroEmail = findViewById(R.id.etCadastroEmail);
        etCadastroCpf = findViewById(R.id.etCadastroCpf);
        etCadastroDataNasc = findViewById(R.id.etCadastroDataNasc);
        etCadastroSenha = findViewById(R.id.etCadastroSenha);
        etCadastroRepSenha = findViewById(R.id.etCadastroRepSenha);
        etCadastroTelefone = findViewById(R.id.etCadastroTelefone);
        etCadastroEndereco = findViewById(R.id.etCadastroEndereco);
        etCadastroNumero = findViewById(R.id.etCadastroNumero);
        etCadastroBairro = findViewById(R.id.etCadastroBairro);
        etCadastroCep = findViewById(R.id.etCadastroCep);
        etCadastroComplemento = findViewById(R.id.etCadastroComplemento);
        sCadastroEstado = findViewById(R.id.sCadastroEstado);
        sCadastroCidade = findViewById(R.id.sCadastroCidade);
        bCadastroCadastrar = findViewById(R.id.bCadastroCadastrar);

        etCadastroSenha.setTransformationMethod(new PasswordTransformationMethod());
        etCadastroRepSenha.setTransformationMethod(new PasswordTransformationMethod());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                listaEstados = informacoesApp.conexaoController.getListaEstados();
                estados = new String[listaEstados.size()];
                for (int x = 0; x < listaEstados.size(); x++) {
                    estados[x] = listaEstados.get(x).getNome();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<String> estadosSpinnerAdapter = new ArrayAdapter<String>(CadastroActivity.this, android.R.layout.simple_spinner_item, estados);
                        estadosSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sCadastroEstado.setAdapter(estadosSpinnerAdapter);
                    }
                });
            }
        });
        thread.start();

        sCadastroEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Estado estadoSelecionado = listaEstados.get(position);
                        listaCidades = informacoesApp.conexaoController.getListaCidades(estadoSelecionado.getId());
                        cidades = new String[listaCidades.size()];
                        for (int x = 0; x < listaCidades.size(); x++) {
                            cidades[x] = listaCidades.get(x).getNome();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ArrayAdapter<String> cidadesSpinnerAdapter = new ArrayAdapter<String>(CadastroActivity.this, android.R.layout.simple_spinner_item, cidades);
                                cidadesSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                sCadastroCidade.setAdapter(cidadesSpinnerAdapter);
                            }
                        });
                    }
                });
                thread.start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bCadastroCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ConsisteCampos()) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Endereco endereco = new Endereco(
                                    etCadastroEndereco.getText().toString(),
                                    Integer.parseInt(etCadastroNumero.getText().toString()),
                                    etCadastroBairro.getText().toString(),
                                    etCadastroComplemento.getText().toString(),
                                    listaCidades.get(sCadastroCidade.getSelectedItemPosition()),
                                    Integer.parseInt(MaskEditUtil.unmask(etCadastroCep.getText().toString()))
                            );

                            Cliente cliente = new Cliente(
                                    Long.parseLong(MaskEditUtil.unmask(etCadastroCpf.getText().toString())),
                                    etCadastroNome.getText().toString(),
                                    etCadastroEmail.getText().toString(),
                                    etCadastroSenha.getText().toString(),
                                    Funcoes.dateNormalToSql(etCadastroDataNasc.getText().toString()),
                                    endereco,
                                    Long.parseLong(MaskEditUtil.unmask(etCadastroTelefone.getText().toString())),
                                    "N"
                            );

                            int alfabeto = Funcoes.montaAlfabetoCrip(cliente.getCpf());
                            String chave = Funcoes.montaChaveCrip(cliente.getDataNasc(), cliente.getCpf());
                            Criptografia criptografia = new Criptografia(alfabeto, chave);
                            String senhaCrip = criptografia.crypto(cliente.getSenha());
                            cliente.setSenha(senhaCrip);

                            if (informacoesApp.conexaoController.clienteInserir(cliente)) {
                                informacoesApp.usuarioLogado = informacoesApp.conexaoController.getUsuario(cliente.getCpf());

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(CadastroActivity.this);
                                        dlgAlert.setTitle("Sucesso!!!");
                                        dlgAlert.setMessage("Seu cadastro foi efetuado. Você será direcionado para a tela principal.");

                                        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent it = new Intent(CadastroActivity.this, PrincipalActivity.class);
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
                                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(CadastroActivity.this);
                                        dlgAlert.setTitle("Erro");
                                        dlgAlert.setMessage("Houve um erro no seu cadastro. Verifique as informações que nos passou.");

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

        etCadastroCpf.addTextChangedListener(MaskEditUtil.mask(etCadastroCpf, MaskEditUtil.FORMAT_CPF));
        etCadastroDataNasc.addTextChangedListener(MaskEditUtil.mask(etCadastroDataNasc, MaskEditUtil.FORMAT_DATE));
        etCadastroCep.addTextChangedListener(MaskEditUtil.mask(etCadastroCep, MaskEditUtil.FORMAT_CEP));
        etCadastroTelefone.addTextChangedListener(MaskEditUtil.mask(etCadastroTelefone, MaskEditUtil.FORMAT_FONE));

    }

    private boolean ConsisteCampos() {

        if (etCadastroNome.getText().toString().equals("")) {
            etCadastroNome.requestFocus();
            etCadastroNome.setError("O seu nome é tão sua cara! Informa ele pra gente?");
            return false;
        }
        if (etCadastroEmail.getText().toString().equals("")) {
            etCadastroEmail.requestFocus();
            etCadastroEmail.setError("Como poderemos conversar sem seu email? Para se ter uma boa relação é necessário um bom diálogo, informe seu email!");
            return false;
        }
        if (etCadastroCpf.getText().toString().equals("")) {
            etCadastroCpf.requestFocus();
            etCadastroCpf.setError("Sem seu cpf é impossível prosseguirmos!");
            return false;
        }
        if (etCadastroDataNasc.getText().toString().equals("")) {
            etCadastroDataNasc.requestFocus();
            etCadastroDataNasc.setError("Precisamos que você informe sua data de nascimento, somente assim podemos continuar");
            return false;
        }
        if (etCadastroSenha.getText().toString().equals("")) {
            etCadastroSenha.requestFocus();
            etCadastroSenha.setError("A senha é extremamente importante, não esqueça dela!");
            return false;
        }
        if (etCadastroRepSenha.getText().toString().equals("")) {
            etCadastroRepSenha.requestFocus();
            etCadastroRepSenha.setError("Precisamos que você preencha o campo REPETIR SENHA para podermos continuar!");
            return false;
        }
        if (etCadastroTelefone.getText().toString().equals("")) {
            etCadastroTelefone.requestFocus();
            etCadastroTelefone.setError("O número de telefone é obrigatório");
            return false;
        }
        if (etCadastroRepSenha.getText().toString().equals("")) {
            etCadastroRepSenha.requestFocus();
            etCadastroRepSenha.setError("Precisamos que você preencha o campo REPETIR SENHA para ppodermos continuar!");
            return false;
        }
        if (etCadastroEndereco.getText().toString().equals("")) {
            etCadastroEndereco.requestFocus();
            etCadastroEndereco.setError("Precisamos que você preencha o campo de endereço para continuar!");
            return false;
        }
        if (etCadastroNumero.getText().toString().equals("")) {
            etCadastroNumero.requestFocus();
            etCadastroNumero.setError("O campo numero é obrigatório!");
            return false;
        }
        if (etCadastroBairro.getText().toString().equals("")) {
            etCadastroBairro.requestFocus();
            etCadastroBairro.setError("Precisamos que você nos diga qual seu bairro para ppodermos continuar!");
            return false;
        }
        if (sCadastroEstado.getSelectedItemPosition() < 0) {
            sCadastroEstado.requestFocus();
            Toast.makeText(informacoesApp, "Precisamos que você selecione o seu estado!", Toast.LENGTH_SHORT).show();
        return false;
        }
        if (sCadastroCidade.getSelectedItemPosition() < 0) {
            sCadastroCidade.requestFocus();
            Toast.makeText(informacoesApp, "Precisamos que você selecione a sua cidade!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etCadastroCep.getText().toString().equals("")) {
            etCadastroCep.requestFocus();
            etCadastroCep.setError("Precisamos que você preencha o CEP do lugar onde mora!");
            return false;
        }
        return true;
    }

}
