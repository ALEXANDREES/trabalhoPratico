package com.example.alexandre.myapplication.TelasEditarRemover;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexandre.myapplication.R;

public class EditarRemoverLocacao extends AppCompatActivity{

    private SQLiteDatabase db;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarremoverlocacao);

        db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        final Intent it = getIntent();

        final EditText editDataLocacao = (EditText) findViewById(R.id.etDataLocacao);
        final EditText editCliente = (EditText) findViewById(R.id.etCliente);
        final EditText editVeiculo = (EditText) findViewById(R.id.etVeiculo);
        final EditText editStatus = (EditText) findViewById(R.id.etStatus);

        editDataLocacao.setText(it.getStringExtra("DATALOCACAO"));
        editCliente.setText(it.getStringExtra("CLIENTE"));
        editVeiculo.setText(it.getStringExtra("VEICULO"));
        editStatus.setText(it.getStringExtra("STATUS"));

        Button btExcluir = (Button) findViewById(R.id.btExcluir);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.delete("LOCACAO", "_id = ?", new String[]{String.valueOf(it.getIntExtra("Codigo", 0))}) > 0){
                    Toast.makeText(getBaseContext(), "Locação excluida com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btAtualizar = (Button) findViewById(R.id.btAtualizar);
        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues ctv = new ContentValues();
                ctv.put("DATALOCACAO", editDataLocacao.getText().toString());
                ctv.put("CLIENTE", editCliente.getText().toString());
                ctv.put("VEICULO", editVeiculo.getText().toString());
                if ( db.update("LOCACAO", ctv, "_id = ?", new String[]{String.valueOf(it.getIntExtra("Codigo", 0))}) > 0){
                    Toast.makeText(getBaseContext(), "Locação atualizada com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });


        Button btEncerrarLoca = (Button) findViewById(R.id.btEncerrarLoca);
        btEncerrarLoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), EncerrarLocacao.class));
            }
        });

    }

    public void acaoSair(View view){
        finish();
    }
}
