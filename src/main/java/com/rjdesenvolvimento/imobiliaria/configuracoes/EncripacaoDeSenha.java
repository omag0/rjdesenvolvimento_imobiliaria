package com.rjdesenvolvimento.imobiliaria.configuracoes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EncripacaoDeSenha {

    @Bean
    public PasswordEncoder codificadorDeSenhas() {
        return  new BCryptPasswordEncoder();
    }
}
