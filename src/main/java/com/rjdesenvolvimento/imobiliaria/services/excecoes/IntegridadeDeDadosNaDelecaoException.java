package com.rjdesenvolvimento.imobiliaria.services.excecoes;

public class IntegridadeDeDadosNaDelecaoException extends RuntimeException {

    public IntegridadeDeDadosNaDelecaoException(String mensagem) {
        super(mensagem);
    }

    public IntegridadeDeDadosNaDelecaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
