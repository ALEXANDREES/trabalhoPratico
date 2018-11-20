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

public class CadastroCliente extends AppCompatActivity
{

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastrocliente);

        Button btSalvar = (Button) findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                EditText etNome = findViewById(R.id.etNome);
                EditText etRG = findViewById(R.id.etRG);
                EditText etCPF = findViewById(R.id.etCPF);
                EditText etEndereco = findViewById(R.id.etEndereco);
                EditText etN_Dependentes = findViewById(R.id.etN_Dependentes);


                    if (!etNome.getText().toString().isEmpty() && !etRG.getText().toString().isEmpty() && !etCPF.getText().toString().isEmpty() && !etEndereco.getText().toString().isEmpty() && !etN_Dependentes.getText().toString().isEmpty() ) {

                            @SuppressLint("WrongConstant") SQLiteDatabase db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

                            ContentValues ctv = new ContentValues();

                            ctv.put("NOME", etNome.getText().toString());
                            ctv.put("RG", etRG.getText().toString());
                            ctv.put("CPF", etCPF.getText().toString());
                            ctv.put("ENDERECO", etEndereco.getText().toString());
                            ctv.put("NDEPENDENTES", etN_Dependentes.getText().toString());

                            db.insert("CLIENTE", "id", ctv);

                            Toast.makeText(getBaseContext(), " Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();

                            finish();
                    }

                    else

                            Toast.makeText(getBaseContext(), " Campos em branco não é possivel cadastrar!!!", Toast.LENGTH_SHORT).show();
                }
            }
        );
    }

    public void acaoSair(View view)

        {
            finish();
        }
}
