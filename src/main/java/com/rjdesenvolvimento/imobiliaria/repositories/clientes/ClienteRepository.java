package com.rjdesenvolvimento.imobiliaria.repositories.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
