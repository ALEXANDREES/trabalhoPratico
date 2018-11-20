package com.example.alexandre.myapplication.TelasListas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.alexandre.myapplication.R;
import com.example.alexandre.myapplication.TelasCadastros.CadastroMelhoria;
import com.example.alexandre.myapplication.TelasEditarRemover.EditarRemoverMelhoria;

//import com.example.alexandre.myapplication.TelasEditarRemover.;

public class ListarMelhoria extends AppCompatActivity {
    private SQLiteDatabase db;
    private SimpleCursorAdapter adt = null;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarmelhoria);


        db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        String melhoria = "CREATE TABLE IF NOT EXISTS MELHORIA (_id INTEGER PRIMARY KEY autoincrement, " +
                "FUNCIONARIO VARCHAR(10), MELHORIA VARCHAR(50), DEPARTAMENTO VARCHAR(30))";

        db.execSQL(melhoria);


        final EditText etPesquisar = (EditText) findViewById(R.id.etPesquisar);
        etPesquisar.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Prencher o ListView
                String[] busca = new String[]{"%" + etPesquisar.getText().toString() + "%"};

                //
                //
                //ANALIZAR O QUE NAO PRECISA
                //
                //
                Cursor cursor = db.query("MELHORIA", new String[]{"_id", "FUNCIONARIO", "MELHORIA", "DEPARTAMENTO"}, "PLACA LIKE ?", busca, null, null, "_id ASC", null);
                adt.changeCursor(cursor);


                ListView listaDados = (ListView) findViewById(R.id.listarMelhoria);
                listaDados.setAdapter(adt);
                return false;

            }
        });


        final Button btCadastrar = (Button) findViewById(R.id.btCadastro);
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), CadastroMelhoria.class));
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        //Prencher o ListView
        Cursor cursor = db.query("MELHORIA", new String[]{"_id", "FUNCIONARIO", "MELHORIA", "DEOARTAMENTO"}, null, null, null, null, "_id ASC", null);
        String[] campos = {"_id", "FUNCIONARIO", "MELHORIA", "DEPARTAMENTO"};
        int[] ids = {R.id.tvId, R.id.tvFuncionario, R.id.tvMelhoria, R.id.tvDepartamento};


        //mudar
        //
        //
        adt = new SimpleCursorAdapter(getBaseContext(), R.layout.modelo_veiculos, cursor, campos, ids, 0);
        //
        //
        //
        ListView listaDados = (ListView) findViewById(R.id.listarMelhoria);
        listaDados.setAdapter(adt);


        listaDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor retornoCursor = (Cursor) adt.getItem(position);
                Intent it = new Intent(getBaseContext(), EditarRemoverMelhoria.class);
                it.putExtra("Codigo", retornoCursor.getInt(0));
                it.putExtra("FUNCIONARIO", retornoCursor.getString(1));
                it.putExtra("MELHORIA", retornoCursor.getString(2));
                it.putExtra("DEPARTAMENTO", retornoCursor.getString(3));
                startActivity(it);

            }
        });
    }

    public void acaoSair(View view){
        finish();
    }

}
