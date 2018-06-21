package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import com.rjdesenvolvimento.imobiliaria.domain.enums.Uf;
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
public class Estado extends EntidadeAbstrata<Integer> {

    private String nomeDoEstado;
    private Integer uf;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fk_estado_pais")
    private Pais pais;
    @JsonBackReference
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(String nomeDoEstado, Uf uf, Pais pais) {
        this.nomeDoEstado = nomeDoEstado;
        this.uf = uf.getCodigo();
        this.pais = pais;
    }

    public String getUf() {
        return Uf.escrever(uf);
    }

    public void setUf(Uf uf) {
        this.uf = uf.getCodigo();
    }

    public Uf atulizarUf() {
        return Uf.converteParaEnum(uf);
    }
}
