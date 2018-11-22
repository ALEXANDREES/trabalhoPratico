/*package com.example.eduardoi.locaplus.TelasListas;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.Entidades.MelhoriaEntidade;
import com.example.eduardoi.locaplus.R;
import com.example.eduardoi.locaplus.TelasCadastros.CadastroMelhoria;
import com.example.eduardoi.locaplus.TelasCadastros.EditarRemoverMelhoria;

import java.util.LinkedList;
import java.util.List;

public class ListarMelhoria extends AppCompatActivity {

    Banco bd;
    private ListView listaMelhoria;
    private SQLiteDatabase conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarmelhoria);
        listaMelhoria = findViewById(R.id.listarMelhoria);
        conexaoBD();
        acoes();
    }

    private void acoes() {
        listaMelhoria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent it = new Intent(ListarMelhoria.this, EditarRemoverMelhoria.class);
                MelhoriaEntidade novaMelhoria = (MelhoriaEntidade) adapterView.getItemAtPosition(position);
                it.putExtra("ID", novaMelhoria.getId());
                it.putExtra("FUNCIONARIO", novaMelhoria.getFuncionario());
                it.putExtra("MELHORIA", novaMelhoria.getMelhoria());
                it.putExtra("DEPARTAMENTO", novaMelhoria.getDepartamento());
                startActivity(it);
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

    private List listaMelhoria(){
        conexao = bd.getWritableDatabase();
        List melhorias =  new LinkedList();
        Cursor res = conexao.rawQuery("SELECT * FROM MELHORIA", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                MelhoriaEntidade melhoria = new MelhoriaEntidade();
                melhoria.setId(res.getInt(res.getColumnIndexOrThrow("ID")));
                melhoria.setFuncionario(res.getString(res.getColumnIndexOrThrow("FUNCIONARIO")));
                melhoria.setMelhoria(res.getString(res.getColumnIndexOrThrow("MELHORIA")));
                melhoria.setDepartamento(res.getString(res.getColumnIndexOrThrow("DEPARTAMENTO")));
                melhorias.add(melhoria);
            }while (res.moveToNext());
        }
        return melhorias;
    }

    public void acaoCadastrar(View view){
        Intent it = new Intent(ListarMelhoria.this, CadastroMelhoria.class);
        startActivity(it);
    }

    public void acaoSair(View view){
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter <MelhoriaEntidade> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listaMelhoria());
        listaMelhoria.setAdapter(arrayAdapter);
    }
}
*/