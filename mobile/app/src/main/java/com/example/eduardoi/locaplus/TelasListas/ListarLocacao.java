package com.example.eduardoi.locaplus.TelasListas;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.Entidades.LocacaoEntidade;
import com.example.eduardoi.locaplus.R;
import com.example.eduardoi.locaplus.TelasCadastros.CadastroLocacao;

import java.util.LinkedList;
import java.util.List;

public class ListarLocacao extends AppCompatActivity {

    Banco bd;
    private ListView listaLocacoes;
    private SQLiteDatabase conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_locacao);
        listaLocacoes = findViewById(R.id.listar);
        conexaoBD();
        acoes();
    }

    private void acoes() {
        listaLocacoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent it = new Intent(ListarLocacao.this, CadastroLocacao.class);
                LocacaoEntidade novaLocacao = (LocacaoEntidade) adapterView.getItemAtPosition(position);
                it.putExtra("novalocacao", novaLocacao);
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

    private List lista(){
        conexao = bd.getWritableDatabase();
        List locacoes =  new LinkedList();
        Cursor res = conexao.rawQuery("SELECT * FROM LOCACAO", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                LocacaoEntidade loca = new LocacaoEntidade();
                loca.setDataLocacao(res.getString(res.getColumnIndexOrThrow("DATALOCACAO")));
                loca.setDataEncerramento(res.getString(res.getColumnIndexOrThrow("DATAENCERRAMENTO")));
                loca.setKm(res.getFloat(res.getColumnIndexOrThrow("KM")));
                locacoes.add(loca);
            }while (res.moveToNext());
        }
        return locacoes;
    }

    public void acaoCadastrar(View view){
        Intent it = new Intent(ListarLocacao.this, CadastroLocacao.class);
        startActivity(it);
    }

    public void acaoSair(View view){
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter<LocacaoEntidade> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, lista());
        listaLocacoes.setAdapter(arrayAdapter);
    }
}
