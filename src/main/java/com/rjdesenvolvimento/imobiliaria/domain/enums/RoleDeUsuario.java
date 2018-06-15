package com.rjdesenvolvimento.imobiliaria.domain.enums;

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

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
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
}
