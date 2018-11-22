package com.example.eduardoi.locaplus.Entidades;

import java.io.Serializable;

public class MelhoriaEntidade implements Serializable{
    private Integer id;

    private String funcionario;
    private String departamento;
    private String melhoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMelhoria() {
        return melhoria;
    }

    public void setMelhoria(String melhoria) {
        this.melhoria = melhoria;
    }

    @Override
    public String toString() {
        return  "ID:  " + id + "\n" +
                "Funcionario:  " + funcionario + "\n" +
                "Departamento:  " + departamento + "\n" +
                "Melhoria:  " + melhoria + "\n";
    }
}
