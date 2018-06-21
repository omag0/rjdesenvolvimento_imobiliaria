package com.rjdesenvolvimento.imobiliaria.dto.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.Cliente;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaJuridica;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class ClienteDTO implements Serializable {

    private Integer id;
    private String nome;


    public ClienteDTO() {
    }

    public ClienteDTO(Cliente objetoCliente) {
        if (objetoCliente instanceof PessoaFisica) {
            id = objetoCliente.getId();
            nome = ((PessoaFisica) objetoCliente).getNome();
        }
        if (objetoCliente instanceof PessoaJuridica) {
            id = objetoCliente.getId();
            nome = ((PessoaJuridica) objetoCliente).getRazaoSocial();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteDTO)) return false;
        ClienteDTO that = (ClienteDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}
