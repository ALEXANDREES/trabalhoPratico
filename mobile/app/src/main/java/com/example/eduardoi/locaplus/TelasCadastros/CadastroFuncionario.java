package com.example.eduardoi.locaplus.TelasCadastros;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.Entidades.FuncionarioEntidade;
import com.example.eduardoi.locaplus.Entidades.VeiculoEntidade;
import com.example.eduardoi.locaplus.R;

public class CadastroFuncionario extends AppCompatActivity {

    private EditText etNome;

    private EditText etCpf;

    private EditText etRg;

    private EditText etEndereco;

    private EditText etCargo;

    private EditText etData;

    Banco bd;
    private SQLiteDatabase conexao;
    private FuncionarioEntidade novoFuncionario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrofuncionario);

        etNome = findViewById(R.id.etNome);

        etCpf = findViewById(R.id.etCpf);

        etRg = findViewById(R.id.etRg);

        etEndereco = findViewById(R.id.etEndereco);

        etCargo = findViewById(R.id.etCargo);

        etData = findViewById(R.id.etData);

    }

    private void inserir(){
        bd = new Banco(this);

        try {
            conexao = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("NOME", novoFuncionario.getNome());
            values.put("CPF", novoFuncionario.getCpf());
            values.put("RG", novoFuncionario.getRg());
            values.put("ENDERECO", novoFuncionario.getEndereco());
            values.put("CARGO", novoFuncionario.getCargo());
            values.put("DATA", novoFuncionario.getData());

            conexao.insert("FUNCIONARIO", null, values);
            conexao.close();
            Toast.makeText(this, "Funcionario cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        }catch (android.database.SQLException e){
            Toast.makeText(this, "Erro ao cadastrar o Funcionario!", Toast.LENGTH_SHORT).show();
        }
    }

    public void acaoSalvar(View view){

        if(novoFuncionario == null)
            novoFuncionario= new FuncionarioEntidade();
        novoFuncionario.setNome(etNome.getText().toString());
        novoFuncionario.setCpf(etCpf.getText().toString());
        novoFuncionario.setRg(etRg.getText().toString());
        novoFuncionario.setEndereco(etEndereco.getText().toString());
        novoFuncionario.setCargo(etCargo.getText().toString());
        novoFuncionario.setData(etData.getText().toString());
        inserir();
        finish();
    }

    public void acaoSair(View view){
        finish();
    }
}
