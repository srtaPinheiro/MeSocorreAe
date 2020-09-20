package com.example.mesocorreae;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Handler;

public class MainActivity extends AppCompatActivity implements Runnable {
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Handler handler = new Handler();
        handler.postDelayed(this,3000);
    }

    public void run() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (informacoesApp.conexaoController.conectar()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent it = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(it);
                            finish();
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.this);
                            dlgAlert.setMessage("A conexão com o servidor falhou. O aplicativo será encerrado.");
                            dlgAlert.setTitle("Falha na conexão");
                            dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
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
