package com.example.mesocorreae;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import factory.Funcoes;
import modelDominio.Categoria;

public class PrincipalActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    InformacoesApp informacoesApp;
    ArrayList<Categoria> listaCategorias;

    Button bPrincipalBuscar;
    TextView tvPrincipalSemLista;
    EditText etPrincipalPesquisa;
    RecyclerView rvPrincipalCategorias;
    CategoriaAdapter categoriaAdapter;

    TextView menuNomeUsuario, menuCpfUsuario;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);

        informacoesApp = (InformacoesApp) getApplicationContext();

        rvPrincipalCategorias = findViewById(R.id.rvPrincipalCategorias);
        bPrincipalBuscar = findViewById(R.id.bPrincipalBuscar);
        etPrincipalPesquisa = findViewById(R.id.etPrincipalPesquisa);
        tvPrincipalSemLista = findViewById(R.id.tvPrincipalSemLista);

        menuNomeUsuario = header.findViewById(R.id.menuNomeUsuario);
        menuCpfUsuario = header.findViewById(R.id.menuCpfUsuario);

        menuNomeUsuario.setText(informacoesApp.usuarioLogado.getNome());
        menuCpfUsuario.setText(Funcoes.formataCpf(informacoesApp.usuarioLogado.getCpf()));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                listaCategorias = informacoesApp.conexaoController.getListaCategorias();
                if (listaCategorias != null && !listaCategorias.isEmpty()) {//Validando se a lista não ta vazia

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvPrincipalSemLista.setVisibility(View.GONE);

                            categoriaAdapter = new CategoriaAdapter(listaCategorias, trataCliqueCategoria);
                            rvPrincipalCategorias.setLayoutManager(new LinearLayoutManager(PrincipalActivity.this));
                            rvPrincipalCategorias.setItemAnimator(new DefaultItemAnimator());
                            rvPrincipalCategorias.setAdapter(categoriaAdapter);
                        }
                    });
                } else {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvPrincipalSemLista.setVisibility(View.VISIBLE);
                        }
                    });

                }
            }
        });
        thread.start();

        bPrincipalBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        listaCategorias = informacoesApp.conexaoController.getListaCategoriasFiltro(
                                etPrincipalPesquisa.getText().toString());

                        if (listaCategorias != null) {

                            if (listaCategorias.isEmpty()) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tvPrincipalSemLista.setVisibility(View.VISIBLE);
                                    }
                                });
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tvPrincipalSemLista.setVisibility(View.GONE);
                                    }
                                });
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    categoriaAdapter = new CategoriaAdapter(listaCategorias, trataCliqueCategoria);
                                    rvPrincipalCategorias.setLayoutManager(new LinearLayoutManager(PrincipalActivity.this));
                                    rvPrincipalCategorias.setItemAnimator(new DefaultItemAnimator());
                                    rvPrincipalCategorias.setAdapter(categoriaAdapter);
                                }
                            });
                        }
                    }
                });
                thread.start();
            }
        });
    }

    CategoriaAdapter.CategoriaOnClickListener trataCliqueCategoria = new CategoriaAdapter.CategoriaOnClickListener() {
        @Override
        public void onClickCategoria(View view, int position) {
            Intent it = new Intent(PrincipalActivity.this, ListaAutonomosActivity.class);
            it.putExtra("categoria", listaCategorias.get(position));
            startActivity(it);
        }
    };

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch (menuItem.getItemId()) {
            case R.id.nav_logoff: {
                informacoesApp.usuarioLogado = null;
                Intent it = new Intent(PrincipalActivity.this, LoginActivity.class);
                startActivity(it);
                finish();
                return true;
            }
            case R.id.nav_alterar_senha: {
                Intent it = new Intent(PrincipalActivity.this, AlterarSenhaActivity.class);
                startActivity(it);
                return true;
            }
            case R.id.nav_meus_pedidos: {
                Intent it = new Intent(PrincipalActivity.this, ListaPedidosActivity.class);
                startActivity(it);
                return true;
            }
            case R.id.nav_editar_perfil: {
                Intent it = new Intent(PrincipalActivity.this, EditarPerfilActivity.class);
                startActivity(it);
                return true;
            }
            default: {
                return false;
            }
        }
    }

}
