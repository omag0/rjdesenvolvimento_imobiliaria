package com.rjdesenvolvimento.imobiliaria.services;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.Cliente;
import com.rjdesenvolvimento.imobiliaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Integer id){
        Optional<Cliente> objetoCliente = clienteRepository.findById(id);
        return objetoCliente.orElse(null);
    }

    public Cliente inserir(Cliente objetoCliente){
        objetoCliente.setId(null);
        return clienteRepository.save(objetoCliente);
    }
}
