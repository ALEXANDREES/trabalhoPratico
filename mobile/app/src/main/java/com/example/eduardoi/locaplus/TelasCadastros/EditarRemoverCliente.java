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

public class EditarRemoverCliente extends AppCompatActivity {
    Banco bd;
    private SQLiteDatabase conexao;
    private EditText editnome;
    private EditText editrg;
    private EditText editcpf;
    private EditText editendereco;
    private EditText editcnh;
    private EditText editndependentes;

    @SuppressLint("WrongConstant")

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarremovercliente);

        conexaoBD();
        final Intent it = getIntent();
        editnome = findViewById(R.id.etnome);
        editrg = findViewById(R.id.etrg);
        editcpf = findViewById(R.id.etcpf);
        editendereco = findViewById(R.id.etendereco);
        editcnh = findViewById(R.id.etcnh);
        editndependentes = findViewById(R.id.etndependentes);

        editnome.setText(it.getStringExtra("nome"));
        editrg.setText(it.getStringExtra("rg"));
        editcpf.setText(it.getStringExtra("cpf"));
        editendereco.setText(it.getStringExtra("endereco"));
        editcnh.setText(it.getStringExtra("cnh"));
        editndependentes.setText(it.getStringExtra("ndependentes"));

        Button btAtualizar = (Button) findViewById(R.id.btAtualizar);

        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conexao = bd.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("NOME", editnome.getText().toString());
                values.put("RG", editrg.getText().toString());
                values.put("CPF", editcpf.getText().toString());
                values.put("ENDERECO", editendereco.getText().toString());
                values.put("CNH", editcnh.getText().toString());
                values.put("NUMERODEPENDENTES", editndependentes.getText().toString());

                if (conexao.update("CLIENTE", values, "ID = ?", new String[]{String.valueOf(it.getIntExtra("id",0))}) > 0) {
                    conexao.close();
                    Toast.makeText(getBaseContext(), "Cliente atualizado com Sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Erro ao atualizar o Cliente", Toast.LENGTH_SHORT).show();
            }
        });

        Button btRemover = (Button) findViewById(R.id.btRemover);

        btRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conexao = bd.getWritableDatabase();
                if (conexao.delete("CLIENTE", "ID = ?", new String[]{String.valueOf(it.getIntExtra("id", 0))}) > 0){
                    Toast.makeText(getBaseContext(), "Cliente excluido com Sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Erro ao excluir o Cliente", Toast.LENGTH_SHORT).show();
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
