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
import com.example.eduardoi.locaplus.Entidades.FuncionarioEntidade;
import com.example.eduardoi.locaplus.Entidades.VeiculoEntidade;
import com.example.eduardoi.locaplus.R;
import com.example.eduardoi.locaplus.TelasCadastros.CadastroFuncionario;
import com.example.eduardoi.locaplus.TelasCadastros.CadastroVeiculo;
import com.example.eduardoi.locaplus.TelasCadastros.EditarRemoverFuncionario;
import com.example.eduardoi.locaplus.TelasCadastros.EditarRemoverLocacao;
import com.example.eduardoi.locaplus.TelasCadastros.EditarRemoverVeiculo;

import java.util.LinkedList;
import java.util.List;

import static com.example.eduardoi.locaplus.R.id.listarFuncionario;

public class ListarFuncionario extends AppCompatActivity {

    Banco bd;
    private ListView listafuncionario;
    private SQLiteDatabase conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarfuncionario);
        listafuncionario = findViewById(R.id.listarFuncionario);
        conexaoBD();
        acoes();
    }

    private void acoes() {
        listafuncionario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent it = new Intent(ListarFuncionario.this, EditarRemoverFuncionario.class);
                FuncionarioEntidade novoFuncionario = (FuncionarioEntidade) adapterView.getItemAtPosition(position);
                it.putExtra("id", novoFuncionario.getId());
                it.putExtra("nome", novoFuncionario.getNome());
                it.putExtra("cpf", novoFuncionario.getCpf());
                it.putExtra("rg", novoFuncionario.getRg());
                it.putExtra("endereco", novoFuncionario.getEndereco());
                it.putExtra("cargo", novoFuncionario.getCargo());
                it.putExtra("data", novoFuncionario.getData());

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

    private List listafuncionario(){
        conexao = bd.getWritableDatabase();
        List funcionarios =  new LinkedList();
        Cursor res = conexao.rawQuery("SELECT * FROM FUNCIONARIO", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                FuncionarioEntidade funcionario = new FuncionarioEntidade();
                funcionario.setId(res.getInt(res.getColumnIndexOrThrow("ID")));
                funcionario.setNome(res.getString(res.getColumnIndexOrThrow("NOME")));
                funcionario.setCpf(res.getString(res.getColumnIndexOrThrow("CPF")));
                funcionario.setRg(res.getString(res.getColumnIndexOrThrow("RG")));
                funcionario.setEndereco(res.getString(res.getColumnIndexOrThrow("ENDERECO")));
                funcionario.setCargo(res.getString(res.getColumnIndexOrThrow("CARGO")));
                funcionario.setData(res.getString(res.getColumnIndexOrThrow("DATA")));

                funcionarios.add(funcionario);
            }while (res.moveToNext());
        }
        return funcionarios;
    }

    public void acaoCadastrar(View view){
        Intent it = new Intent(ListarFuncionario.this, CadastroFuncionario.class);
        startActivity(it);
    }

    public void acaoSair(View view){
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter <FuncionarioEntidade> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listafuncionario());
        listafuncionario.setAdapter(arrayAdapter);
    }
}
