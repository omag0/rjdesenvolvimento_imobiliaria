package com.rjdesenvolvimento.imobiliaria.domain.enums;

public enum TipoDeEndereco {

    COMERCIAL(1, "Comercial"),
    RESIDENCIAL(2, "Residencial");

    private int codigo;
    private String descricao;


    TipoDeEndereco(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoDeEndereco converteParaEnum(Integer codigo) {
        if (codigo == null) return null;

        for (TipoDeEndereco x : TipoDeEndereco.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
