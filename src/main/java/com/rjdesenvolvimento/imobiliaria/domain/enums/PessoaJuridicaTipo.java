package com.rjdesenvolvimento.imobiliaria.domain.enums;

public enum PessoaJuridicaTipo {

    CLIENTE(1, "Cliente"),
    PARCEIRO(2, "Parceiro");

    private int codigo;
    private String descricao;

    PessoaJuridicaTipo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PessoaJuridicaTipo converteParaEnum(Integer codigo) {
        if (codigo == null) return null;

        for (PessoaJuridicaTipo x : PessoaJuridicaTipo.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
