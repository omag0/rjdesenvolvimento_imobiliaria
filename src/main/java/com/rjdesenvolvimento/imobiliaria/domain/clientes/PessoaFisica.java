package com.rjdesenvolvimento.imobiliaria.domain.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.enderecos.Bairro;
import com.rjdesenvolvimento.imobiliaria.domain.enums.EstadoCivil;
import com.rjdesenvolvimento.imobiliaria.domain.enums.Genero;
import com.rjdesenvolvimento.imobiliaria.domain.enums.PessoaFisicaTipo;
import com.rjdesenvolvimento.imobiliaria.domain.telefones.Telefone;
import com.rjdesenvolvimento.imobiliaria.domain.usuarios.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PessoaFisica extends Cliente {

    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private String dataDeNascimento;
    private String naturalidade;
    private String profissao;
    private Integer genero;
    private Integer estadoCivil;
    private Integer pessoaFisicaTipo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoaFisica")
    private Usuario usuario;
    @ManyToMany
    @JoinTable(name = "pessoafisica_endereco", joinColumns = @JoinColumn(name = "pk_pessoafisica"),
            inverseJoinColumns = @JoinColumn(name = "pk_endereco"))
    private List<Bairro> enderecos = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "pessoafisica_telefone", joinColumns = @JoinColumn(name = "fk_pessoafisica"),
            inverseJoinColumns = @JoinColumn(name = "pk_telefone"))
    private List<Telefone> telefones = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "pk_pessoafisica_pessoajuridica")
    private PessoaJuridica pessoaJuridica;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String cpf, String rg, String email, String dataDeNascimento, String naturalidade,
                        String profissao, Genero genero, EstadoCivil estadoCivil, PessoaFisicaTipo pessoaFisicaTipo,
                        PessoaJuridica pessoaJuridica, Usuario usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.naturalidade = naturalidade;
        this.profissao = profissao;
        this.genero = genero.getCodigo();
        this.estadoCivil = estadoCivil.getCodigo();
        this.pessoaFisicaTipo = pessoaFisicaTipo.getCodigo();
        this.pessoaJuridica = pessoaJuridica;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Genero getGenero() {
        return Genero.converteParaEnum(genero);
    }

    public void setGenero(Genero genero) {
        this.genero = genero.getCodigo();
    }

    public EstadoCivil getEstadoCivil() {
        return EstadoCivil.converteParaEnum(estadoCivil);
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil.getCodigo();
    }

    public PessoaFisicaTipo getPessoaFisicaTipo() {
        return PessoaFisicaTipo.converteParaEnum(pessoaFisicaTipo);
    }

    public void setPessoaFisicaTipo(PessoaFisicaTipo pessoaFisicaTipo) {
        this.pessoaFisicaTipo = pessoaFisicaTipo.getCodigo();
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

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
