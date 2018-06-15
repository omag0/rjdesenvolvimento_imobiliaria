package com.rjdesenvolvimento.imobiliaria.api.resources.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.Cliente;
import com.rjdesenvolvimento.imobiliaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> localizar(@PathVariable Integer id) {
        Cliente objetoCliente = clienteService.buscar(id);
        return ResponseEntity.ok().body(objetoCliente);
    }

    @PostMapping()
    public ResponseEntity<Void> inserir(@RequestBody Cliente objetoCliente) {
        objetoCliente = clienteService.inserir(objetoCliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objetoCliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
