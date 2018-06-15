package com.rjdesenvolvimento.imobiliaria.domain.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.enderecos.Bairro;
import com.rjdesenvolvimento.imobiliaria.domain.enums.PessoaJuridicaTipo;
import com.rjdesenvolvimento.imobiliaria.domain.telefones.Telefone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PessoaJuridica extends Cliente {

    private String razaoSocial;
    private String nomeFantasia;
    private String dataDeConstituicao;
    private String inscricaoEstadual;
    private String inscricaoFederal;
    private Integer pessoaJuridicaTipo;
    @ManyToMany
    @JoinTable(name = "pessoajuridica_endereco", joinColumns = @JoinColumn(name = "fk_pessoajuridica"),
            inverseJoinColumns = @JoinColumn(name = "fk_endereco"))
    private List<Bairro> enderecos = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "pessoajuridica_telefone", joinColumns = @JoinColumn(name = "fk_pessoajuridica"),
            inverseJoinColumns = @JoinColumn(name = "fk_telefone"))
    private List<Telefone> telefones = new ArrayList<>();
    @OneToMany(mappedBy = "pessoaJuridica")
    private List<PessoaFisica> sociosProprietarios = new ArrayList<>();

    public PessoaJuridica(String razaoSocial, String nomeFantasia, String dataDeConstituicao, String inscricaoEstadual,
                          String inscricaoFederal, PessoaJuridicaTipo pessoaJuridicaTipo) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.dataDeConstituicao = dataDeConstituicao;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoFederal = inscricaoFederal;
        this.pessoaJuridicaTipo = pessoaJuridicaTipo.getCodigo();
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getDataDeConstituicao() {
        return dataDeConstituicao;
    }

    public void setDataDeConstituicao(String dataDeConstituicao) {
        this.dataDeConstituicao = dataDeConstituicao;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoFederal() {
        return inscricaoFederal;
    }

    public void setInscricaoFederal(String inscricaoFederal) {
        this.inscricaoFederal = inscricaoFederal;
    }

    public PessoaJuridicaTipo getPessoaJuridicaTipo() {
        return PessoaJuridicaTipo.converteParaEnum(pessoaJuridicaTipo);
    }

    public void setPessoaJuridicaTipo(PessoaJuridicaTipo pessoaJuridicaTipo) {
        this.pessoaJuridicaTipo = pessoaJuridicaTipo.getCodigo();
    }

    public List<Bairro> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Bairro> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<PessoaFisica> getSociosProprietarios() {
        return sociosProprietarios;
    }

    public void setSociosProprietarios(List<PessoaFisica> sociosProprietarios) {
        this.sociosProprietarios = sociosProprietarios;
    }
}
