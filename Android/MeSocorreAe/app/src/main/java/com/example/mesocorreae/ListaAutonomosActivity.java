package com.example.mesocorreae;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import modelDominio.Autonomo;
import modelDominio.Categoria;

public class ListaAutonomosActivity extends AppCompatActivity {
    InformacoesApp informacoesApp;
    RecyclerView rvListaAutonomosListaAutonomos;
    AutonomoAdapter autonomoAdapter;
    ArrayList<Autonomo> listaAutonomos;
    TextView tvListaAutonomoSemLista;
    int idCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_autonomos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();
        tvListaAutonomoSemLista = findViewById(R.id.tvListaAutonomoSemLista);
        rvListaAutonomosListaAutonomos = findViewById(R.id.rvListaAutonomosListaAutonomos);

        Intent it = getIntent();
        if (it != null) {
            if (it.hasExtra("categoria")) {
                //setando o nome da tela - na tela ele poe o nome da categoria
                this.setTitle(((Categoria)it.getSerializableExtra("categoria")).getNome());

                idCategoria = ((Categoria)it.getSerializableExtra("categoria")).getId();
                atualizaDados();
            }
        }
    }

    private void atualizaDados() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                listaAutonomos = informacoesApp.conexaoController.getListaAutonomos(idCategoria, informacoesApp.usuarioLogado.getCpf());

                if (listaAutonomos != null && !listaAutonomos.isEmpty()) {//Validando se a lista não ta vazia

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvListaAutonomoSemLista.setVisibility(View.GONE);

                            autonomoAdapter = new AutonomoAdapter(listaAutonomos, trataCliqueItem);
                            rvListaAutonomosListaAutonomos.setLayoutManager(new LinearLayoutManager(ListaAutonomosActivity.this));
                            rvListaAutonomosListaAutonomos.setItemAnimator(new DefaultItemAnimator());
                            rvListaAutonomosListaAutonomos.setAdapter(autonomoAdapter);
                        }
                    });

                }else {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvListaAutonomoSemLista.setVisibility(View.VISIBLE);
                        }
                    });

                }
            }
        });
        thread.start();
    }

    @Override
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
        if (id == R.id.bFlutuaAtualizaLista) {
            atualizaDados();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    AutonomoAdapter.AutonomoOnClickListener trataCliqueItem = new AutonomoAdapter.AutonomoOnClickListener() {
        @Override
        public void onClickAutonomo(View view, int position) {
            Intent it = new Intent(ListaAutonomosActivity.this, PerfilActivity.class);
            it.putExtra("idAutonomo", listaAutonomos.get(position).getCpf());
            startActivity(it);
        }
    };

}
