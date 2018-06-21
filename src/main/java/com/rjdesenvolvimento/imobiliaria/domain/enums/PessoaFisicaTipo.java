package com.rjdesenvolvimento.imobiliaria.domain.enums;

import lombok.Getter;

@Getter
public enum PessoaFisicaTipo {

    CLIENTE(1, "Cliente"),
    FUNCIONARIO(2, "Funcionário");

    private int codigo;
    private String descricao;

    PessoaFisicaTipo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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

    public static String escrever(Integer codigo) {
        if (codigo == null) return null;
        for (PessoaFisicaTipo x : PessoaFisicaTipo.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x.getDescricao();
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
