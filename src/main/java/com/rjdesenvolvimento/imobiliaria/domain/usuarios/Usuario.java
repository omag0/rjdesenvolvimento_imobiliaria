package com.rjdesenvolvimento.imobiliaria.domain.usuarios;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;

import javax.persistence.*;

@Entity
public class Usuario extends EntidadeAbstrata<Integer> {

    private String login;
    private String senha;
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "pk_pessoafisica")
    private PessoaFisica pessoaFisica;

    public Usuario() {
    }

    public Usuario(String login, String senha, PessoaFisica pessoaFisica) {
        this.login = login;
        this.senha = senha;
        this.pessoaFisica = pessoaFisica;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
}
