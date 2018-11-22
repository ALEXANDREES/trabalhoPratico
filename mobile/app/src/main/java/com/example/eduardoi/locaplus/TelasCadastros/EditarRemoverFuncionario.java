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

public class EditarRemoverFuncionario extends AppCompatActivity {
    Banco bd;
    private SQLiteDatabase conexao;
    private EditText editNome;
    private EditText editCpf;
    private EditText editRg;
    private EditText editEndereco;
    private EditText editCargo;
    private EditText editData;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarremoverfuncionario);

        conexaoBD();
        final Intent it = getIntent();
        editNome= findViewById(R.id.etNome);
        editCpf = findViewById(R.id.etCpf);
        editRg = findViewById(R.id.etRg);
        editEndereco= findViewById(R.id.etEndereco);
        editCargo= findViewById(R.id.etCargo);
        editData= findViewById(R.id.etData);

        editNome.setText(it.getStringExtra("nome"));
        editCpf.setText(it.getStringExtra("cpf"));
        editRg.setText(it.getStringExtra("rg"));
        editEndereco.setText(it.getStringExtra("endereco"));
        editCargo.setText(it.getStringExtra("cargo"));
        editData.setText(it.getStringExtra("data"));



        Button btAtulizar = (Button) findViewById(R.id.btAtualizar);
        btAtulizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexao = bd.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("NOME", editNome.getText().toString());
                values.put("CPF", editCpf.getText().toString());
                values.put("RG", editRg.getText().toString());
                values.put("ENDERECO", editEndereco.getText().toString());
                values.put("CARGO", editCargo.getText().toString());
                values.put("DATA", editData.getText().toString());

                if (conexao.update("FUNCIONARIO", values, "ID = ?", new String[]{String.valueOf(it.getIntExtra("id",0))}) > 0) {
                    conexao.close();
                    Toast.makeText(getBaseContext(), "Funcionario atualizado com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Erro ao atualizar o Funcionario!!!", Toast.LENGTH_SHORT).show();
            }
        });

        Button btExcluir = (Button) findViewById(R.id.btExcluir);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexao = bd.getWritableDatabase();
                if (conexao.delete("FUNCIONARIO", "ID = ?", new String[]{String.valueOf(it.getIntExtra("id", 0))}) > 0){
                    Toast.makeText(getBaseContext(), "Funcionario excluido com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Erro ao excluir o Funcionario!!!", Toast.LENGTH_SHORT).show();
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
