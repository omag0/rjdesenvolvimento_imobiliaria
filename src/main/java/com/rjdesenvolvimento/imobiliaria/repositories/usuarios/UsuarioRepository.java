package com.rjdesenvolvimento.imobiliaria.repositories.usuarios;

import com.rjdesenvolvimento.imobiliaria.domain.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
