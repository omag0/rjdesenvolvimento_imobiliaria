package com.rjdesenvolvimento.imobiliaria.repositories.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.enderecos.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
}
