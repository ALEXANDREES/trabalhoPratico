package com.example.eduardoi.locaplus.Entidades;

import java.io.Serializable;

public class ClientesEntidade implements Serializable {
    private Integer id;
    private String nomeCliente;
    private String rgCliente;
    private String cpfCliente;
    private String enderecoCliente;
    private String cnhCliente;
    private String numeroDependentes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getCnhCliente() {
        return cnhCliente;
    }

    public void setCnhCliente(String cnhCliente) {
        this.cnhCliente = cnhCliente;
    }

    public String getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(String numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }

    @Override
    public String toString() {
        return "ID:  " + id + "\n" +
                "Nome:  " + nomeCliente + "\n" +
                "RG:  " + rgCliente + "\n" +
                "CPF:  " + cpfCliente + "\n" +
                "Endereço:  " + enderecoCliente + "\n" +
                "Número CNH:  " + cnhCliente + "\n" +
                "Número Dependentes:  " + numeroDependentes + "\n";
    }
}
