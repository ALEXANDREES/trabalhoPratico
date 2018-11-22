package com.example.eduardoi.locaplus.TelasCadastros;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.Entidades.ClientesEntidade;
import com.example.eduardoi.locaplus.R;

public class CadastroCliente extends AppCompatActivity {

    private EditText etnome;

    private EditText etrg;

    private EditText etcpf;

    private EditText etendereco;

    private EditText etcnh;

    private EditText etndependentes;


    Banco bd;

    private SQLiteDatabase conexao;
    private ClientesEntidade novoCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrocliente);

        etnome = findViewById(R.id.etnome);

        etrg = findViewById(R.id.etrg);

        etcpf = findViewById(R.id.etcpf);

        etendereco = findViewById(R.id.etendereco);

        etcnh = findViewById(R.id.etcnh);

        etndependentes = findViewById(R.id.etndependentes);

    }

    private void inserir(){

        bd = new Banco(this);

        try {
            conexao = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("NOME", novoCliente.getNomeCliente());
            values.put("RG", novoCliente.getRgCliente());
            values.put("CPF", novoCliente.getCpfCliente());
            values.put("ENDERECO", novoCliente.getEnderecoCliente());
            values.put("CNH", novoCliente.getCnhCliente());
            values.put("NUMERODEPENDENTES", novoCliente.getNumeroDependentes());

            conexao.insert("CLIENTE", null, values);
            conexao.close();
            Toast.makeText(this, "Cliente cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
        }catch (android.database.SQLException e){
            Toast.makeText(this, "Erro ao cadastrar o Cliente", Toast.LENGTH_SHORT).show();
        }
    }

    public void acaoSalvar(View view){

        if(novoCliente == null) {

            novoCliente = new ClientesEntidade();
            novoCliente.setNomeCliente(etnome.getText().toString());
            novoCliente.setRgCliente(etrg.getText().toString());
            novoCliente.setCpfCliente(etcpf.getText().toString());
            novoCliente.setEnderecoCliente(etendereco.getText().toString());
            novoCliente.setCnhCliente(etcnh.getText().toString());
            novoCliente.setNumeroDependentes(etndependentes.getText().toString());
            inserir();
            finish();
        }
    }

    public void acaoSair(View view){
        finish();
    }
}
