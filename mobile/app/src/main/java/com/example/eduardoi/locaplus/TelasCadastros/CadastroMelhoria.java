    package com.example.eduardoi.locaplus.TelasCadastros;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.Entidades.MelhoriaEntidade;
import com.example.eduardoi.locaplus.R;

public class CadastroMelhoria extends AppCompatActivity {

    private EditText etFuncionario;

    private EditText etMelhoria;

    private EditText etDepartamento;


    Banco bd;
    private SQLiteDatabase conexao;
    private MelhoriaEntidade novaMelhoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastromelhoria);


        etFuncionario = findViewById(R.id.etFuncionario);

        etMelhoria = findViewById(R.id.etMelhoria);

        etDepartamento = findViewById(R.id.etDepartamento);

    }

    private void inserir(){
        bd = new Banco(this);

        try {
            conexao = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("FUNCIONARIO", novaMelhoria.getFuncionario());
            values.put("MELHORIA", novaMelhoria.getMelhoria());
            values.put("DEPARTAMENTO", novaMelhoria.getDepartamento());
            conexao.insert("MELHORIA", null, values);
            conexao.close();
            Toast.makeText(this, "Melhoria cadastrada", Toast.LENGTH_SHORT).show();
        }catch (android.database.SQLException e){
            Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
        }
    }

    public void salvarMelhoria(View view){

        if(novaMelhoria == null)
            novaMelhoria = new MelhoriaEntidade();
        novaMelhoria.setFuncionario(etFuncionario.getText().toString());
        novaMelhoria.setMelhoria(etMelhoria.getText().toString());
        novaMelhoria.setDepartamento(etDepartamento.getText().toString());

            inserir();
            finish();
    }

    public void acaoSair(View view){
        finish();
    }
}
