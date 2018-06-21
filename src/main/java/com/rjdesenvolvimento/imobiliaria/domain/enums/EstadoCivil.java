package com.rjdesenvolvimento.imobiliaria.domain.enums;

import lombok.Getter;

@Getter
public enum EstadoCivil {

    CASADO(1, "Casado"),
    DIVORCIADO(2, "Divorciado"),
    SOLTEIRO(3, "Solteiro"),
    UNIAOESTAVEL(4, "União Estável"),
    VIUVO(5, "Viúvo");

    private int codigo;
    private String descricao;

    EstadoCivil(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }


    public static EstadoCivil converteParaEnum(Integer codigo) {
        if (codigo == null) return null;

        for (EstadoCivil x : EstadoCivil.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }

    public static String escrever(Integer codigo) {
        if (codigo == null) return null;
        for (EstadoCivil x : EstadoCivil.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x.getDescricao();
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }


}
