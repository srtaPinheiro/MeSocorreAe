package com.example.mesocorreae;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import modelDominio.Autonomo;
import modelDominio.Servico;

public class PerfilActivity extends AppCompatActivity {
    InformacoesApp informacoesApp;
    Button bPerfilSolicitar;
    TextView tvPerfilNome, tvPerfilNota, tvPerfilDescricao, tvPerfilSemLista;
    RecyclerView rvPerfilElogios, rvPerfilImagemServicos;
    ImageView ivPerfilFoto;
    long idAutonomo;
    Autonomo autonomo;
    ArrayList<Servico> avaliacoesServicos;
    ElogioAdapter elogioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();

        tvPerfilNome = findViewById(R.id.tvPerfilNome);
        tvPerfilNota = findViewById(R.id.tvPerfilNota);
        tvPerfilDescricao = findViewById(R.id.tvPerfilDescricao);
        rvPerfilElogios = findViewById(R.id.rvPerfilElogios);
        bPerfilSolicitar = findViewById(R.id.bPerfilSolicitar);
        ivPerfilFoto = findViewById(R.id.ivPerfilFoto);
        tvPerfilSemLista = findViewById(R.id.tvPerfilSemLista);

        Intent it = getIntent(); //recebe a intent da outra tela
        if (it != null) {
            if (it.hasExtra("idAutonomo")) {
                idAutonomo = it.getLongExtra("idAutonomo", 0);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        autonomo = (Autonomo) informacoesApp.conexaoController.getUsuarioCompleto(idAutonomo);
                        avaliacoesServicos = informacoesApp.conexaoController.getAvaliacoesAutonomo(idAutonomo);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvPerfilNome.setText(autonomo.getNome());
                                tvPerfilDescricao.setText(autonomo.getDescricao());
                                tvPerfilNota.setText(String.valueOf(autonomo.getAvaliacao()));

                                if (autonomo.getFoto() != null) {
                                    Bitmap bitmapImage = BitmapFactory.decodeByteArray(autonomo.getFoto(), 0, autonomo.getFoto().length);
                                    ivPerfilFoto.setImageBitmap(bitmapImage);
                                }
                            }
                        });

                        if (avaliacoesServicos != null && !avaliacoesServicos.isEmpty()) { //Validando se a lista não ta vazia

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvPerfilSemLista.setVisibility(View.GONE);

                                    elogioAdapter = new ElogioAdapter(avaliacoesServicos, trataCliqueElogio);
                                    rvPerfilElogios.setLayoutManager(new LinearLayoutManager(PerfilActivity.this));
                                    rvPerfilElogios.setItemAnimator(new DefaultItemAnimator());
                                    rvPerfilElogios.setAdapter(elogioAdapter);
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvPerfilSemLista.setVisibility(View.VISIBLE);
                                }
                            });
                        }
                    }
                });
                thread.start();
            }
        }

        bPerfilSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PerfilActivity.this, SolicitacaoActivity.class);
                it.putExtra("autonomo", autonomo);
                startActivity(it);
            }
        });

    }

    ElogioAdapter.ElogioOnClickListener trataCliqueElogio = new ElogioAdapter.ElogioOnClickListener() {
        @Override
        public void onClickElogio(View view, int position) {

        }
    };

}
