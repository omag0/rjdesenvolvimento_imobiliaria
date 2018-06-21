package com.rjdesenvolvimento.imobiliaria.api.resources.excecoes;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ErroPadrao implements Serializable {

    private Long timeStamp;
    private Integer status;
    private String erro;
    private String mensagem;
    private String caminho;

    public ErroPadrao(Long timeStamp, Integer status, String erro, String mensagem, String caminho) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        this.caminho = caminho;
    }
}
