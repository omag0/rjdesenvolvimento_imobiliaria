package com.rjdesenvolvimento.imobiliaria.domain.enums;

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

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
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
}
