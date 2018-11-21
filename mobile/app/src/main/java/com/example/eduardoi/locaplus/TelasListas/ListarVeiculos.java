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
import com.example.eduardoi.locaplus.Entidades.ClientesEntidade;
import com.example.eduardoi.locaplus.Entidades.VeiculoEntidade;
import com.example.eduardoi.locaplus.R;
import com.example.eduardoi.locaplus.TelasCadastros.CadastroVeiculo;
import com.example.eduardoi.locaplus.TelasCadastros.EditarRemoverLocacao;
import com.example.eduardoi.locaplus.TelasCadastros.EditarRemoverVeiculo;

import java.util.LinkedList;
import java.util.List;

public class ListarVeiculos extends AppCompatActivity {

    Banco bd;
    private ListView listaVeiculos;
    private SQLiteDatabase conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarveiculos);
        listaVeiculos = findViewById(R.id.listarVeiculos);
        conexaoBD();
        acoes();
    }

    private void acoes() {
        listaVeiculos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent it = new Intent(ListarVeiculos.this, EditarRemoverVeiculo.class);
                VeiculoEntidade novoVeiculo = (VeiculoEntidade) adapterView.getItemAtPosition(position);
                it.putExtra("id", novoVeiculo.getId());
                it.putExtra("placa", novoVeiculo.getPlaca());
                it.putExtra("nome", novoVeiculo.getNome());
                it.putExtra("marca", novoVeiculo.getMarca());
                it.putExtra("modelo", novoVeiculo.getModelo());
                it.putExtra("seguro", novoVeiculo.getValorSeguro());
                it.putExtra("locacao", novoVeiculo.getValorLocacao());
                it.putExtra("ativo", novoVeiculo.getAtivo());
                it.putExtra("cor", novoVeiculo.getCor());


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

    private List listaVeiculo(){
        conexao = bd.getWritableDatabase();
        List veiculos =  new LinkedList();
        Cursor res = conexao.rawQuery("SELECT * FROM VEICULO", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                VeiculoEntidade veiculo = new VeiculoEntidade();
                veiculo.setId(res.getInt(res.getColumnIndexOrThrow("ID")));
                veiculo.setPlaca(res.getString(res.getColumnIndexOrThrow("PLACA")));
                veiculo.setNome(res.getString(res.getColumnIndexOrThrow("NOME")));
                veiculo.setMarca(res.getString(res.getColumnIndexOrThrow("MARCA")));
                veiculo.setModelo(res.getString(res.getColumnIndexOrThrow("MODELO")));
                veiculo.setValorSeguro(res.getString(res.getColumnIndexOrThrow("VALORSEGURO")));
                veiculo.setValorLocacao(res.getString(res.getColumnIndexOrThrow("VALORLOCACAO")));
                veiculo.setAtivo(res.getString(res.getColumnIndexOrThrow("ATIVO")));
                veiculo.setCor(res.getString(res.getColumnIndexOrThrow("COR")));
                veiculos.add(veiculo);
            }while (res.moveToNext());
        }
        return veiculos;
    }

    public void acaoCadastrar(View view){
        Intent it = new Intent(ListarVeiculos.this, CadastroVeiculo.class);
        startActivity(it);
    }

    public void acaoSair(View view){
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter <VeiculoEntidade> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listaVeiculo());
        listaVeiculos.setAdapter(arrayAdapter);
    }
}
