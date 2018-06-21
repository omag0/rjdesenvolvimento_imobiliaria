package com.rjdesenvolvimento.imobiliaria.domain.enums;

import lombok.Getter;

@Getter
public enum Uf {

    AC(1, "AC"),
    AL(2, "AL"),
    AM(3, "AM"),
    AP(4, "AP"),
    BA(5, "BA"),
    CE(6, "CE"),
    DF(7, "DF"),
    ES(8, "ES"),
    GO(9, "GO"),
    MA(10, "MA"),
    MG(11, "MG"),
    MS(12, "MS"),
    MT(13, "MT"),
    PA(14, "PA"),
    PB(15, "PB"),
    PE(16, "PE"),
    PI(17, "PI"),
    PR(18, "PR"),
    RJ(19, "RJ"),
    RN(20, "RN"),
    RO(21, "RO"),
    RR(22, "RR"),
    RS(23, "RS"),
    SC(24, "SC"),
    SE(25, "SE"),
    SP(26, "SP"),
    TO(27, "TO");

    private int codigo;
    private String descricao;

    Uf(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Uf converteParaEnum(Integer codigo) {
        if (codigo == null) return null;

        for (Uf x : Uf.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }

    public static String escrever(Integer codigo) {
        if (codigo == null) return null;
        for (Uf x : Uf.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x.getDescricao();
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}

