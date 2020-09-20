package com.example.mesocorreae;

import android.app.Application;
import controller.ConexaoController;
import modelDominio.Usuario;

public class InformacoesApp extends Application {
    public Usuario usuarioLogado;
    public ConexaoController conexaoController;

    @Override
    public void onCreate() {
        super.onCreate();
        conexaoController = new ConexaoController();
    }
}
