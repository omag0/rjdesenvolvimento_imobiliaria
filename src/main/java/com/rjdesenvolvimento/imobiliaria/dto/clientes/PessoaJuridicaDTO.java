package com.rjdesenvolvimento.imobiliaria.dto.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaJuridica;
import com.rjdesenvolvimento.imobiliaria.domain.enums.PessoaJuridicaTipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaJuridicaDTO extends ClienteDTO {

    private String razaoSocial;
    private String nomeFantasia;
    private String dataDeConstituicao;
    private String inscricaoEstadual;
    private String inscricaoFederal;
    private PessoaJuridicaTipo pessoaJuridicaTipo;

    public PessoaJuridicaDTO() {
    }

    public PessoaJuridicaDTO(PessoaJuridica objetoPessoaJuridica) {
        this.razaoSocial = objetoPessoaJuridica.getRazaoSocial();
        this.nomeFantasia = objetoPessoaJuridica.getNomeFantasia();
        this.dataDeConstituicao = objetoPessoaJuridica.getDataDeConstituicao();
        this.inscricaoEstadual = objetoPessoaJuridica.getInscricaoEstadual();
        this.inscricaoFederal = objetoPessoaJuridica.getInscricaoFederal();
    }
}
