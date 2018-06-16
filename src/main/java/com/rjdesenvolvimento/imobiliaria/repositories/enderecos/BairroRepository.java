package com.rjdesenvolvimento.imobiliaria.repositories.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.enderecos.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {
}
