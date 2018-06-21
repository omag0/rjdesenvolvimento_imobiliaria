package com.rjdesenvolvimento.imobiliaria.domain.telefones;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaJuridica;
import com.rjdesenvolvimento.imobiliaria.domain.enums.TipoDeTelefone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Telefone extends EntidadeAbstrata<Integer> {

    private String numeroDoTelefone;
    private Integer tipoDeTelefone;
    @JsonBackReference
    @ManyToMany(mappedBy = "telefones")
    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
    @JsonBackReference
    @ManyToMany(mappedBy = "telefones")
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();


    public Telefone() {
    }

    public Telefone(String numeroDoTelefone, TipoDeTelefone tipoDeTelefone) {
        this.numeroDoTelefone = numeroDoTelefone;
        this.tipoDeTelefone = (tipoDeTelefone==null) ? null : tipoDeTelefone.getCodigo();
    }

    public String getTipoDeTelefone() {
        return TipoDeTelefone.escrever(tipoDeTelefone);
    }

    public void setTipoDeTelefone(TipoDeTelefone tipoDeTelefone) {
        this.tipoDeTelefone = tipoDeTelefone.getCodigo();
    }

    public TipoDeTelefone atualizarTelefone() {
        return TipoDeTelefone.converteParaEnum(tipoDeTelefone);
    }
}
