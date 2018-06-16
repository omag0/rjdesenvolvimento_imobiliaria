package com.rjdesenvolvimento.imobiliaria.services.excecoes;

public class IntegridadeDeDadosException extends RuntimeException {

    public IntegridadeDeDadosException(String mensagem) {
        super(mensagem);
    }

    public IntegridadeDeDadosException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
