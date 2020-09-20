package com.example.mesocorreae;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import factory.Funcoes;
import modelDominio.Servico;

public class PedidoActivity extends AppCompatActivity {
    InformacoesApp informacoesApp;
    EditText etPedidoNota, etPedidoAvaliacao;
    ImageView ivPedidoAutonomoFoto;
    TextView tvPedidoAutonomoNome, tvPedidoSituacao, tvPedidoQuando, tvPedidoDescricao, tvPedidoPreco, tvPedidoResposta;
    LinearLayout llPedidoFeedback, llPedidoCabecalho, llPedidoResposta, llPedidoPreco;
    Button bPedidoDarFeedback;
    Servico servico = null;
    int idServico = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();

        etPedidoNota = findViewById(R.id.etPedidoNota);
        etPedidoAvaliacao = findViewById(R.id.etPedidoAvaliacao);
        ivPedidoAutonomoFoto = findViewById(R.id.ivPedidoAutonomoFoto);
        tvPedidoAutonomoNome = findViewById(R.id.tvPedidoAutonomoNome);
        tvPedidoSituacao = findViewById(R.id.tvPedidoSituacao);
        tvPedidoQuando = findViewById(R.id.tvPedidoQuando);
        tvPedidoDescricao = findViewById(R.id.tvPedidoDescricao);
        tvPedidoPreco = findViewById(R.id.tvPedidoPreco);
        tvPedidoResposta = findViewById(R.id.tvPedidoResposta);
        llPedidoFeedback = findViewById(R.id.llPedidoFeedback);
        llPedidoCabecalho = findViewById(R.id.llPedidoCabecalho);
        bPedidoDarFeedback = findViewById(R.id.bPedidoDarFeedback);
        llPedidoResposta = findViewById(R.id.llPedidoResposta);
        llPedidoPreco = findViewById(R.id.llPedidoPreco);

        Intent it = getIntent();
        if (it != null) {
            if (it.hasExtra("idPedido")) {
                idServico = it.getIntExtra("idPedido", 0);
                PreencheDados();
            }
        }

        bPedidoDarFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ConsisteCampos()) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if (informacoesApp.conexaoController.darFeedback(idServico, Integer.parseInt(etPedidoNota.getText().toString()), etPedidoAvaliacao.getText().toString())) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(informacoesApp, "Feedback dado com sucesso", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                PreencheDados();
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(informacoesApp, "Erro ao dar feedback", Toast.LENGTH_SHORT).show();
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

    private void PreencheDados(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                servico = informacoesApp.conexaoController.getServicoPorCod(idServico);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (servico.getSituacao() == 'C'){
                            etPedidoNota.setEnabled(false);
                            etPedidoAvaliacao.setEnabled(false);
                            bPedidoDarFeedback.setEnabled(false);

                            etPedidoNota.setText(String.valueOf(servico.getNota()));
                            etPedidoAvaliacao.setText(servico.getAvaliacao());
                        } else if (servico.getSituacao() == 'E' || servico.getSituacao() == 'N') {
                            llPedidoFeedback.setVisibility(View.GONE);
                        }

                        tvPedidoAutonomoNome.setText(servico.getAutonomo().getNome());
                        tvPedidoSituacao.setText(servico.getSituacaoLiteral());

                        if (servico.getAutonomo().getFoto() != null) {
                            Bitmap bitmapImage = BitmapFactory.decodeByteArray(servico.getAutonomo().getFoto(), 0, servico.getAutonomo().getFoto().length);
                            ivPedidoAutonomoFoto.setImageBitmap(bitmapImage);
                        }

                        String data = Funcoes.dateSqlToNormal(servico.getDataHoraQua().substring(0, 10));
                        String hora = servico.getDataHoraQua().substring(11, 16);

                        tvPedidoQuando.setText(data + " " + hora);

                        tvPedidoDescricao.setText(servico.getDescricao());
                        if (servico.getSituacao() != 'E') {
                            tvPedidoResposta.setText(servico.getResposta());
                        } else {
                            llPedidoResposta.setVisibility(View.GONE);
                        }

                        if (servico.getSituacao() != 'E' && servico.getSituacao() != 'N') {
                            tvPedidoPreco.setText("R$ " + servico.getPreco());
                        } else {
                            llPedidoPreco.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });
        thread.start();
    }

    public boolean ConsisteCampos() {
        if (etPedidoNota.getText().toString().equals("")){
            etPedidoNota.setError("Informe uma nota.");
            etPedidoNota.requestFocus();
            return false;
        }
        if (etPedidoAvaliacao.getText().toString().equals("")){
            etPedidoAvaliacao.setError("Informe uma avaliação.");
            etPedidoAvaliacao.requestFocus();
            return false;
        }

        return true;
    }
}
