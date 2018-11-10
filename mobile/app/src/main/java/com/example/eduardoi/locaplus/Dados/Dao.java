package com.example.eduardoi.locaplus.Dados;

import com.example.eduardoi.locaplus.Entidades.LocacaoEntidade;

import java.util.LinkedList;
import java.util.List;

public class Dao {

    private static List lista;
    private static int indice;

    public static void salvar(LocacaoEntidade novaLocacao) {
        if(lista.contains(novaLocacao))
            lista.set(lista.indexOf(novaLocacao), novaLocacao);
        else{
            novaLocacao.setId(indice);
            lista.add(novaLocacao);
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
