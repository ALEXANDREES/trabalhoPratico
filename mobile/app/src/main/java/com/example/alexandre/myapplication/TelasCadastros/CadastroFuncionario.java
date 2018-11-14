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


public class CadastroFuncionario extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrofuncionario);

        Button btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etNome = findViewById(R.id.etNome);
                EditText etRg = findViewById(R.id.etRg);
                EditText etCpf = findViewById(R.id.etCpf);
                EditText etEndereco = findViewById(R.id.etEndereco);
                EditText etCargo = findViewById(R.id.etCargo);
                EditText etData = findViewById(R.id.etData);


                if (!etData.getText().toString().isEmpty() && !etCargo.getText().toString().isEmpty() && !etEndereco.getText().toString().isEmpty()
                        && !etCpf.getText().toString().isEmpty() && !etRg.getText().toString().isEmpty() && !etNome.getText().toString().isEmpty()) {

                    @SuppressLint("WrongConstant") SQLiteDatabase db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                    ContentValues ctv = new ContentValues();
                    ctv.put("NOME", etNome.getText().toString());
                    ctv.put("RG", etRg.getText().toString());
                    ctv.put("CPF", etCpf.getText().toString());
                    ctv.put("ENDERECO", etEndereco.getText().toString());
                    ctv.put("CARGO", etCargo.getText().toString());
                    ctv.put("DATA", etData.getText().toString());


                    db.insert("FUNCIONARIO", "id", ctv);
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
