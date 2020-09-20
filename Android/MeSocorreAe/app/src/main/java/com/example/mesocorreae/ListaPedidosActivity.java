package com.example.mesocorreae;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import modelDominio.Servico;

public class ListaPedidosActivity extends AppCompatActivity {
    ArrayList<Servico> listaPedidos;
    InformacoesApp informacoesApp;
    RecyclerView rvListaPedidosListaPedidos;
    PedidoAdapter pedidoAdapter;
    TextView tvListaPedidosSemLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();
        tvListaPedidosSemLista = findViewById(R.id.tvListaPedidosSemLista);
        rvListaPedidosListaPedidos = findViewById(R.id.rvListaPedidosListaPedidos);

        atualizaDados();
    }

    private void atualizaDados(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                listaPedidos = informacoesApp.conexaoController.getListaServicos(informacoesApp.usuarioLogado.getCpf()); //recebe a lista de serviços

                if (listaPedidos != null && !listaPedidos.isEmpty()) {//Validando se a lista não ta vazia
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvListaPedidosSemLista.setVisibility(View.GONE);

                            pedidoAdapter = new PedidoAdapter(listaPedidos, trataCliqueItem);
                            rvListaPedidosListaPedidos.setLayoutManager(new LinearLayoutManager(ListaPedidosActivity.this));
                            rvListaPedidosListaPedidos.setItemAnimator(new DefaultItemAnimator());
                            rvListaPedidosListaPedidos.setAdapter(pedidoAdapter);
                        }
                    });
                }else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvListaPedidosSemLista.setVisibility(View.VISIBLE);
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

    PedidoAdapter.ServicoOnClickListener trataCliqueItem = new PedidoAdapter.ServicoOnClickListener() {
        @Override
        public void onClickServico(View view, int position) {
            Servico meuPedido = listaPedidos.get(position);
            Intent it = new Intent(ListaPedidosActivity.this, PedidoActivity.class);
            it.putExtra("idPedido", meuPedido.getCod());
            startActivity(it);
        }
    };
}
