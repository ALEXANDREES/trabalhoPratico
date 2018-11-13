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

import com.example.alexandre.myapplication.TelasEditarRemover.EditarRemoverLocacao;
import com.example.alexandre.myapplication.R;
import com.example.alexandre.myapplication.TelasCadastros.CadastrarLocacao;

public class ListarLocacao extends AppCompatActivity {

    private SQLiteDatabase db;
    private SimpleCursorAdapter adt = null;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarlocacao);

        //Criar o banco de dados
        db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        String locacoes = "CREATE TABLE IF NOT EXISTS LOCACAO (_id INTEGER PRIMARY KEY autoincrement, " +
                "DATALOCACAO VARCHAR(10), CLIENTE VARCHAR(50), VEICULO VARCHAR(30), DATAENCERRAMENTO VARCHAR(10), KM FLOAT, STATUS VARCHAR(10))";

        db.execSQL(locacoes);



        final Button btAtualizar = (Button) findViewById(R.id.btCadastrar);
        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), CadastrarLocacao.class));
            }
        });

        final EditText txtBusca = (EditText) findViewById(R.id.txtBusca);
        txtBusca.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Prencher o ListView
                String[] busca = new String[]{"%" + txtBusca.getText().toString() + "%"};
                Cursor cursor = db.query("LOCACAO", new String[]{"_id", "DATALOCACAO", "CLIENTE", "VEICULO", "DATAENCERRAMENTO", "KM", "STATUS"}, "CLIENTE LIKE ?", busca, null, null, "_id ASC", null);
                adt.changeCursor(cursor);


                ListView listaDados = (ListView) findViewById(R.id.listarLocacoes);
                listaDados.setAdapter(adt);
                return false;
            }
        });

    }
    @Override
    public void onResume(){
        super.onResume();
        //Prencher o ListView
        Cursor cursor = db.query("LOCACAO", new String[]{"_id", "DATALOCACAO", "CLIENTE", "VEICULO", "DATAENCERRAMENTO", "KM", "STATUS"}, null, null, null, null, "_id ASC", null);
        String[] campos = {"_id", "DATALOCACAO", "CLIENTE", "VEICULO", "DATAENCERRAMENTO", "KM", "STATUS"};
        int[] ids = {R.id.tvId, R.id.tvDataLocacao, R.id.tvCliente, R.id.tvCarro, R.id.tvDataEncerramento, R.id.tvKm,R.id.tvStatus};
        adt = new SimpleCursorAdapter(getBaseContext(), R.layout.modelo_locacao, cursor, campos, ids, 0);
        ListView listaDados = (ListView) findViewById(R.id.listarLocacoes);
        listaDados.setAdapter(adt);


        listaDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor retornoCursor = (Cursor) adt.getItem(position);
                Intent it = new Intent(getBaseContext(), EditarRemoverLocacao.class);
                it.putExtra("Codigo", retornoCursor.getInt(0));
                it.putExtra("Data Locação", retornoCursor.getString(1));
                it.putExtra("Cliente", retornoCursor.getString(2));
                it.putExtra("Veiculo", retornoCursor.getString(3));
                it.putExtra("Data Encerramento", retornoCursor.getString(4));
                it.putExtra("Quilometros", retornoCursor.getFloat(5));
                it.putExtra("Status", retornoCursor.getString(6));
                // it.putExtra("email", retornoCursor.getString(retornoCursor.getColumnIndex("Quilometros")));
                startActivity(it);

            }
        });
    }

    public void acaoSair(View view){
        finish();
    }
}