package com.example.alexandre.myapplication.TelasListas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.alexandre.myapplication.TelasCadastros.CadastroFuncionario;
import com.example.alexandre.myapplication.TelasEditarRemover.EditarRemoverFuncionario;
import com.example.alexandre.myapplication.R;


public class ListarFuncionario extends AppCompatActivity {

    private SQLiteDatabase db;
    private SimpleCursorAdapter adt = null;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarfuncionario);

        //Criar o banco de dados
        db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        String funcionarios = "CREATE TABLE IF NOT EXISTS FUNCIONARIO (_id INTEGER PRIMARY KEY autoincrement, " +
                "NOME VARCHAR(50), CPF VARCHAR(11), RG VARCHAR(10), ENDERECO VARCHAR(50), CARGO VARCHAR(20), DATA VARCHAR(30))";

        db.execSQL(funcionarios);



        final Button btAtualizar = (Button) findViewById(R.id.btCadastrar);
        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), CadastroFuncionario.class));
            }
        });

        final EditText txtBusca = (EditText) findViewById(R.id.txtBusca);
        txtBusca.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Prencher o ListView
                String[] busca = new String[]{"%" + txtBusca.getText().toString() + "%"};
                Cursor cursor = db.query("FUNCIONARIO", new String[]{"_id", "NOME", "RG", "CPF", "ENDERECO", "CARGO", "DATA"}, "NOME LIKE ?", busca, null, null, "_id ASC", null);
                adt.changeCursor(cursor);


                ListView listaDados = (ListView) findViewById(R.id.listarFuncionario);
                listaDados.setAdapter(adt);
                return false;
            }
        });

    }
    @Override
    public void onResume(){
        super.onResume();
        //Prencher o ListView
        Cursor cursor = db.query("FUNCIONARIO", new String[]{"_id", "NOME", "RG", "CPF", "ENDERECO", "CARGO", "DATA"}, null, null, null, null, "_id ASC", null);
        String[] campos = {"_id", "NOME", "RG", "CPF", "ENDERECO", "CARGO", "DATA"};
        int[] ids = {R.id.tvId, R.id.tvNome, R.id.tvRg, R.id.tvCpf, R.id.tvEndereco, R.id.tvCargo,R.id.tvData};
        adt = new SimpleCursorAdapter(getBaseContext(), R.layout.modelo_funcionario, cursor, campos, ids, 0);
        ListView listaDados = (ListView) findViewById(R.id.listarFuncionario);
        listaDados.setAdapter(adt);


        listaDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor retornoCursor = (Cursor) adt.getItem(position);
                Intent it = new Intent(getBaseContext(), EditarRemoverFuncionario.class);
                it.putExtra("Codigo", retornoCursor.getInt(0));
                it.putExtra("Nome", retornoCursor.getString(1));
                it.putExtra("Rg", retornoCursor.getString(2));
                it.putExtra("Cpf", retornoCursor.getString(3));
                it.putExtra("Endereco", retornoCursor.getString(4));
                it.putExtra("Cargo", retornoCursor.getFloat(5));
                it.putExtra("Data", retornoCursor.getString(6));
                startActivity(it);

            }
        });
    }

    public void acaoSair(View view){
        finish();
    }
}