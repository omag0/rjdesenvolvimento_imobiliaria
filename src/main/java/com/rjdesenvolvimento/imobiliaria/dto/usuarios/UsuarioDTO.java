package com.rjdesenvolvimento.imobiliaria.dto.usuarios;

import com.rjdesenvolvimento.imobiliaria.domain.usuarios.Usuario;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private Integer id;
    private String login;
    private String nome;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario objetoUsuario) {
        id = objetoUsuario.getId();
        login = objetoUsuario.getLogin();
        nome = objetoUsuario.getPessoaFisica().getNome();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
