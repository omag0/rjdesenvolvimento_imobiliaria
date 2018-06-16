package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cidade extends EntidadeAbstrata<Integer> {

    private String nome;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fk_cidade_estado")
    private Estado estado;
    @JsonBackReference
    @OneToMany(mappedBy = "cidade")
    private List<Bairro> bairros = new ArrayList<>();


    public Cidade() {
    }

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }
}
