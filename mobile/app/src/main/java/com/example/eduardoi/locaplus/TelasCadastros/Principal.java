package com.example.eduardoi.locaplus.TelasCadastros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.eduardoi.locaplus.R;
import com.example.eduardoi.locaplus.TelasListas.ListarClientes;
import com.example.eduardoi.locaplus.TelasListas.ListarLocacao;
import com.example.eduardoi.locaplus.TelasListas.ListarMelhoria;
import com.example.eduardoi.locaplus.TelasListas.ListarVeiculos;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void acaoLocacao(View view){
        Intent it = new Intent(Principal.this, ListarLocacao.class);
        startActivity(it);
    }

    public void acaoClientes(View view){
        Intent it = new Intent(Principal.this, ListarClientes.class);
        startActivity(it);
    }

    public void acaoVeiculos(View view){
        Intent it = new Intent(Principal.this, ListarVeiculos.class);
        startActivity(it);
    }

    public void acaoMelhoria(View view){
        Intent it = new Intent(Principal.this, ListarMelhoria.class);
        startActivity(it);
    }

}
