package com.rjdesenvolvimento.imobiliaria.domain.clientes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rjdesenvolvimento.imobiliaria.domain.enderecos.Bairro;
import com.rjdesenvolvimento.imobiliaria.domain.enums.PessoaJuridicaTipo;
import com.rjdesenvolvimento.imobiliaria.domain.telefones.Telefone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class PessoaJuridica extends Cliente {

    private String razaoSocial;
    private String nomeFantasia;
    private String dataDeConstituicao;
    private String inscricaoEstadual;
    private String inscricaoFederal;
    private Integer pessoaJuridicaTipo;
    @JsonManagedReference
    @ManyToMany(mappedBy = "pessoasJuridicas")
    private List<PessoaFisica> sociosProprietarios = new ArrayList<>();
    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pessoajuridica_endereco", joinColumns = @JoinColumn(name = "fk_pessoajuridica"),
            inverseJoinColumns = @JoinColumn(name = "fk_endereco"))
    private List<Bairro> bairros = new ArrayList<>();
    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pessoajuridica_telefone", joinColumns = @JoinColumn(name = "fk_pessoajuridica"),
            inverseJoinColumns = @JoinColumn(name = "fk_telefone"))
    private List<Telefone> telefones = new ArrayList<>();

    public PessoaJuridica() {
    }

    public PessoaJuridica(String razaoSocial, String nomeFantasia, String dataDeConstituicao, String inscricaoEstadual,
                          String inscricaoFederal, PessoaJuridicaTipo pessoaJuridicaTipo) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.dataDeConstituicao = dataDeConstituicao;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoFederal = inscricaoFederal;
        this.pessoaJuridicaTipo = pessoaJuridicaTipo.getCodigo();
    }

    public String getPessoaJuridicaTipo() {
        return PessoaJuridicaTipo.escrever(pessoaJuridicaTipo);
    }

    public void setPessoaJuridicaTipo(PessoaJuridicaTipo pessoaJuridicaTipo) {
        this.pessoaJuridicaTipo = pessoaJuridicaTipo.getCodigo();
    }

    public PessoaJuridicaTipo atualizarPessoaJuridica() {
        return PessoaJuridicaTipo.converteParaEnum(pessoaJuridicaTipo);
    }
}
