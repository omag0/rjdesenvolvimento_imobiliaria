package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Pais extends EntidadeAbstrata<Integer> {

    private String nomeDoPais;
    @JsonBackReference
    @OneToMany(mappedBy = "pais")
    private List<Estado> estados = new ArrayList<>();

    public Pais() {
    }

    public Pais(String nomeDoPais) {
        this.nomeDoPais = nomeDoPais;
    }
}
