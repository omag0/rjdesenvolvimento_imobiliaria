package com.rjdesenvolvimento.imobiliaria.services.usuarios;

import com.rjdesenvolvimento.imobiliaria.domain.usuarios.Usuario;
import com.rjdesenvolvimento.imobiliaria.repositories.usuarios.UsuarioRepository;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.IntegridadeDeDadosNaDelecaoException;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscar(Integer id) {
        Optional<Usuario> objetoUsuario = usuarioRepository.findById(id);
        return objetoUsuario.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado! Id: "
                + id + " Tipo: " + Usuario.class.getName()));
    }

    public Usuario inserir(Usuario objetoUsuario) {
        objetoUsuario.setId(null);
        return usuarioRepository.save(objetoUsuario);
    }

    public Usuario atualizar(Usuario objetoUsuario) {
        buscar(objetoUsuario.getId());
        return usuarioRepository.save(objetoUsuario);
    }

    public void apagar(Integer id) {
        buscar(id);
        try {
            usuarioRepository.deleteById(id);
        } catch (DataIntegrityViolationException execaoDeViolacaoDeIntegridade) {
            throw new IntegridadeDeDadosNaDelecaoException("Não é possivel excluir um Cliente que contem outras tabelas associadas.");
        }
    }

    public List<?> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Page<Usuario> buscarPagina(Integer pagina, Integer linhasPorPagina, String ordemparaOrdenacao, String campoDeOrdenacao) {
        PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Sort.Direction.valueOf(ordemparaOrdenacao), campoDeOrdenacao);
        return usuarioRepository.findAll(pageRequest);
    }
}