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

import com.example.alexandre.myapplication.R;
import com.example.alexandre.myapplication.TelasCadastros.CadastroVeiculo;
import com.example.alexandre.myapplication.TelasEditarRemover.EditarRemoverLocacao;

public class listarveiculos extends AppCompatActivity {
    private SQLiteDatabase db;
    private SimpleCursorAdapter adt = null;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarveiculos);


        db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        String veiculos = "CREATE TABLE IF NOT EXISTS VEICULOS (_id INTEGER PRIMARY KEY autoincrement, " +
                "PLACA VARCHAR(10), NOME VARCHAR(50), MARCA VARCHAR(30), MODELO VARCHAR(10), VSEGURO FLOAT, VLOCACAO FLOAT, ATIVO VARCHAR(10)," +
               " COR VARCHAR(10))";

        db.execSQL(veiculos);


        final EditText etPesquisar = (EditText) findViewById(R.id.etPesquisar);
        etPesquisar.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Prencher o ListView
                String[] busca = new String[]{"%" + etPesquisar.getText().toString() + "%"};
                Cursor cursor = db.query("VEICULOS", new String[]{"_id", "PLACA", "NOME", "MARCA", "MODELO", "VSEGURO", "VLOCACAO", "ATIVO", "COR"}, "PLACA LIKE ?", busca, null, null, "_id ASC", null);
                adt.changeCursor(cursor);


                ListView listaDados = (ListView) findViewById(R.id.listarVeiculos);
                listaDados.setAdapter(adt);
                return false;

            }
        });


        final Button btCadastrar = (Button) findViewById(R.id.btCadastro);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), CadastroVeiculo.class));
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        //Prencher o ListView
        Cursor cursor = db.query("VEICULOS", new String[]{"_id", "PLACA", "NOME", "MARCA", "MODELO", "VSEGURO", "VLOCACAO", "ATIVO", "COR"}, null, null, null, null, "_id ASC", null);
        String[] campos = {"_id", "PLACA", "NOME", "MARCA", "MODELO", "VSEGURO", "VLOCACAO", "ATIVO", "COR"};
        int[] ids = {R.id.tvId, R.id.tvPlaca, R.id.tvFuncionario, R.id.tvMelhoria, R.id.tvDepartamento, R.id.tvSeguro,R.id.tvLocacao,R.id.tvAtivo,R.id.tvCor};
        adt = new SimpleCursorAdapter(getBaseContext(), R.layout.modelo_veiculos, cursor, campos, ids, 0);
        ListView listaDados = (ListView) findViewById(R.id.listarVeiculos);
        listaDados.setAdapter(adt);


        listaDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor retornoCursor = (Cursor) adt.getItem(position);
                Intent it = new Intent(getBaseContext(), EditarRemoverLocacao.class); // aquiiiiii
                it.putExtra("Codigo", retornoCursor.getInt(0));
                it.putExtra("Nome", retornoCursor.getString(1));
                it.putExtra("Placa", retornoCursor.getString(2));
                it.putExtra("Marca", retornoCursor.getString(3));
                it.putExtra("Modelo", retornoCursor.getString(4));
                it.putExtra("Valor Seguro", retornoCursor.getFloat(5));
                it.putExtra("Valor Locação", retornoCursor.getFloat(6));
                it.putExtra("Ativo", retornoCursor.getString(7));
                it.putExtra("Cor", retornoCursor.getString(8));

                startActivity(it);

            }
        });
    }

    public void acaoSair(View view){
        finish();
    }

}
