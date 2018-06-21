package com.rjdesenvolvimento.imobiliaria.domain.enums;

import lombok.Getter;

@Getter
public enum TipoDeTelefone {

    CELULAR (1, "Celular"),
    COMERCIAL(2, "Comercial"),
    RESIDENCIAL(3, "Residencial");

    private int codigo;
    private String descricao;


    TipoDeTelefone(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoDeTelefone converteParaEnum(Integer codigo) {
        if (codigo == null) return null;

        for (TipoDeTelefone x : TipoDeTelefone.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }

    public static String escrever(Integer codigo) {
        if (codigo == null) return null;
        for (TipoDeTelefone x : TipoDeTelefone.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x.getDescricao();
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
