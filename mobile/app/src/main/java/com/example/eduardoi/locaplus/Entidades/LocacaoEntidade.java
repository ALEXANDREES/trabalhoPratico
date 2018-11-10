package com.example.eduardoi.locaplus.Entidades;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LocacaoEntidade implements Serializable {
    private Integer id;
    private String dataLocacao;
    private String dataEncerramento;
    private Float km;

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(String dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Float getKm() {
        return km;
    }

    public void setKm(Float km) {
        this.km = km;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Data Locação: " + dataLocacao +", Data encerramento: "+ dataEncerramento +", Quilometragem: "+ km;
    }
}
