package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais extends EntidadeAbstrata<Integer> {

    private String nome;
    @OneToMany(mappedBy = "pais")
    private List<Estadao> estadaos = new ArrayList<>();

    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Estadao> getEstadaos() {
        return estadaos;
    }

    public void setEstadaos(List<Estadao> estadaos) {
        this.estadaos = estadaos;
    }
}
