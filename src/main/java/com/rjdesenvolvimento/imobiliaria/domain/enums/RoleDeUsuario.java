package com.rjdesenvolvimento.imobiliaria.domain.enums;

import lombok.Getter;

@Getter
public enum RoleDeUsuario {

    ADMINISTRADOR(1, "Administrador"),
    FUNCIONARIO(2, "Funcionário"),
    CONTADOR(3, "Contador"),
    USUARIO(4, "Usuário");

    private int codigo;
    private String descricao;

    RoleDeUsuario(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static RoleDeUsuario converteParaEnum(Integer codigo) {
        if (codigo == null) return null;

        for (RoleDeUsuario x : RoleDeUsuario.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }

    public static String escrever(Integer codigo) {
        if (codigo == null) return null;
        for (RoleDeUsuario x : RoleDeUsuario.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x.getDescricao();
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
