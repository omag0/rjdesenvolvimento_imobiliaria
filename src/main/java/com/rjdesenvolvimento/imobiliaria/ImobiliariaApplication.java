package com.rjdesenvolvimento.imobiliaria;

import com.rjdesenvolvimento.imobiliaria.domain.clientes.Cliente;
import com.rjdesenvolvimento.imobiliaria.domain.clientes.PessoaFisica;
import com.rjdesenvolvimento.imobiliaria.domain.enums.EstadoCivil;
import com.rjdesenvolvimento.imobiliaria.domain.enums.Genero;
import com.rjdesenvolvimento.imobiliaria.domain.enums.PessoaFisicaTipo;
import com.rjdesenvolvimento.imobiliaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ImobiliariaApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(ImobiliariaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente cliente = new PessoaFisica("Rodrigo", "012.668.833-80", "12345", "rodrigo_batistasantos@hotmail.com",
                "16/04/1985", "Goiania0", "Desenvolvedor", Genero.MASCULINO, EstadoCivil.CASADO, PessoaFisicaTipo.CLIENTE,
                null, null);

        clienteRepository.saveAll(Arrays.asList(cliente));
    }
}
