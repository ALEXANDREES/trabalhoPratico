package com.example.alexandre.myapplication.TelasCadastros;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexandre.myapplication.R;

public class CadastroVeiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastroveiculo);
        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etPlaca = findViewById(R.id.etPlaca);
                EditText etNome = findViewById(R.id.etNome);
                EditText etMarca = findViewById(R.id.etMarca);
                EditText etModelo = findViewById(R.id.etModelo);
                EditText etSeguro = findViewById(R.id.etSeguro);
                EditText etLocacao = findViewById(R.id.etLocacao);
                EditText etAtivo = findViewById(R.id.etAtivo);
                EditText etCor = findViewById(R.id.etCor);






                if (!etPlaca.getText().toString().isEmpty() && !etNome.getText().toString().isEmpty() && !etMarca.getText().toString().isEmpty()
                        && !etModelo.getText().toString().isEmpty() && !etSeguro.getText().toString().isEmpty()  && !etLocacao.getText().toString().isEmpty()
                        && !etAtivo.getText().toString().isEmpty() )  {

                    @SuppressLint("WrongConstant") SQLiteDatabase db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                    ContentValues ctv = new ContentValues();
                    ctv.put("PLACA", etPlaca.getText().toString());
                    ctv.put("NOME", etNome.getText().toString());
                    ctv.put("MARCA", etMarca.getText().toString());
                    ctv.put("MODELO", etModelo.getText().toString());
                    ctv.put("VSEGURO", etSeguro.getText().toString());
                    ctv.put("VLOCACAO", etLocacao.getText().toString());
                    ctv.put("ATIVO", etAtivo.getText().toString());
                    ctv.put("COR", etCor.getText().toString());



                    db.insert("VEICULOS", "id", ctv);
                    Toast.makeText(getBaseContext(), " Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), " Campos em branco não é possivel cadastrar!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void acaoSair(View view){
        finish();
    }
}
