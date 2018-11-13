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

public class CadastrarLocacao extends AppCompatActivity {

    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrolocacao);

        Button btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etDataInicial = findViewById(R.id.etDataLocacao);
                EditText etCliente = findViewById(R.id.etCliente);
                EditText etVeiculo = findViewById(R.id.etVeiculo);
                EditText etStatus = findViewById(R.id.etStatus);
                etStatus.setText("ATIVA");


                if (!etDataInicial.getText().toString().isEmpty() && !etCliente.getText().toString().isEmpty() && !etVeiculo.getText().toString().isEmpty()) {

                    @SuppressLint("WrongConstant") SQLiteDatabase db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                    ContentValues ctv = new ContentValues();
                    ctv.put("DATALOCACAO", etDataInicial.getText().toString());
                    ctv.put("CLIENTE", etCliente.getText().toString());
                    ctv.put("VEICULO", etVeiculo.getText().toString());
                    ctv.put("STATUS", etStatus.getText().toString());

                    db.insert("LOCACAO", "id", ctv);
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
