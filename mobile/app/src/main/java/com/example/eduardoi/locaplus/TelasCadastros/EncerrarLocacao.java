package com.example.eduardoi.locaplus.TelasCadastros;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.R;

public class EncerrarLocacao extends AppCompatActivity{

    Banco bd;
    private SQLiteDatabase conexao;

    private EditText editDataEncerramento;
    private EditText editKm;
    //private EditText editCliente;

    String status;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encerrarlocacao);

        conexaoBD();

        final Intent it = getIntent();

        editDataEncerramento = findViewById(R.id.etDataEncerramento);
        editKm = findViewById(R.id.etQuilometragem);
        status = "ENCERRADA";

        editDataEncerramento.setText(it.getStringExtra("dataencerramento"));
        editKm.setText(it.getStringExtra("km"));



        Button btEncerrar = (Button) findViewById(R.id.btEncerrar);
        btEncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexao = bd.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("DATAENCERRAMENTO", editDataEncerramento.getText().toString());
                values.put("KM", editKm.getText().toString());
                values.put("STATUS", status);

                if (conexao.update("LOCACAO", values, "ID = ?", new String[]{String.valueOf(it.getIntExtra("id", 0))}) > 0) {
                    conexao.close();
                    Toast.makeText(getBaseContext(), "Locação encerrada com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Erro ao encerrar a locação!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void conexaoBD() {
        try {
            bd = new Banco(this);
            Toast.makeText(this, "Conexão Ok!", Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("Erro");
            msg.setMessage("Erro ao conectar ao Banco");
            msg.setNeutralButton("Ok",null);
            msg.show();
        }
    }

    public void acaoSair (View view){
        finish();
    }

}
