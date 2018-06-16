package com.rjdesenvolvimento.imobiliaria.api.resources.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.Cliente;
import com.rjdesenvolvimento.imobiliaria.dto.clientes.ClienteDTO;
import com.rjdesenvolvimento.imobiliaria.services.clientes.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Cliente objetoCliente = clienteService.buscar(id);
        return ResponseEntity.ok().body(objetoCliente);
    }

    @PostMapping()
    public ResponseEntity<Void> inserir(@RequestBody Cliente objetoCliente) {
        objetoCliente = clienteService.inserir(objetoCliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objetoCliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody Cliente objetoCliente, @PathVariable Integer id) {
        objetoCliente.setId(id);
        objetoCliente = clienteService.atualizar(objetoCliente);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id) {
        clienteService.apagar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodos() {
        List<?> listaDeClientes = clienteService.buscarTodos();
        List<ClienteDTO> listaDeClientesDTO = listaDeClientes.stream().map(objeto -> new ClienteDTO((Cliente) objeto)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDeClientesDTO);
    }

}
