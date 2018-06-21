package com.rjdesenvolvimento.imobiliaria.api.resources.excecoes;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class NomeDoCampo implements Serializable {

    private String nomeDoCampo;
    private String mensagemDeErroDoCampo;

    public NomeDoCampo() {
    }

    public NomeDoCampo(String nomeDoCampo, String mensagemDeErroDoCampo) {
        this.nomeDoCampo = nomeDoCampo;
        this.mensagemDeErroDoCampo = mensagemDeErroDoCampo;
    }
}
