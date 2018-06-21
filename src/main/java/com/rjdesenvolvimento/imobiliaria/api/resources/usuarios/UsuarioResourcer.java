package com.rjdesenvolvimento.imobiliaria.api.resources.usuarios;

import com.rjdesenvolvimento.imobiliaria.domain.usuarios.Usuario;
import com.rjdesenvolvimento.imobiliaria.dto.usuarios.UsuarioDTO;
import com.rjdesenvolvimento.imobiliaria.services.usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioResourcer {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Usuario objetoCliente = usuarioService.buscar(id);
        return ResponseEntity.ok().body(objetoCliente);
    }

    @PostMapping()
    public ResponseEntity<Void> inserir(@RequestBody Usuario objetoUsuario) {
        objetoUsuario = usuarioService.inserir(objetoUsuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objetoUsuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody Usuario objetoUsuario, @PathVariable Integer id) {
        objetoUsuario.setId(id);
        objetoUsuario = usuarioService.atualizar(objetoUsuario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id) {
        usuarioService.apagar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
        List<?> listaDeUsuarios = usuarioService.buscarTodos();
        List<UsuarioDTO> listaDeUsuariosDTO = listaDeUsuarios.stream().map(objeto -> new UsuarioDTO((Usuario) objeto)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDeUsuariosDTO);
    }

    @GetMapping(value = "/pagina")
    public ResponseEntity<Page<UsuarioDTO>> buscarPagina(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "linhasPorPagina", defaultValue = "24") Integer linhasPorPagina,
            @RequestParam(value = "ordemDeOrdenacao", defaultValue = "ASC") String ordemDeOrdenacao,
            @RequestParam(value = "campoDeOrdenacao", defaultValue = "pessoaFisica") String campoDeOrdenacao) {
        Page<?> listaDePaginas = usuarioService.buscarPagina(pagina, linhasPorPagina, ordemDeOrdenacao, campoDeOrdenacao);
        Page<UsuarioDTO> listaDeUsuarioDTO = listaDePaginas.map(objeto -> new UsuarioDTO((Usuario) objeto));
        return ResponseEntity.ok().body(listaDeUsuarioDTO);
    }
}
