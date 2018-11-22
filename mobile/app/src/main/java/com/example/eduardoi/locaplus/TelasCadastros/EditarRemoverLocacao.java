package com.example.eduardoi.locaplus.TelasCadastros;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.R;
import com.example.eduardoi.locaplus.TelasListas.ListarClientesLocacaoEditar;
import com.example.eduardoi.locaplus.TelasListas.ListarVeiculosLocacaoEditar;


public class EditarRemoverLocacao extends AppCompatActivity{

    Banco bd;
    private SQLiteDatabase conexao;
    private EditText editDataLocacao;
    private EditText editCliente;
    private EditText editVeiculo;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarremoverlocacao);

        conexaoBD();

        final Intent it = getIntent();
        editDataLocacao = findViewById(R.id.etDataLocacao);
        editCliente = findViewById(R.id.etCliente);
        editVeiculo = findViewById(R.id.etVeiculo);

        editDataLocacao.setText(it.getStringExtra("datalocacao"));//PUXA DA LISTA PARA OS CAMPOS A DATA DE LOCAÇÃO.
        editCliente.setText(it.getStringExtra("cliente"));//PUXA DA LISTA PARA OS CAMPOS O CLIENTE.
        editVeiculo.setText(it.getStringExtra("veiculo"));//PUXA DA LISTA PARA OS CAMPOS O VEICULO.


        //AÇÃO DIRETAMENTE VINCULADA COM O NOME DO BOTÃO QUE FAZ A ATUALIZAÇÃO DA LOCAÇÃO.
        Button btAtulizar = (Button) findViewById(R.id.btAtualizar);
        btAtulizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    conexao = bd.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("DATALOCACAO", editDataLocacao.getText().toString());
                    values.put("CLIENTE", editCliente.getText().toString());
                    values.put("VEICULO", editVeiculo.getText().toString());

                    if (conexao.update("LOCACAO", values, "ID = ?", new String[]{String.valueOf(it.getIntExtra("id",0))}) > 0) {
                        conexao.close();
                        Toast.makeText(getBaseContext(), "Locação atualizada com sucesso!!!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else
                    Toast.makeText(getBaseContext(), "Erro ao atualizar a locação!!!", Toast.LENGTH_SHORT).show();
            }
        });

        //AÇÃO DIRETAMENTE VINCULADA COM O NOME DO BOTÃO QUE DELETA UMA DETERMINADA LOCAÇÃO.
        Button btExcluir = (Button) findViewById(R.id.btExcluir);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexao = bd.getWritableDatabase();
                if (conexao.delete("LOCACAO", "ID = ?", new String[]{String.valueOf(it.getIntExtra("id", 0))}) > 0){
                    Toast.makeText(getBaseContext(), "Locação excluida com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(getBaseContext(), "Erro ao excluir a locação!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //METODO DE CONEXÃO COM O BANCO.
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

    //AÇÃO PARA SAIR DA TELA.
    public void acaoSair(View view){
        finish();
    }

    //METODO PARA SELECIONAR O CLIENTE E O VEICULO DE OUTRA TELA.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 2) {
            editCliente.setText(data.getStringExtra("cliente"));
        } if (resultCode == 3) {
            editVeiculo.setText(data.getStringExtra("veiculo"));
        }
    }

    //ABRE A LISTA PARA SELECIONAR O CLIENTE.
    public void acaoEscolherCliente(View view){
        Intent it = new Intent(EditarRemoverLocacao.this, ListarClientesLocacaoEditar.class);
        startActivityForResult(it,1);
    }

    //ABRE A LISTA PARA ESCOLHER O VEICULO.
    public void acaoEscolherVeiculo(View view){
        Intent it = new Intent(EditarRemoverLocacao.this, ListarVeiculosLocacaoEditar.class);
        startActivityForResult(it,1);
    }

    //ABRE A TELA PARA ENCERRAR A LOCAÇÃO.
    public void acaoEncerrarLocacao(View view){
        Intent it = new Intent(EditarRemoverLocacao.this, EncerrarLocacao.class);
        startActivity(it);
        finish();
    }
}
