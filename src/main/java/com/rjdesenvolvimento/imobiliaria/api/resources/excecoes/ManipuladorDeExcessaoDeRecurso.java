package com.rjdesenvolvimento.imobiliaria.api.resources.excecoes;

import com.rjdesenvolvimento.imobiliaria.services.excecoes.IntegridadeDeDadosNaDelecaoException;
import com.rjdesenvolvimento.imobiliaria.services.excecoes.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipuladorDeExcessaoDeRecurso {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException objetoNaoEncontrado, HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não Encontrado", objetoNaoEncontrado.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(IntegridadeDeDadosNaDelecaoException.class)
    public ResponseEntity<ErroPadrao> integridadeDeDadosNaDelecao(IntegridadeDeDadosNaDelecaoException integridadeDeDadosNaDelecao, HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", integridadeDeDadosNaDelecao.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadrao> validadeDeDadosNaInsercao(MethodArgumentNotValidException validadeDeDadosNaInsercao, HttpServletRequest request) {
        ErroDeValidacao erro = new ErroDeValidacao(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validacão", validadeDeDadosNaInsercao.getMessage(), request.getRequestURI());
        for (FieldError x : validadeDeDadosNaInsercao.getBindingResult().getFieldErrors()) {
            erro.adcionandoErroALista(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }
}
