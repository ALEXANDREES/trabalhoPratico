package com.example.alexandre.myapplication.TelasCadastros;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexandre.myapplication.R;

public class CadastroMelhoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastroveiculo);
        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etFuncionario = findViewById(R.id.etNome);
                EditText etMelhoria = findViewById(R.id.etMarca);
                EditText etDepartamento = findViewById(R.id.etCor);


                if (!etFuncionario.getText().toString().isEmpty() && !etMelhoria.getText().toString().isEmpty() && !etDepartamento.getText().toString().isEmpty()) {

                    @SuppressLint("WrongConstant") SQLiteDatabase db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                    ContentValues ctv = new ContentValues();
                    ctv.put("FUNCIONARIO", etFuncionario.getText().toString());
                    ctv.put("MELHORIA", etMelhoria.getText().toString());
                    ctv.put("DEPARTAMENTO", etDepartamento.getText().toString());



                    db.insert("MELHORIA", "id", ctv);
                    Toast.makeText(getBaseContext(), " Melhoria Cadastrada", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Alguns campos estão em branco.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void acaoSair(View view){
        finish();
    }
}
