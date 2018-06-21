package com.rjdesenvolvimento.imobiliaria.services.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.Cliente;
import com.rjdesenvolvimento.imobiliaria.repositories.clientes.ClienteRepository;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscar(Integer id) {
        Optional<Cliente> objetoCliente = clienteRepository.findById(id);
        return objetoCliente.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado! Id: "
                + id + " Tipo: " + Cliente.class.getName()));
    }

    public void apagar(Integer id) {
        buscar(id);
        clienteRepository.deleteById(id);
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Page<Cliente> buscarPagina(Integer pagina, Integer linhasPorPagina, String ordemparaOrdenacao, String campoDeOrdenacao) {
        PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Sort.Direction.valueOf(ordemparaOrdenacao), campoDeOrdenacao);
        return clienteRepository.findAll(pageRequest);
    }
}
