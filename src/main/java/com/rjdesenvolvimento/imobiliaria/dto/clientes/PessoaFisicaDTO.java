package com.rjdesenvolvimento.imobiliaria.dto.clientes;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PessoaFisicaDTO extends ClienteDTO {

    @NotBlank(message = "Campo Obrigatório")
    @Length(min = 5, max = 255, message = "Digite um nome entre 5 e 255 caracteres")
    private String nome;
    @NotBlank(message = "Campo Obrigatório")
    private String cpf;
    @NotBlank(message = "Campo Obrigatório")
    private String rg;
    private String email;
    @NotBlank(message = "Campo Obrigatório")
    private String dataDeNascimento;
    @NotBlank(message = "Campo Obrigatório")
    private String naturalidade;
    @NotBlank(message = "Campo Obrigatório")
    private String profissao;
    private Integer genero;
    @NotNull
    private Integer estadoCivil;
    @NotNull
    private Integer pessoaFisicaTipo;
    @NotBlank(message = "Campo Obrigatório")
    private String numeroDeTelefone;
    @NotNull
    private Integer tipoDeTelefone;
    @NotBlank(message = "Campo Obrigatório")
    private String nomeDoBairro;
    @NotBlank(message = "Campo Obrigatório")
    private String logradouro;
    @NotBlank(message = "Campo Obrigatório")
    private String numeroLogradouro;
    @NotBlank(message = "Campo Obrigatório")
    private String complemento;
    @NotBlank(message = "Campo Obrigatório")
    private String cep;
    @NotNull
    private Integer tipoDeEndereco;
    @NotNull
    private Integer cidadeId;

    public PessoaFisicaDTO() {
    }
}
