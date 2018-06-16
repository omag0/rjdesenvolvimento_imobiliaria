package com.rjdesenvolvimento.imobiliaria.api.resources.usuarios;

import com.rjdesenvolvimento.imobiliaria.domain.usuarios.Usuario;
import com.rjdesenvolvimento.imobiliaria.services.usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioResourcer {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> localizar(@PathVariable Integer id) {
        Usuario objetoCliente = usuarioService.buscar(id);
        return ResponseEntity.ok().body(objetoCliente);
    }

    @PostMapping()
    public ResponseEntity<Void> inserir(@RequestBody Usuario objetoUsuario) {
        objetoUsuario = usuarioService.inserir(objetoUsuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objetoUsuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
