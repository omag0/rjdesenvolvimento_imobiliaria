package com.rjdesenvolvimento.imobiliaria.domain.clientes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rjdesenvolvimento.imobiliaria.domain.enderecos.Bairro;
import com.rjdesenvolvimento.imobiliaria.domain.enums.EstadoCivil;
import com.rjdesenvolvimento.imobiliaria.domain.enums.Genero;
import com.rjdesenvolvimento.imobiliaria.domain.enums.PessoaFisicaTipo;
import com.rjdesenvolvimento.imobiliaria.domain.telefones.Telefone;
import com.rjdesenvolvimento.imobiliaria.domain.usuarios.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoaFisica")
    private Usuario usuario;
    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pessoafisica_endereco", joinColumns = @JoinColumn(name = "pk_pessoafisica"),
            inverseJoinColumns = @JoinColumn(name = "pk_endereco"))
    private List<Bairro> bairros = new ArrayList<>();
    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pessoafisica_telefone", joinColumns = @JoinColumn(name = "fk_pessoafisica"),
            inverseJoinColumns = @JoinColumn(name = "pk_telefone"))
    private List<Telefone> telefones = new ArrayList<>();
    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pessoafisica_pessoajuridica", joinColumns = @JoinColumn(name = "fk_pessoafisica"),
            inverseJoinColumns = @JoinColumn(name = "fk_pessoajuridica"))
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String cpf, String rg, String email, String dataDeNascimento, String naturalidade,
                        String profissao, Genero genero, EstadoCivil estadoCivil, PessoaFisicaTipo pessoaFisicaTipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.naturalidade = naturalidade;
        this.profissao = profissao;
        this.genero = (genero == null) ? null : genero.getCodigo();
        this.estadoCivil = (estadoCivil == null) ? null : estadoCivil.getCodigo();
        this.pessoaFisicaTipo = (pessoaFisicaTipo == null) ? null : pessoaFisicaTipo.getCodigo();
    }

    public String getGenero() {
        return Genero.escrever(genero);
    }

    public void setGenero(Genero genero) {
        this.genero = genero.getCodigo();
    }

    public Genero atualizarGenero() {
        return Genero.converteParaEnum(genero);
    }

    public String getEstadoCivil() {
        return EstadoCivil.escrever(estadoCivil);
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil.getCodigo();
    }

    public EstadoCivil atualizarEstadoCivil() {
        return EstadoCivil.converteParaEnum(estadoCivil);
    }

    public String getPessoaFisicaTipo() {
        return PessoaFisicaTipo.escrever(pessoaFisicaTipo);
    }

    public void setPessoaFisicaTipo(PessoaFisicaTipo pessoaFisicaTipo) {
        this.pessoaFisicaTipo = pessoaFisicaTipo.getCodigo();
    }

    public PessoaFisicaTipo atualizarPessoaFisica() {
        return PessoaFisicaTipo.converteParaEnum(pessoaFisicaTipo);
    }
}
