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

    private EditText etNome;

    private EditText etRg;

    private EditText etCpf;

    private EditText etEndereco;

    private EditText etCnh;

    private EditText etNumeroDependentes;


    Banco bd;
    private SQLiteDatabase conexao;
    private ClientesEntidade novoCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrocliente);

        etNome = findViewById(R.id.editText);

        etRg = findViewById(R.id.editText2);

        etCpf = findViewById(R.id.editText3);

        etEndereco = findViewById(R.id.editText4);

        etCnh = findViewById(R.id.editText5);

        etNumeroDependentes = findViewById(R.id.editText6);

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
            Toast.makeText(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        }catch (android.database.SQLException e){
            Toast.makeText(this, "Erro ao cadastrar o cliente!", Toast.LENGTH_SHORT).show();
        }
    }

    public void acaoSalvar(View view){

        if(novoCliente == null)
            novoCliente = new ClientesEntidade();
            novoCliente.setNomeCliente(etNome.getText().toString());
            novoCliente.setRgCliente(etRg.getText().toString());
            novoCliente.setCpfCliente(etCpf.getText().toString());
            novoCliente.setEnderecoCliente(etEndereco.getText().toString());
            novoCliente.setCnhCliente(etCnh.getText().toString());
            novoCliente.setNumeroDependentes(etNumeroDependentes.getText().toString());
            inserir();
            finish();
    }

    public void acaoSair(View view){
        finish();
    }
}
