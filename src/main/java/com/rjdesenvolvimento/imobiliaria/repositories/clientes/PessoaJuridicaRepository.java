package com.rjdesenvolvimento.imobiliaria.repositories.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Integer> {
}
