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

public class EditarRemoverFuncionario extends AppCompatActivity{

    private SQLiteDatabase db;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarremoverfuncionario);

        db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        final Intent it = getIntent();

        final EditText editNome = (EditText) findViewById(R.id.etNome);
        final EditText editRg = (EditText) findViewById(R.id.etRg);
        final EditText editCpf = (EditText) findViewById(R.id.etCpf);
        final EditText editCargo = (EditText) findViewById(R.id.etCargo);
        final EditText editEndereco = (EditText) findViewById(R.id.etEndereco);

        editNome.setText(it.getStringExtra("NOME"));
        editRg.setText(it.getStringExtra("RG"));
        editCpf.setText(it.getStringExtra("CPF"));
        editCargo.setText(it.getStringExtra("CARGO"));
        editEndereco.setText(it.getStringExtra("ENDERECO"));

        Button btExcluir = (Button) findViewById(R.id.btExcluir);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.delete("FUNCIONARIO", "_id = ?", new String[]{String.valueOf(it.getIntExtra("Codigo", 0))}) > 0){
                    Toast.makeText(getBaseContext(), "Funcionario excluido com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btAtualizar = (Button) findViewById(R.id.btAtualizar);
        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues ctv = new ContentValues();
                ctv.put("NOME", editNome.getText().toString());
                ctv.put("RG", editRg.getText().toString());
                ctv.put("CPF", editCpf.getText().toString());
                ctv.put("CARGO", editCargo.getText().toString());
                ctv.put("ENDERECO", editEndereco.getText().toString());
                if ( db.update("FUNCIONARIO", ctv, "_id = ?", new String[]{String.valueOf(it.getIntExtra("Codigo", 0))}) > 0){
                    Toast.makeText(getBaseContext(), "Funcionario atualizado com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });




    }

    public void acaoSair(View view){
        finish();
    }
}
