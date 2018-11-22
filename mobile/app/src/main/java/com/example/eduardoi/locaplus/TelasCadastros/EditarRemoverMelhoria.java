package com.example.eduardoi.locaplus.TelasCadastros;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.R;

public class EditarRemoverMelhoria extends AppCompatActivity {
    Banco bd;
    private SQLiteDatabase conexao;
    private EditText editFuncionario;
    private EditText editMelhoria;
    private EditText editDepartamento;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editarremovermelhoria);

        conexaoBD();
        final Intent it = getIntent();
        editFuncionario = findViewById(R.id.etFuncionario);
        editMelhoria = findViewById(R.id.etMelhoria);
        editDepartamento = findViewById(R.id.etDepartamento);

        editFuncionario.setText(it.getStringExtra("FUNCIONARIO"));
        editMelhoria.setText(it.getStringExtra("MELHORIA"));
        editDepartamento.setText(it.getStringExtra("DEPARTAMENTO"));




        Button btAtualizar = (Button) findViewById(R.id.btSalvarMelho);
        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexao = bd.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("FUNCIONARIO", editFuncionario.getText().toString());
                values.put("MELHORIA", editMelhoria.getText().toString());
                values.put("DEPARTAMENTO", editDepartamento.getText().toString());

                if (conexao.update("MELHORIA", values, "ID = ?", new String[]{String.valueOf(it.getIntExtra("ID",0))}) > 0) {
                    conexao.close();
                    Toast.makeText(getBaseContext(), "Melhoria atualizada", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Erro ao atualizar!", Toast.LENGTH_SHORT).show();
            }
        });

        Button btExcluir = (Button) findViewById(R.id.btRemoverMelhoria);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexao = bd.getWritableDatabase();
                if (conexao.delete("MELHORIA", "ID = ?", new String[]{String.valueOf(it.getIntExtra("ID", 0))}) > 0){
                    Toast.makeText(getBaseContext(), "Melhoria excluida!", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Erro ao excluir!", Toast.LENGTH_SHORT).show();
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
