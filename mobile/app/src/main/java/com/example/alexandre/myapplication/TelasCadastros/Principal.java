package com.example.alexandre.myapplication.TelasCadastros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.alexandre.myapplication.R;
import com.example.alexandre.myapplication.TelasListas.ListarLocacao;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        final Button btLocacao = (Button) findViewById(R.id.btLocacao);
        btLocacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ListarLocacao.class));
            }
        });
    }
}


