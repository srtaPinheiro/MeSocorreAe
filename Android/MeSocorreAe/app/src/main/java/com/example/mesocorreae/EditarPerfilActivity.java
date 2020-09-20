package com.example.mesocorreae;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

public class EditarPerfilActivity extends AppCompatActivity {
    InformacoesApp informacoesApp;
    ArrayList<Estado> listaEstados;
    String[] estados;
    ArrayList<Cidade> listaCidades;
    String[] cidades;
    Cliente meuCliente;

    int posicaoEstado = 0;
    int posicaoCidade = 0;

    Spinner sEditarPerfilEstado, sEditarPerfilCidade;
    Button bEditarPerfilAlterar;
    TextInputEditText etEditarPerfilNome, etEditarPerfilEmail, etEditarPerfilTelefone, etEditarPerfilEndereco, etEditarPerfilNumero,
            etEditarPerfilBairro, etEditarPerfilCep, etEditarPerfilComplemento;
    Boolean terminouCarregar = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        informacoesApp = (InformacoesApp) getApplicationContext();

        etEditarPerfilNome = findViewById(R.id.etEditarPerfilNome);
        etEditarPerfilEmail = findViewById(R.id.etEditarPerfilEmail);
        etEditarPerfilTelefone = findViewById(R.id.etEditarPerfilTelefone);
        etEditarPerfilEndereco = findViewById(R.id.etEditarPerfilEndereco);
        etEditarPerfilNumero = findViewById(R.id.etEditarPerfilNumero);
        etEditarPerfilBairro = findViewById(R.id.etEditarPerfilBairro);
        etEditarPerfilCep = findViewById(R.id.etEditarPerfilCep);
        etEditarPerfilComplemento = findViewById(R.id.etEditarPerfilComplemento);
        sEditarPerfilEstado = findViewById(R.id.sEditarPerfilEstado);
        sEditarPerfilCidade = findViewById(R.id.sEditarPerfilCidade);
        bEditarPerfilAlterar = findViewById(R.id.bEditarPerfilAlterar);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                listaEstados = informacoesApp.conexaoController.getListaEstados();
                estados = new String[listaEstados.size()];
                for (int x = 0; x < listaEstados.size(); x++) {
                    estados[x] = listaEstados.get(x).getNome();
                }

                meuCliente = (Cliente) informacoesApp.conexaoController.getUsuarioCompleto(informacoesApp.usuarioLogado.getCpf());
                //Verificando se a posição do estado é igual ao nome do estado e guardando a posição
                for (int x = 0; x < estados.length; x++) {
                    if (estados[x].equals(meuCliente.getEndereco().getCidade().getEstado().getNome())) {
                        posicaoEstado = x;
                        break;
                    }
                }

                listaCidades = informacoesApp.conexaoController.getListaCidades(listaEstados.get(posicaoEstado).getId());
                cidades = new String[listaCidades.size()];
                for (int x = 0; x < listaCidades.size(); x++) {
                    cidades[x] = listaCidades.get(x).getNome();
                }
                for (int x = 0; x < cidades.length; x++) {
                    if (cidades[x].equals(meuCliente.getEndereco().getCidade().getNome())) {
                        posicaoCidade = x;
                        break;
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<String> estadosSpinnerAdapter = new ArrayAdapter<String>(EditarPerfilActivity.this, android.R.layout.simple_spinner_item, estados);
                        estadosSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sEditarPerfilEstado.setAdapter(estadosSpinnerAdapter);

                        ArrayAdapter<String> cidadesSpinnerAdapter = new ArrayAdapter<String>(EditarPerfilActivity.this, android.R.layout.simple_spinner_item, cidades);
                        cidadesSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sEditarPerfilCidade.setAdapter(cidadesSpinnerAdapter);

                        sEditarPerfilEstado.setSelection(posicaoEstado);
                        sEditarPerfilCidade.setSelection(posicaoCidade);

                        etEditarPerfilNome.setText(meuCliente.getNome());
                        etEditarPerfilEmail.setText(meuCliente.getEmail());
                        etEditarPerfilTelefone.setText(String.valueOf(meuCliente.getTelefone()));
                        etEditarPerfilEndereco.setText(meuCliente.getEndereco().getRua());
                        etEditarPerfilNumero.setText(String.valueOf(meuCliente.getEndereco().getNumero()));
                        etEditarPerfilBairro.setText(meuCliente.getEndereco().getBairro());
                        etEditarPerfilCep.setText(String.valueOf(meuCliente.getEndereco().getCep()));
                        etEditarPerfilComplemento.setText(meuCliente.getEndereco().getComplemento());
                    }
                });

            }
        });
        thread.start();

        sEditarPerfilEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (!terminouCarregar) {
                    terminouCarregar = true;
                    return;
                }

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
                                ArrayAdapter<String> cidadesSpinnerAdapter = new ArrayAdapter<String>(EditarPerfilActivity.this, android.R.layout.simple_spinner_item, cidades);
                                cidadesSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                sEditarPerfilCidade.setAdapter(cidadesSpinnerAdapter);
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

        bEditarPerfilAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ConsisteCampos()) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Cidade cidade = listaCidades.get(sEditarPerfilCidade.getSelectedItemPosition());
                            Endereco endereco = new Endereco(
                                    etEditarPerfilEndereco.getText().toString(),
                                    Integer.parseInt(etEditarPerfilNumero.getText().toString()),
                                    etEditarPerfilBairro.getText().toString(),
                                    etEditarPerfilComplemento.getText().toString(),
                                    cidade,
                                    Integer.parseInt(Funcoes.strOnlyNumbers(etEditarPerfilCep.getText().toString())));

                            Cliente cliente = new Cliente(
                                    informacoesApp.usuarioLogado.getCpf(),
                                    etEditarPerfilNome.getText().toString(),
                                    etEditarPerfilEmail.getText().toString(),
                                    null,
                                    null,
                                    endereco,
                                    Long.parseLong(Funcoes.strOnlyNumbers(etEditarPerfilTelefone.getText().toString())),
                                    null
                            );

                            if (informacoesApp.conexaoController.alterarCliente(cliente)) {
                                informacoesApp.usuarioLogado = informacoesApp.conexaoController.getUsuario(informacoesApp.usuarioLogado.getCpf());
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(EditarPerfilActivity.this);
                                        dlgAlert.setTitle("Sucesso!!!");
                                        dlgAlert.setMessage("Seu cadastro foi alterado.");

                                        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent it = new Intent(EditarPerfilActivity.this, PrincipalActivity.class);
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
                                        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(EditarPerfilActivity.this);
                                        dlgAlert.setTitle("Erro");
                                        dlgAlert.setMessage("Verifique os dados.");

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

        etEditarPerfilCep.addTextChangedListener(MaskEditUtil.mask(etEditarPerfilCep, MaskEditUtil.FORMAT_CEP));
        etEditarPerfilTelefone.addTextChangedListener(MaskEditUtil.mask(etEditarPerfilTelefone, MaskEditUtil.FORMAT_FONE));

    }

    private boolean ConsisteCampos() {
        if (etEditarPerfilNome.getText().equals("")) {
            etEditarPerfilNome.requestFocus();
            etEditarPerfilNome.setError("O seu nome é tão sua cara! Informa ele pra gente?");
            return false;
        }
        if (etEditarPerfilEmail.getText().equals("")) {
            etEditarPerfilEmail.requestFocus();
            etEditarPerfilEmail.setError("Como poderemos conversar sem seu email? Para se ter uma boa relação é necessário um bom diálogo, informe seu email!");
            return false;
        }
        if (etEditarPerfilTelefone.getText().equals("")) {
            etEditarPerfilTelefone.requestFocus();
            etEditarPerfilTelefone.setError("O número de telefone é obrigatório");
            return false;
        }
        if (etEditarPerfilEndereco.getText().equals("")) {
            etEditarPerfilEndereco.requestFocus();
            etEditarPerfilEndereco.setError("Precisamos que você preencha o campo de endereço para continuar!");
            return false;
        }
        if (etEditarPerfilNumero.getText().equals("")) {
            etEditarPerfilNumero.requestFocus();
            etEditarPerfilNumero.setError("O campo numero é obrigatório!");
            return false;
        }
        if (etEditarPerfilBairro.getText().equals("")) {
            etEditarPerfilBairro.requestFocus();
            etEditarPerfilBairro.setError("Precisamos que você nos diga qual seu bairro para ppodermos continuar!");
            return false;
        }
        if (sEditarPerfilEstado.getSelectedItemPosition() < 0) {
            sEditarPerfilEstado.requestFocus();
            Toast.makeText(informacoesApp, "Precisamos que você selecione o seu estado!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (sEditarPerfilCidade.getSelectedItemPosition() < 0) {
            sEditarPerfilCidade.requestFocus();
            Toast.makeText(informacoesApp, "Precisamos que você selecione a sua cidade!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etEditarPerfilCep.getText().equals("")) {
            etEditarPerfilCep.requestFocus();
            etEditarPerfilCep.setError("Precisamos que você preencha o CEP do lugar onde mora!");
            return false;
        }
        return true;
    }

}


