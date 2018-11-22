package com.example.eduardoi.locaplus.TelasCadastros;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardoi.locaplus.Dados.Banco;
import com.example.eduardoi.locaplus.Entidades.LocacaoEntidade;
import com.example.eduardoi.locaplus.R;
import com.example.eduardoi.locaplus.TelasListas.ListarClientes;
import com.example.eduardoi.locaplus.TelasListas.ListarClientesLocacao;
import com.example.eduardoi.locaplus.TelasListas.ListarVeiculosLocacao;

public class CadastroLocacao extends AppCompatActivity {

    private EditText etDataLocacao;

    private EditText etCliente;

    private EditText etVeiculo;

    Banco bd;
    private SQLiteDatabase conexao;
    private LocacaoEntidade novaLocacao;

    String dataEncerramento = "Não Informada";//SETANDO A DATA.
    String status = "ATIVA";//SETANDO O STATUS DA LOCACAO.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrolocacao);

        etDataLocacao = findViewById(R.id.etDataLocacao);

        etCliente = findViewById(R.id.etCliente);

        etVeiculo = findViewById(R.id.etVeiculo);

        Intent it = getIntent();//PEGANDO DADOS DE OUTRAS TELAS.

        etCliente.setText(it.getStringExtra("cliente"));//PEGANDO O CLIENTE.
        etVeiculo.setText(it.getStringExtra("veiculo"));//PEGANDO O VEICULO.

    }

    //METODO PARA INSERIR OS DADOS INFORMADOS NOS CAMPOS E OS DADOS SETADOS NA TABELA LOCACAO.
    private void inserir(){
        bd = new Banco(this);

        try {
            conexao = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("DATALOCACAO", novaLocacao.getDataLocacao());
            values.put("CLIENTE", novaLocacao.getClienteLocacao());
            values.put("VEICULO", novaLocacao.getVeiculoLocacao());
            values.put("DATAENCERRAMENTO", dataEncerramento);
            values.put("STATUS", status);

            conexao.insert("LOCACAO", null, values);
            conexao.close();
            Toast.makeText(this, "Locação salva com sucesso!", Toast.LENGTH_SHORT).show();
        }catch (android.database.SQLException e){
            Toast.makeText(this, "Erro ao salvar a locação!", Toast.LENGTH_SHORT).show();
        }
    }

    //AÇÃO DO BOTÃO QUE CRIA UMA NOVA LOCAÇÃO E PUXA O METODO DE INSERIR.
    public void acaoSalvar(View view){

        if(novaLocacao == null)
            novaLocacao = new LocacaoEntidade();
            novaLocacao.setDataLocacao(etDataLocacao.getText().toString());
            novaLocacao.setClienteLocacao(etCliente.getText().toString());
            novaLocacao.setVeiculoLocacao(etVeiculo.getText().toString());
            inserir();
            finish();
    }

    //AÇÃO DE SAIR DO BOTÃO.
    public void acaoSair(View view){
        finish();
    }


    //PUXA O CLIENTE E O VEICULO DA LISTA ONDE O CLIENTE TEM UM RESULCODE 2 E O VEICULO UM RESULTCODE3.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 2) {
            etCliente.setText(data.getStringExtra("cliente"));
        } if (resultCode == 3) {
            etVeiculo.setText(data.getStringExtra("veiculo"));
        }
    }


    //AÇÃO QUE ABRE A LISTA PARA ESCOLHER O CLIENTE.
    public void acaoEscolherCliente(View view){
        Intent it = new Intent(CadastroLocacao.this, ListarClientesLocacao.class);
        startActivityForResult(it,1);
    }

    //AÇÃO QUE ABRE A LISTA PARA ESCOLHER O VEICULO.
    public void acaoEscolherVeiculo(View view){
        Intent it = new Intent(CadastroLocacao.this, ListarVeiculosLocacao.class);
        startActivityForResult(it,1);
    }
}
