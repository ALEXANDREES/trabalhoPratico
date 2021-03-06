package com.example.eduardoi.locaplus.Dados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper{

    public Banco(Context context) {
        super(context, "TESTE16", null, 1);
        //CRIAÇÃO DO BANCO DE DADOS.
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CRIAÇÃO DA TABELA LOCACAO NO BANCO DE DADOS.
        String sqlLocacao = "CREATE TABLE IF NOT EXISTS LOCACAO(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "DATALOCACAO VARCHAR(45)," +
                "CLIENTE VARCHAR(45)," +
                "VEICULO VARCHAR(45)," +
                "DATAENCERRAMENTO VARCHAR(45)," +
                "KM FLOAT," +
                "STATUS VARCHAR(15))";
        db.execSQL(sqlLocacao);

        String sqlCliente = "CREATE TABLE IF NOT EXISTS CLIENTE(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "NOME VARCHAR(45)," +
                "RG VARCHAR(15)," +
                "CPF VARCHAR(15)," +
                "ENDERECO VARCHAR(45)," +
                "CNH VARCHAR(15)," +
                "NUMERODEPENDENTES VARCHAR(2))";
        db.execSQL(sqlCliente);

        String sqlVeiculo = "CREATE TABLE IF NOT EXISTS VEICULO(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "PLACA VARCHAR(8)," +
                "NOME VARCHAR(30)," +
                "MARCA VARCHAR(30)," +
                "MODELO VARCHAR(30)," +
                "VALORSEGURO FLOAT," +
                "VALORLOCACAO FLOAT," +
                "ATIVO VARCHAR(3)," +
                "COR VARCHAR(10))";
        db.execSQL(sqlVeiculo);

        String sqlMelhoria = "CREATE TABLE IF NOT EXISTS MELHORIA(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "FUNCIONARIO VARCHAR(50)," +
                "MELHORIA VARCHAR(250)," +
                "DEPARTAMENTO VARCHAR(50))";
        db.execSQL(sqlMelhoria);

        String sqlFuncionario = "CREATE TABLE IF NOT EXISTS FUNCIONARIO(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "NOME VARCHAR(100)," +
                "CPF VARCHAR(20)," +
                "RG VARCHAR(20)," +
                "ENDERECO VARCHAR(100)," +
                "CARGO VARCHAR(20)," +
                "DATA VARCHAR(20))";
        db.execSQL(sqlFuncionario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}