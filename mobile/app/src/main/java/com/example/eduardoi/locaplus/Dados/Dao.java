package com.example.eduardoi.locaplus.Dados;

import com.example.eduardoi.locaplus.Entidades.ClientesEntidade;
import com.example.eduardoi.locaplus.Entidades.LocacaoEntidade;
import com.example.eduardoi.locaplus.Entidades.VeiculoEntidade;

import java.util.LinkedList;
import java.util.List;

public class Dao {

    private static List lista;
    private static int indice;

    public static void salvarLocacao(LocacaoEntidade novaLocacao) {
        if(lista.contains(novaLocacao))
            lista.set(lista.indexOf(novaLocacao), novaLocacao);
        else{
            novaLocacao.setId(indice);
            lista.add(novaLocacao);
            indice++;
        }
    }

    public static void salvarCliente(ClientesEntidade novoCliente) {
        if(lista.contains(novoCliente))
            lista.set(lista.indexOf(novoCliente), novoCliente);
        else{
            novoCliente.setId(indice);
            lista.add(novoCliente);
            indice++;
        }
    }

    public static void salvarCliente(VeiculoEntidade novoVeiculo) {
        if(lista.contains(novoVeiculo))
            lista.set(lista.indexOf(novoVeiculo), novoVeiculo);
        else{
            novoVeiculo.setId(indice);
            lista.add(novoVeiculo);
            indice++;
        }
    }

    public static List getLista(){

        if(lista == null){
            lista = new LinkedList();
            indice = 0;
        }
        return lista;
    }

}
