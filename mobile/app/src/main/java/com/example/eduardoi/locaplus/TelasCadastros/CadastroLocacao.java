package com.example.eduardoi.locaplus.TelasCadastros;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.Entidades.LocacaoEntidade;
import com.example.eduardoi.locaplus.R;

public class CadastroLocacao extends AppCompatActivity {

    private EditText dataInicial;

    private EditText dataFinal;

    private EditText km;

    Banco bd;
    private SQLiteDatabase conexao;
    private LocacaoEntidade novaLocacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrolocacao);

        dataInicial = findViewById(R.id.etDataLocacao);

        dataFinal = findViewById(R.id.etDataDevolucao);

        km = findViewById(R.id.etQuilometragem);

    }

    private void inserir(){
        bd = new Banco(this);

        try {
            conexao = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("DATALOCACAO", novaLocacao.getDataLocacao());
            values.put("DATAENCERRAMENTO", novaLocacao.getDataEncerramento());
            values.put("KM", novaLocacao.getKm());

            conexao.insert("LOCACAO", null, values);
            conexao.close();
            Toast.makeText(this, "Locação salva com sucesso!", Toast.LENGTH_SHORT).show();
        }catch (android.database.SQLException e){
            Toast.makeText(this, "Erro ao salvar a locação!", Toast.LENGTH_SHORT).show();
        }
    }

    public void acaoSalvar(View view){

        if(novaLocacao == null)
            novaLocacao = new LocacaoEntidade();
            novaLocacao.setDataLocacao(dataInicial.getText().toString());
            novaLocacao.setDataEncerramento(dataFinal.getText().toString());
            novaLocacao.setKm(Float.parseFloat(km.getText().toString()));
            inserir();
            finish();
    }

    public void acaoSair(View view){
        finish();
    }
}
