package com.rjdesenvolvimento.imobiliaria.api.resources.excecoes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ErroDeValidacao extends ErroPadrao {

    private List<NomeDoCampo> listadeCamposErros = new ArrayList<>();

    public ErroDeValidacao(Long timeStamp, Integer status, String erro, String mensagem, String caminho) {
        super(timeStamp, status, erro, mensagem, caminho);
    }

    public void adcionandoErroALista(String nomeDoCampo, String mensagemDeErroDoCampo) {
        listadeCamposErros.add(new NomeDoCampo(nomeDoCampo, mensagemDeErroDoCampo));
    }
}
