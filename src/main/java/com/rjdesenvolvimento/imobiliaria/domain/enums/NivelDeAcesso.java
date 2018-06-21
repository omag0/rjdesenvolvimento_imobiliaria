package com.rjdesenvolvimento.imobiliaria.domain.enums;

import lombok.Getter;

@Getter
public enum NivelDeAcesso {

    ADMINISTRADOR(1, "Administrador"),
    CLIENTE(2, "Cliente");

    private int codigo;
    private String descricao;

    NivelDeAcesso(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static NivelDeAcesso converteParaEnum(Integer codigo) {
        if (codigo == null) return null;

        for (NivelDeAcesso x : NivelDeAcesso.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }

    public static String escrever(Integer codigo) {
        if (codigo == null) return null;
        for (NivelDeAcesso x : NivelDeAcesso.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x.getDescricao();
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
