package com.example.eduardoi.locaplus.TelasCadastros;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.Entidades.VeiculoEntidade;
import com.example.eduardoi.locaplus.R;

public class CadastroVeiculo extends AppCompatActivity {

    private EditText etPlaca;

    private EditText etNome;

    private EditText etMarca;

    private EditText etModelo;

    private EditText etValorSeguro;

    private EditText etValorLocacao;

    private EditText etAtivo;

    private EditText etCor;


    Banco bd;
    private SQLiteDatabase conexao;
    private VeiculoEntidade novoVeiculo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastroveiculo);

        etPlaca = findViewById(R.id.etPlaca);

        etNome = findViewById(R.id.etNome);

        etMarca = findViewById(R.id.etMarca);

        etModelo = findViewById(R.id.etModelo);

        etValorSeguro = findViewById(R.id.etSeguro);

        etValorLocacao = findViewById(R.id.etLocacao);

        etAtivo = findViewById(R.id.etAtivo);

        etCor = findViewById(R.id.etCor);

    }

    private void inserir(){
        bd = new Banco(this);

        try {
            conexao = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("PLACA", novoVeiculo.getPlaca());
            values.put("NOME", novoVeiculo.getNome());
            values.put("MARCA", novoVeiculo.getMarca());
            values.put("MODELO", novoVeiculo.getModelo());
            values.put("VALORSEGURO", novoVeiculo.getValorSeguro());
            values.put("VALORLOCACAO", novoVeiculo.getValorLocacao());
            values.put("ATIVO", novoVeiculo.getAtivo());
            values.put("COR", novoVeiculo.getCor());

            conexao.insert("VEICULO", null, values);
            conexao.close();
            Toast.makeText(this, "Veiculo cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        }catch (android.database.SQLException e){
            Toast.makeText(this, "Erro ao cadastrar o veiculo!", Toast.LENGTH_SHORT).show();
        }
    }

    public void acaoSalvar(View view){

        if(novoVeiculo == null)
            novoVeiculo = new VeiculoEntidade();
            novoVeiculo.setPlaca(etPlaca.getText().toString());
            novoVeiculo.setNome(etNome.getText().toString());
            novoVeiculo.setMarca(etMarca.getText().toString());
            novoVeiculo.setModelo(etModelo.getText().toString());
            novoVeiculo.setValorSeguro(Float.parseFloat(etValorSeguro.getText().toString()));
            novoVeiculo.setValorLocacao(Float.parseFloat(etValorLocacao.getText().toString()));
            novoVeiculo.setAtivo(etAtivo.getText().toString());
            novoVeiculo.setCor(etCor.getText().toString());
            inserir();
            finish();
    }

    public void acaoSair(View view){
        finish();
    }
}
