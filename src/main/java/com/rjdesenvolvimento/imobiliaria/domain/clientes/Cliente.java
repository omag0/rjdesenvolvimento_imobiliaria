package com.rjdesenvolvimento.imobiliaria.domain.clientes;

import com.rjdesenvolvimento.imobiliaria.domain.EntidadeAbstrata;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente extends EntidadeAbstrata<Integer> {
}
