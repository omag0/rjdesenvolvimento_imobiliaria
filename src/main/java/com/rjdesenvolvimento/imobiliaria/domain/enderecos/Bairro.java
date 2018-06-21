package com.rjdesenvolvimento.imobiliaria.domain.enderecos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaJuridica;
import com.rjdesenvolvimento.imobiliaria.domain.enums.TipoDeEndereco;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Bairro extends EntidadeAbstrata<Integer> {

    private String nomeDoBairro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private Integer tipoDeEndereco;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fk_bairro_cidade")
    private Cidade cidade;
    @JsonBackReference
    @ManyToMany(mappedBy = "bairros")
    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
    @JsonBackReference
    @ManyToMany(mappedBy = "bairros")
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    public Bairro() {
    }

    public Bairro(String nomeDoBairro, String logradouro, String numero, String complemento, String cep,
                  TipoDeEndereco tipoDeEndereco, Cidade cidade) {
        this.nomeDoBairro = nomeDoBairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.tipoDeEndereco = (tipoDeEndereco==null) ? null : tipoDeEndereco.getCodigo();
        this.cidade = cidade;
    }

    public String getTipoDeEndereco() {
        return TipoDeEndereco.escrever(tipoDeEndereco);
    }

    public void setTipoDeEndereco(TipoDeEndereco tipoDeEndereco) {
        this.tipoDeEndereco = tipoDeEndereco.getCodigo();
    }

    public TipoDeEndereco atualizarEndereco() {
        return TipoDeEndereco.converteParaEnum(tipoDeEndereco);
    }
}
