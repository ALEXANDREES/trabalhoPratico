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

public class EncerrarLocacao extends AppCompatActivity{

    private SQLiteDatabase db;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encerrarlocacao);

        /*db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        final Intent it = getIntent();

        final EditText editDataEncerramento = (EditText) findViewById(R.id.etDataEncerramento);
        final EditText editKm = (EditText) findViewById(R.id.etQuilometragem);
        final EditText editStatus = (EditText) findViewById(R.id.etStatus);

        editDataEncerramento.setText(it.getStringExtra("DATAENCERRAMENTO"));
        editKm.setText(it.getStringExtra("KM"));
        editStatus.setText(it.getStringExtra("STATUS"));

        final Button btEncerrar = (Button) findViewById(R.id.button4);
        btEncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues ctv = new ContentValues();
                ctv.put("DATAENCERRAMENTO", editDataEncerramento.getText().toString());
                ctv.put("KM", editKm.getText().toString());
                ctv.put("STATUS", "ENCERRADA");
                if (db.update("LOCACAO", ctv, "_id = ?", new String[]{String.valueOf(it.getIntExtra("Codigo", 0))}) > 0) {
                    Toast.makeText(getBaseContext(), "Locação encerrada com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });*/

        final Button btEncerrar = (Button) findViewById(R.id.button4);
        btEncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

                final Intent it = getIntent();

                final EditText editDataEncerramento = (EditText) findViewById(R.id.etDataEncerramento);
                final EditText editKm = (EditText) findViewById(R.id.etQuilometragem);
                final EditText editStatus = (EditText) findViewById(R.id.etStatus);

                editDataEncerramento.getText();
                editKm.getText();

                ContentValues ctv = new ContentValues();
                ctv.put("DATAENCERRAMENTO", editDataEncerramento.getText().toString());
                ctv.put("KM", editKm.getText().toString());
                ctv.put("STATUS", "ENCERRADA");
                //ELE NÃO PEGA O ID DA LISTA PARA FAZER O UPDATE
                if (db.update("LOCACAO", ctv, "_id = ?", new String[]{String.valueOf(it.getIntExtra("Codigo", 0))}) > 0) {
                    Toast.makeText(getBaseContext(), "Locação encerrada com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    public void acaoSair (View view){
        finish();
    }

   /* @SuppressLint("WrongConstant")
    public void acaoEncerrar(View view){

        db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        final Intent it = getIntent();

        final EditText editDataEncerramento = (EditText) findViewById(R.id.etDataEncerramento);
        final EditText editKm = (EditText) findViewById(R.id.etQuilometragem);
        final EditText editStatus = (EditText) findViewById(R.id.etStatus);

        editDataEncerramento.getText();
        editKm.getText();

        ContentValues ctv = new ContentValues();
        ctv.put("DATAENCERRAMENTO", editDataEncerramento.getText().toString());
        ctv.put("KM", editKm.getText().toString());
        ctv.put("STATUS", "ENCERRADA");
        //ELE NÃO PEGA O ID DA LISTA PARA FAZER O UPDATE
        if (db.update("LOCACAO", ctv, "_id = ?", new String[]{String.valueOf(it.getIntExtra("Codigo", 0))}) > 0) {
            Toast.makeText(getBaseContext(), "Locação encerrada com sucesso!!!", Toast.LENGTH_SHORT).show();
            finish();
        }

    }*/
}
