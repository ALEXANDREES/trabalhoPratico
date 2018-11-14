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
import com.example.alexandre.myapplication.TelasCadastros.CadastroCliente;
import com.example.alexandre.myapplication.TelasEditarRemover.EditarRemoverLocacao;


public class ListarClientes extends AppCompatActivity

{

    private SQLiteDatabase db;

    private SimpleCursorAdapter adt = null;

    @SuppressLint("WrongConstant")

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listarclientes);

        db = openOrCreateDatabase("TESTE3", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        String clientes = "CREATE TABLE IF NOT EXISTS CLIENTE (_id INTEGER PRIMARY KEY autoincrement, " + "NOME VARCHAR(50), RG VARCHAR(14), CPF VARCHAR(20), ENDERECO VARCHAR(50), CNH VARCHAR(20), NDEPENDENTES VARCHAR(2))";

        db.execSQL(clientes);

        final Button btTelaCadastro = (Button) findViewById(R.id.btCadastrar);

        btTelaCadastro.setOnClickListener(new View.OnClickListener()
        {

        @Override

            public void onClick(View v)
            {
                startActivity(new Intent(getBaseContext(), CadastroCliente.class));
            }
        }
        );

        final EditText txtBusca = (EditText) findViewById(R.id.txtBusca);

        txtBusca.setOnKeyListener(new View.OnKeyListener()
        {

            @Override

            public boolean onKey(View v, int keyCode, KeyEvent event)
            {

                String[] busca = new String[]{"%" + txtBusca.getText().toString() + "%"};

                Cursor cursor = db.query("CLIENTE", new String[]{"_id", "NOME", "RG", "CPF", "ENDERECO", "CNH", "NDEPENDENTES"}, "NOME LIKE ?", busca, null, null, "_id ASC", null);

                adt.changeCursor(cursor);


                ListView listaDados = (ListView) findViewById(R.id.listarClientes);

                listaDados.setAdapter(adt);

                return false;
            }
        });
    }

    @Override

    public void onResume()
    {

        super.onResume();

        Cursor cursor = db.query("CLIENTE", new String[]{"_id", "NOME", "RG", "CPF", "ENDERECO", "CNH", "NDEPENDENTES"}, null, null, null, null, "_id ASC", null);

        String[] campos = {"_id", "NOME", "RG", "CPF", "ENDERECO", "CNH", "NDEPENDENTES"};

        int[] ids = {R.id.tvId, R.id.tvNome, R.id.tvRG, R.id.tvCPF, R.id.tvEndereco, R.id.tvCNH,R.id.tvN_Dependentes};

        adt = new SimpleCursorAdapter(getBaseContext(), R.layout.modelo_cliente, cursor, campos, ids, 0);

        ListView listaDados = (ListView) findViewById(R.id.listarClientes);

        listaDados.setAdapter(adt);

        listaDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id)

            {

                Cursor retornoCursor = (Cursor) adt.getItem(position);

                Intent it = new Intent(getBaseContext(), EditarRemoverLocacao.class);

                it.putExtra("Codigo", retornoCursor.getInt(0));

                it.putExtra("Nome", retornoCursor.getString(1));

                it.putExtra("RG", retornoCursor.getString(2));

                it.putExtra("CPF", retornoCursor.getString(3));

                it.putExtra("Endereço", retornoCursor.getString(4));

                it.putExtra("CNH", retornoCursor.getFloat(5));

                it.putExtra("Numero de Dependentes", retornoCursor.getString(6));

                startActivity(it);

            }
        });
    }

    public void acaoSair(View view)

    {
        finish();
    }
}