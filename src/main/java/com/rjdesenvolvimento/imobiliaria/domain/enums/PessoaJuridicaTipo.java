package com.rjdesenvolvimento.imobiliaria.domain.enums;

import lombok.Getter;

@Getter
public enum PessoaJuridicaTipo {

    CLIENTE(1, "Cliente"),
    PARCEIRO(2, "Parceiro");

    private int codigo;
    private String descricao;

    PessoaJuridicaTipo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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

    public static String escrever(Integer codigo) {
        if (codigo == null) return null;
        for (PessoaJuridicaTipo x : PessoaJuridicaTipo.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x.getDescricao();
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }

}
