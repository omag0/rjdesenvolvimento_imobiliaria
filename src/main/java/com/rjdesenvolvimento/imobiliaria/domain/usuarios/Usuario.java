package com.rjdesenvolvimento.imobiliaria.domain.usuarios;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.enums.RoleDeUsuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Usuario extends EntidadeAbstrata<Integer> {

    private String login;
    private String senha;
    private Integer roleDeUsuario;
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "pk_pessoafisica")
    private PessoaFisica pessoaFisica;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfis")
    private Set<Integer> perfis = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String login, String senha, PessoaFisica pessoaFisica, RoleDeUsuario roleDeUsuario) {
        this.login = login;
        this.senha = senha;
        this.pessoaFisica = pessoaFisica;
        this.roleDeUsuario = roleDeUsuario.getCodigo();
    }

    public String getRoleDeUsuario() {
        return RoleDeUsuario.escrever(roleDeUsuario);
    }

    public void setRoleDeUsuario(RoleDeUsuario roleDeUsuario) {
        this.roleDeUsuario = roleDeUsuario.getCodigo();
    }

    private RoleDeUsuario atualizarUsuario() {
        return RoleDeUsuario.converteParaEnum(roleDeUsuario);
    }
}
