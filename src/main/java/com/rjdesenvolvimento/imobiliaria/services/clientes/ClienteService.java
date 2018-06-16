package com.rjdesenvolvimento.imobiliaria.services.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.Cliente;
import com.rjdesenvolvimento.imobiliaria.repositories.clientes.ClienteRepository;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.IntegridadeDeDadosException;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Integer id) {
        Optional<Cliente> objetoCliente = clienteRepository.findById(id);
        return objetoCliente.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado! Id: "
                + id + " Tipo: " + Cliente.class.getName()));
    }

    public Cliente inserir(Cliente objetoCliente) {
        objetoCliente.setId(null);
        return clienteRepository.save(objetoCliente);
    }

    public Cliente atualizar(Cliente objetoCliente) {
        buscar(objetoCliente.getId());
        return clienteRepository.save(objetoCliente);
    }

    public void apagar(Integer id) {
        buscar(id);
        try {
            clienteRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException execaoDeViolacaoDeIntegridade) {
            throw new IntegridadeDeDadosException("Não é possivel excluir um Cliente que contem outras tabelas associadas.");
        }
    }

    public List<?> buscarTodos(){
        return clienteRepository.findAll();
    }
}
