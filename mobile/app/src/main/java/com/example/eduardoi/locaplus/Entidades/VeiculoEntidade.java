package com.example.eduardoi.locaplus.Entidades;

import java.io.Serializable;

public class VeiculoEntidade implements Serializable{
    private Integer id;
    private String placa;
    private String nome;
    private String marca;
    private String modelo;
    private Float valorSeguro;
    private Float valorLocacao;
    private String ativo;
    private String cor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Float getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(Float valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public Float getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Float valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return  "ID:  " + id + "\n" +
                "Placa:  " + placa + "\n" +
                "Nome:  " + nome + "\n" +
                "Marca:  " + marca + "\n" +
                "Modelo:  " + modelo + "\n" +
                "Valor Seguro:  " + valorSeguro + "\n" +
                "Valor Locação:  " + valorLocacao + "\n" +
                "Ativo:  " + ativo + "\n" +
                "Cor:  " + cor + "\n";
    }
}
