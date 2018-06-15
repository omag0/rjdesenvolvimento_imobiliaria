package com.rjdesenvolvimento.imobiliaria.domain.enums;

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

    public int getCodigo() { return codigo; }

    public String getDescricao() { return descricao; }

    public static EstadoCivil converteParaEnum(Integer codigo) {
        if (codigo == null) return null;

        for (EstadoCivil x : EstadoCivil.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
