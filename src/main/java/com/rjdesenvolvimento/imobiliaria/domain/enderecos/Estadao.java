package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import com.rjdesenvolvimento.imobiliaria.domain.enums.Uf;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estadao extends EntidadeAbstrata<Integer> {

    private String nome;
    private Integer uf;
    @ManyToOne
    @JoinColumn(name = "fk_estado_pais")
    private Pais pais;
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    public Estadao() {
    }

    public Estadao(String nome, Uf uf, Pais pais) {
        this.nome = nome;
        this.uf = uf.getCodigo();
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Uf getUf() {
        return Uf.converteParaEnum(uf);
    }

    public void setUf(Uf uf) {
        this.uf = uf.getCodigo();
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
