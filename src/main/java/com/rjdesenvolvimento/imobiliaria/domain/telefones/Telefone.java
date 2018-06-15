package com.rjdesenvolvimento.imobiliaria.domain.telefones;

import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaJuridica;
import com.rjdesenvolvimento.imobiliaria.domain.enums.TipoDeTelefone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Telefone extends EntidadeAbstrata<Integer> {

    private String numero;
    private Integer tipoDeTelefone;
    @ManyToMany(mappedBy = "telefones")
    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
    @ManyToMany(mappedBy = "telefones")
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();


    public Telefone() {
    }

    public Telefone(String numero, TipoDeTelefone tipoDeTelefone) {
        this.numero = numero;
        this.tipoDeTelefone = tipoDeTelefone.getCodigo();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoDeTelefone getTipoDeTelefone() {
        return TipoDeTelefone.converteParaEnum(tipoDeTelefone);
    }

    public void setTipoDeTelefone(TipoDeTelefone tipoDeTelefone) {
        this.tipoDeTelefone = tipoDeTelefone.getCodigo();
    }

    public List<PessoaFisica> getPessoasFisicas() {
        return pessoasFisicas;
    }

    public void setPessoasFisicas(List<PessoaFisica> pessoasFisicas) {
        this.pessoasFisicas = pessoasFisicas;
    }


    public List<PessoaJuridica> getPessoasJuridicas() {
        return pessoasJuridicas;
    }

    public void setPessoasJuridicas(List<PessoaJuridica> pessoasJuridicas) {
        this.pessoasJuridicas = pessoasJuridicas;
    }
}
