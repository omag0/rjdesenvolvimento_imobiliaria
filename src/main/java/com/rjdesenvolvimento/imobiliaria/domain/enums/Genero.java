package com.rjdesenvolvimento.imobiliaria.domain.enums;

import lombok.Getter;

@Getter
public enum Genero {

    FEMININO(1, "Feminino"),
    MASCULINO(2, "Masculino");

    private int codigo;
    private String descricao;

    Genero(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }


    public static Genero converteParaEnum(Integer codigo) {
        if (codigo == null) return null;
        for (Genero x : Genero.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }

    public static String escrever(Integer codigo) {
        if (codigo == null) return null;
        for (Genero x : Genero.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x.getDescricao();
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
