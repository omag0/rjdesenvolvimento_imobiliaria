package com.rjdesenvolvimento.imobiliaria.domain.usuarios;

import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;

import javax.persistence.*;

@Entity
public class Usuario extends EntidadeAbstrata<Integer> {

    @Id
    private Integer id;
    private String login;
    private String senha;
    @OneToOne
    @JoinColumn(name = "pk_pessoafisica")
    @MapsId
    private PessoaFisica pessoaFisica;

    public Usuario() {
    }

    public Usuario(Integer id, String login, String senha, PessoaFisica pessoaFisica) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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
