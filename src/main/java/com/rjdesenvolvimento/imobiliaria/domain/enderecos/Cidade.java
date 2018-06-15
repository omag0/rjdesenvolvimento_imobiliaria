package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cidade extends EntidadeAbstrata<Integer> {

    private String nome;
    @ManyToOne
    @JoinColumn(name = "fk_cidade_estado")
    private Estadao estado;
    @OneToMany(mappedBy = "cidade")
    private List<Bairro> bairros = new ArrayList<>();


    public Cidade() {
    }

    public Cidade(String nome, Estadao estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estadao getEstado() {
        return estado;
    }

    public void setEstado(Estadao estado) {
        this.estado = estado;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }
}
