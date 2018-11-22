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
import android.widget.TextView;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.Entidades.ClientesEntidade;
import com.example.eduardoi.locaplus.R;
import com.example.eduardoi.locaplus.TelasCadastros.CadastroCliente;
import com.example.eduardoi.locaplus.TelasCadastros.CadastroLocacao;
import com.example.eduardoi.locaplus.TelasCadastros.EditarRemoverLocacao;

import java.util.LinkedList;
import java.util.List;


//LISTA UTILIZADA PARA SELECIONAR O CLIENTE NA HORA DE CADASTRAR A LOCAÇÃO.
public class ListarClientesLocacao extends AppCompatActivity {

    Banco bd;
    private ListView listaClientes;
    private SQLiteDatabase conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarclienteslocacao);
        listaClientes = findViewById(R.id.listarClientes);
        conexaoBD();
        acoes();
    }

    private void acoes() {
        listaClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent it = getIntent();
                ClientesEntidade novoCliente = (ClientesEntidade) adapterView.getItemAtPosition(position);
                it.putExtra("cliente", novoCliente.getNomeCliente());
                setResult(2, it);
                finish();
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

    private List listaCliente(){
        conexao = bd.getWritableDatabase();
        List clientes =  new LinkedList();
        Cursor res = conexao.rawQuery("SELECT * FROM CLIENTE", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                ClientesEntidade cliente = new ClientesEntidade();
                cliente.setId(res.getInt(res.getColumnIndexOrThrow("ID")));
                cliente.setNomeCliente(res.getString(res.getColumnIndexOrThrow("NOME")));
                cliente.setRgCliente(res.getString(res.getColumnIndexOrThrow("RG")));
                cliente.setCpfCliente(res.getString(res.getColumnIndexOrThrow("CPF")));
                cliente.setEnderecoCliente(res.getString(res.getColumnIndexOrThrow("ENDERECO")));
                cliente.setCnhCliente(res.getString(res.getColumnIndexOrThrow("CNH")));
                cliente.setNumeroDependentes(res.getString(res.getColumnIndexOrThrow("NUMERODEPENDENTES")));
                clientes.add(cliente);
            }while (res.moveToNext());
        }
        return clientes;
    }

    public void acaoSair(View view){
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter<ClientesEntidade> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listaCliente());
        listaClientes.setAdapter(arrayAdapter);
    }
}
