package com.example.eduardoi.locaplus.TelasCadastros;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.R;

public class EditarRemoverVeiculo extends AppCompatActivity {
    Banco bd;
    private SQLiteDatabase conexao;
    private EditText editPlaca;
    private EditText editNome;
    private EditText editMarca;
    private EditText editModelo;
    private EditText editSeguro;
    private EditText editLocacao;
    private EditText editAtivo;
    private EditText editCor;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarremoverveiculos);

        conexaoBD();
        final Intent it = getIntent();
        editPlaca = findViewById(R.id.etPlaca);
        editNome = findViewById(R.id.etNome);
        editMarca = findViewById(R.id.etMarca);
        editModelo = findViewById(R.id.etModelo);
        editSeguro = findViewById(R.id.etSeguro);
        editLocacao = findViewById(R.id.etLocacao);
        editAtivo = findViewById(R.id.etAtivo);
        editCor = findViewById(R.id.etCor);

        editPlaca.setText(it.getStringExtra("placa"));
        editNome.setText(it.getStringExtra("nome"));
        editMarca.setText(it.getStringExtra("marca"));
        editModelo.setText(it.getStringExtra("modelo"));
        editSeguro.setText(it.getStringExtra("seguro"));
        editLocacao.setText(it.getStringExtra("locacao"));
        editAtivo.setText(it.getStringExtra("ativo"));
        editCor.setText(it.getStringExtra("cor"));




        Button btAtulizar = (Button) findViewById(R.id.btAtualizar);
        btAtulizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexao = bd.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("PLACA", editPlaca.getText().toString());

                values.put("NOME", editNome.getText().toString());
                values.put("MARCA", editMarca.getText().toString());
                values.put("MODELO", editModelo.getText().toString());
                values.put("VALORSEGURO", editSeguro.getText().toString());
                values.put("VALORLOCACAO", editLocacao.getText().toString());
                values.put("ATIVO", editAtivo.getText().toString());
                values.put("COR", editCor.getText().toString());

                if (conexao.update("VEICULO", values, "ID = ?", new String[]{String.valueOf(it.getIntExtra("id",0))}) > 0) {
                    conexao.close();
                    Toast.makeText(getBaseContext(), "Veiculo atualizada com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Erro ao atualizar a Veiculo!!!", Toast.LENGTH_SHORT).show();
            }
        });

        Button btExcluir = (Button) findViewById(R.id.btExcluir);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexao = bd.getWritableDatabase();
                if (conexao.delete("VEICULO", "ID = ?", new String[]{String.valueOf(it.getIntExtra("id", 0))}) > 0){
                    Toast.makeText(getBaseContext(), "Veiculo excluida com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Erro ao excluir a veiculo!!!", Toast.LENGTH_SHORT).show();
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

    public void acaoSair(View view){
        finish();
    }
}
