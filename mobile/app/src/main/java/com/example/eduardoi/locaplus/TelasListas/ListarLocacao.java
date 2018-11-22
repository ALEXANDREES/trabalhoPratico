package com.example.eduardoi.locaplus.TelasListas;

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
import com.example.eduardoi.locaplus.Entidades.LocacaoEntidade;
import com.example.eduardoi.locaplus.R;
import com.example.eduardoi.locaplus.TelasCadastros.CadastroLocacao;
import com.example.eduardoi.locaplus.TelasCadastros.EditarRemoverLocacao;

import java.util.LinkedList;
import java.util.List;

public class ListarLocacao extends AppCompatActivity {

    Banco bd;
    private ListView listaLocacoes;
    private SQLiteDatabase conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarlocacao);
        listaLocacoes = findViewById(R.id.listarLocacoes);
        conexaoBD();//CHAMADA DO METODO DE CONEXÃO.
        acoes();//CHAMADA DO METODO DE AÇÕES.
    }

    //AÇÃO QUE QUANDO CLICAR NA LISTA ABRE A TELA DE EDITAR PASSANDO OS VALORES DO ITEM SELECIONADO.
    private void acoes() {
        listaLocacoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent it = new Intent(ListarLocacao.this, EditarRemoverLocacao.class);
                LocacaoEntidade novaLocacao = (LocacaoEntidade) adapterView.getItemAtPosition(position);
                it.putExtra("id", novaLocacao.getId());
                it.putExtra("datalocacao", novaLocacao.getDataLocacao());
                it.putExtra("cliente", novaLocacao.getClienteLocacao());
                it.putExtra("veiculo", novaLocacao.getVeiculoLocacao());
                it.putExtra("dataencerramento", novaLocacao.getDataEncerramento());
                it.putExtra("km", novaLocacao.getKm());
                startActivity(it);
            }
        });

    }

    //METODO DE CONEXÃO COM O BANCO.
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

    //METODO PARA LISTAR TODAS AS LOCAÇÕES.
    private List lista(){
        conexao = bd.getWritableDatabase();
        List locacoes =  new LinkedList();
        Cursor res = conexao.rawQuery("SELECT * FROM LOCACAO", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                LocacaoEntidade loca = new LocacaoEntidade();
                loca.setId(res.getInt(res.getColumnIndexOrThrow("ID")));
                loca.setDataLocacao(res.getString(res.getColumnIndexOrThrow("DATALOCACAO")));
                loca.setClienteLocacao(res.getString(res.getColumnIndexOrThrow("CLIENTE")));
                loca.setVeiculoLocacao(res.getString(res.getColumnIndexOrThrow("VEICULO")));
                loca.setDataEncerramento(res.getString(res.getColumnIndexOrThrow("DATAENCERRAMENTO")));
                loca.setKm(res.getFloat(res.getColumnIndexOrThrow("KM")));
                loca.setStatus(res.getString(res.getColumnIndexOrThrow("STATUS")));
                locacoes.add(loca);
            }while (res.moveToNext());
        }
        return locacoes;
    }

    //AÇÃO VINCULADA A UM BOTÃO QUE ABRE A TELA DE CADASTRO DE LOCAÇÃO.
    public void acaoCadastrar(View view){
        Intent it = new Intent(ListarLocacao.this, CadastroLocacao.class);
        startActivity(it);
    }

    //AÇÃO PARA SAIR DA TELA.
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
