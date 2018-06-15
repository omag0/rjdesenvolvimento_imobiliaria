package com.rjdesenvolvimento.imobiliaria.domain.enums;

public enum PessoaFisicaTipo {

    CLIENTE (1, "Cliente"),
    FUNCIONARIO(2, "Funcionário");

    private int codigo;
    private String descricao;

    PessoaFisicaTipo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PessoaFisicaTipo converteParaEnum(Integer codigo) {
        if (codigo == null) return null;

        for (PessoaFisicaTipo x : PessoaFisicaTipo.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
