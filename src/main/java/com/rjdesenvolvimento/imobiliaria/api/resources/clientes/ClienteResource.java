package com.rjdesenvolvimento.imobiliaria.api.resources.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.Cliente;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.dto.clientes.ClienteDTO;
import com.rjdesenvolvimento.imobiliaria.dto.clientes.PessoaFisicaDTO;
import com.rjdesenvolvimento.imobiliaria.services.clientes.ClienteService;
import com.rjdesenvolvimento.imobiliaria.services.clientes.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteResource {

    private final ClienteService clienteService;
    private final PessoaFisicaService pessoaFisicaService;

    @Autowired
    public ClienteResource(ClienteService clienteService, PessoaFisicaService pessoaFisicaService) {
        this.clienteService = clienteService;
        this.pessoaFisicaService = pessoaFisicaService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Cliente objetoCliente = clienteService.buscar(id);
        return ResponseEntity.ok().body(objetoCliente);
    }

    @PostMapping(value = "/pessoafisica")
    public ResponseEntity<Void> inserirPessoaFisica(@Valid @RequestBody PessoaFisicaDTO objetoPessoaFisicaDTO) {
        Cliente objetoPessoaFisica = pessoaFisicaService.converterParaDTO(objetoPessoaFisicaDTO);
        objetoPessoaFisica = pessoaFisicaService.inserir((PessoaFisica) objetoPessoaFisica);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objetoPessoaFisica.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/pessoafisica/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody PessoaFisicaDTO objetoPessoaFisicaDTO, @PathVariable Integer id) {
        PessoaFisica objetoPessoaFisica = pessoaFisicaService.converterParaDTO(objetoPessoaFisicaDTO);
        objetoPessoaFisica.setId(id);
        objetoPessoaFisica = (PessoaFisica) pessoaFisicaService.atualizar(objetoPessoaFisica);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id) {
        clienteService.apagar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<?>> buscarTodos() {
        List<?> listaDeClientes = clienteService.buscarTodos();
        List<ClienteDTO> listaDeClientesDTO = listaDeClientes.stream().map(objeto -> new ClienteDTO((Cliente) objeto)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDeClientesDTO);
    }

    @GetMapping(value = "/pagina")
    public ResponseEntity<Page<?>> bucarPagina(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "linhasPorPagina", defaultValue = "24") Integer linhasPorPagina,
            @RequestParam(value = "ordemDeOrdenacao", defaultValue = "ASC") String ordemDeOrdenacao,
            @RequestParam(value = "campoDeOrdenacao", defaultValue = "id") String campoDeOrdenacao) {
        Page<?> listaDePaginas = clienteService.buscarPagina(pagina, linhasPorPagina, ordemDeOrdenacao, campoDeOrdenacao);
        Page<ClienteDTO> listaDeClientesDTO = listaDePaginas.map(objeto -> new ClienteDTO((Cliente) objeto));
        return ResponseEntity.ok().body(listaDeClientesDTO);
    }

}
