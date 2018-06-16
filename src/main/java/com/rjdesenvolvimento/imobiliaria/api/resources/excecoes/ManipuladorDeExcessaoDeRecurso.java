package com.rjdesenvolvimento.imobiliaria.api.resources.excecoes;

import com.rjdesenvolvimento.imobiliaria.services.excecoes.IntegridadeDeDadosException;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipuladorDeExcessaoDeRecurso {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException objetoNaoEncontrado, HttpServletRequest request) {

        ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), objetoNaoEncontrado.getMessage(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(IntegridadeDeDadosException.class)
    public ResponseEntity<ErroPadrao> integridadeDeDados(IntegridadeDeDadosException integridadeDeDados, HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(HttpStatus.BAD_REQUEST.value(), integridadeDeDados.getMessage(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
