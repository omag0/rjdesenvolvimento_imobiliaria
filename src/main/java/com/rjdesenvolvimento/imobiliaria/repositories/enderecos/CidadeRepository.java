package com.rjdesenvolvimento.imobiliaria.repositories.enderecos;

import com.rjdesenvolvimento.imobiliaria.domain.enderecos.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
