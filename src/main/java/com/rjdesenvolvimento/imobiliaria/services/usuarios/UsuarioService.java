package com.rjdesenvolvimento.imobiliaria.services.usuarios;

import com.rjdesenvolvimento.imobiliaria.domain.usuarios.Usuario;
import com.rjdesenvolvimento.imobiliaria.repositories.usuarios.UsuarioRepository;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    }}
