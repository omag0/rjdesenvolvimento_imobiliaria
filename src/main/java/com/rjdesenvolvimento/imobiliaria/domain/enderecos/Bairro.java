package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaJuridica;
import com.rjdesenvolvimento.imobiliaria.domain.enums.TipoDeEndereco;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bairro extends EntidadeAbstrata<Integer> {

    private String nome;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private Integer tipoDeEndereco;
    @ManyToOne
    @JoinColumn(name = "fk_bairro_cidade")
    private Cidade cidade;
    @ManyToMany(mappedBy = "enderecos")
     private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
    @ManyToMany(mappedBy = "enderecos")
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    public Bairro() {
    }

    public Bairro(String nome, String logradouro, String numero, String complemento, String cep,
                  TipoDeEndereco tipoDeEndereco, Cidade cidade) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.tipoDeEndereco = tipoDeEndereco.getCodigo();
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public TipoDeEndereco getTipoDeEndereco() {
        return TipoDeEndereco.converteParaEnum(tipoDeEndereco);
    }

    public void setTipoDeEndereco(TipoDeEndereco tipoDeEndereco) {
        this.tipoDeEndereco = tipoDeEndereco.getCodigo();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<PessoaFisica> getPessoasFisicas() {
        return pessoasFisicas;
    }

    public void setPessoasFisicas(List<PessoaFisica> pessoasFisicas) {
        this.pessoasFisicas = pessoasFisicas;
    }

    public List<PessoaJuridica> getPessoasJuridicas() {
        return pessoasJuridicas;
    }

    public void setPessoasJuridicas(List<PessoaJuridica> pessoasJuridicas) {
        this.pessoasJuridicas = pessoasJuridicas;
    }
}
