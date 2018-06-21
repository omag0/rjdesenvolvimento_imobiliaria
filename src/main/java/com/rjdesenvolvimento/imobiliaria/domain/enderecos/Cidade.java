package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cidade extends EntidadeAbstrata<Integer> {

    private String nomeDaCidade;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fk_cidade_estado")
    private Estado estado;
    @JsonBackReference
    @OneToMany(mappedBy = "cidade")
    private List<Bairro> bairros = new ArrayList<>();


    public Cidade() {
    }

    public Cidade(Integer id, String nomeDaCidade, Estado estado) {
        super.setId(id);
        this.nomeDaCidade = nomeDaCidade;
        this.estado = estado;
    }
}
