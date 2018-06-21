package com.rjdesenvolvimento.imobiliaria.services.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.Cliente;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.enderecos.Bairro;
import com.rjdesenvolvimento.imobiliaria.domain.enderecos.Cidade;
import com.rjdesenvolvimento.imobiliaria.domain.enums.*;
import com.rjdesenvolvimento.imobiliaria.domain.telefones.Telefone;
import com.rjdesenvolvimento.imobiliaria.dto.clientes.PessoaFisicaDTO;
import com.rjdesenvolvimento.imobiliaria.repositories.clientes.ClienteRepository;
import com.rjdesenvolvimento.imobiliaria.repositories.clientes.PessoaFisicaRepository;
import com.rjdesenvolvimento.imobiliaria.repositories.enderecos.BairroRepository;
import com.rjdesenvolvimento.imobiliaria.repositories.telefones.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class PessoaFisicaService {

    private final BairroRepository bairroRepository;
    private final PessoaFisicaRepository pessoaFisicaRepository;
    private final TelefoneRepository telefoneRepository;
    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    @Autowired
    public PessoaFisicaService(BairroRepository bairroRepository, PessoaFisicaRepository clienteRepository, TelefoneRepository telefoneRepository, ClienteService clienteService, ClienteRepository clienteRepository1) {
        this.bairroRepository = bairroRepository;
        this.pessoaFisicaRepository = clienteRepository;
        this.telefoneRepository = telefoneRepository;
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository1;
    }

    @Transactional
    public Cliente inserir(PessoaFisica objetoPessoaFisica) {
        objetoPessoaFisica.setId(null);
        bairroRepository.saveAll(objetoPessoaFisica.getBairros());
        telefoneRepository.saveAll(objetoPessoaFisica.getTelefones());
        objetoPessoaFisica = pessoaFisicaRepository.save(objetoPessoaFisica);
        return objetoPessoaFisica;
    }


    public Cliente atualizar(PessoaFisica objetoPessoaFisica) {
        Cliente novoObjetoPessoaFisica = clienteService.buscar(objetoPessoaFisica.getId());
        atualizarDados((PessoaFisica) novoObjetoPessoaFisica, objetoPessoaFisica);
        return clienteRepository.save(novoObjetoPessoaFisica);
    }

    private void atualizarDados(PessoaFisica novoObjetoPessoaFisica, PessoaFisica objetoPessoaFisica) {
        if ((objetoPessoaFisica.getNome() != null)) {
            novoObjetoPessoaFisica.setNome(objetoPessoaFisica.getNome());
        }
        if (objetoPessoaFisica.getCpf() != null) {
            novoObjetoPessoaFisica.setCpf(objetoPessoaFisica.getCpf());
        }
        if (objetoPessoaFisica.getRg() != null) {
            novoObjetoPessoaFisica.setRg(objetoPessoaFisica.getRg());
        }
        if (objetoPessoaFisica.getEmail() != null) {
            novoObjetoPessoaFisica.setEmail(objetoPessoaFisica.getEmail());
        }
        if (objetoPessoaFisica.getDataDeNascimento() != null) {
            novoObjetoPessoaFisica.setDataDeNascimento(objetoPessoaFisica.getDataDeNascimento());
        }
        if (objetoPessoaFisica.getNaturalidade() != null) {
            novoObjetoPessoaFisica.setNaturalidade(objetoPessoaFisica.getNaturalidade());
        }
        if (objetoPessoaFisica.getProfissao() != null) {
            novoObjetoPessoaFisica.setProfissao(objetoPessoaFisica.getProfissao());
        }
        if (objetoPessoaFisica.getGenero() != null) {
            novoObjetoPessoaFisica.setGenero(objetoPessoaFisica.atualizarGenero());
        }
        if (objetoPessoaFisica.getEstadoCivil() != null) {
            novoObjetoPessoaFisica.setEstadoCivil(objetoPessoaFisica.atualizarEstadoCivil());
        }
        if (objetoPessoaFisica.getPessoaFisicaTipo() != null) {
            novoObjetoPessoaFisica.setPessoaFisicaTipo(objetoPessoaFisica.atualizarPessoaFisica());
        }
    }

    public PessoaFisica converterParaDTO(PessoaFisicaDTO pessoaFisicaDTO) {
        Cidade cidade = new Cidade(pessoaFisicaDTO.getCidadeId(), null, null);
        Bairro bairro = new Bairro(pessoaFisicaDTO.getNomeDoBairro(), pessoaFisicaDTO.getLogradouro(), pessoaFisicaDTO.getNumeroLogradouro(),
                pessoaFisicaDTO.getComplemento(), pessoaFisicaDTO.getCep(), TipoDeEndereco.converteParaEnum(pessoaFisicaDTO.getTipoDeEndereco()), cidade);
        Telefone telefone = new Telefone(pessoaFisicaDTO.getNumeroDeTelefone(), TipoDeTelefone.converteParaEnum(pessoaFisicaDTO.getTipoDeTelefone()));
        Cliente cliente = new PessoaFisica(pessoaFisicaDTO.getNome(), pessoaFisicaDTO.getCpf(), pessoaFisicaDTO.getRg(),
                pessoaFisicaDTO.getEmail(), pessoaFisicaDTO.getDataDeNascimento(), pessoaFisicaDTO.getNaturalidade(),
                pessoaFisicaDTO.getProfissao(), Genero.converteParaEnum(pessoaFisicaDTO.getGenero()), EstadoCivil.converteParaEnum(pessoaFisicaDTO.getEstadoCivil()),
                PessoaFisicaTipo.converteParaEnum(pessoaFisicaDTO.getPessoaFisicaTipo()));

        cidade.getBairros().addAll(Arrays.asList(bairro));
        bairro.getPessoasFisicas().addAll(Arrays.asList((PessoaFisica) cliente));
        telefone.getPessoasFisicas().addAll(Arrays.asList((PessoaFisica) cliente));
        ((PessoaFisica) cliente).getBairros().addAll(Arrays.asList(bairro));
        ((PessoaFisica) cliente).getTelefones().addAll(Arrays.asList(telefone));
        return (PessoaFisica) cliente;
    }
}

