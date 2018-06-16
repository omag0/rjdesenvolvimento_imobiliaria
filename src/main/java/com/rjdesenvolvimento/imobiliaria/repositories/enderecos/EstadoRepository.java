package com.rjdesenvolvimento.imobiliaria.repositories.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.enderecos.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
