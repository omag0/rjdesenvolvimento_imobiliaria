package com.rjdesenvolvimento.imobiliaria.repositories.telefones;

import com.rjdesenvolvimento.imobiliaria.domain.telefones.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
}
