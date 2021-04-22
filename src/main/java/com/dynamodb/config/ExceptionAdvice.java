package com.dynamodb.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.dynamodb.commons.exception.RepositoryException;

@ControllerAdvice
public class ExceptionAdvice {
	
	private static final String CODIGO = "codigo";
	private static final String MENSAGEM = "mensagem";
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Object> tratarExcecaoRecursoNaoEncontrado() {
		
		Map<String, String> body = new HashMap<>();
		
		body.put(CODIGO, "404");
		body.put(MENSAGEM, "Recurso inexistente");
		
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> tratarExcecaoTipoIncompativel(MethodArgumentTypeMismatchException ex) {
	    
		Map<String, String> body = new HashMap<>();
		
		body.put(CODIGO, "400");
		body.put(MENSAGEM, "Requisição com tipo incompatível. Campo: " + ex.getName() + ", conteúdo: " + ex.getValue());
		
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST); 
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> tratarExcecaoArgumentoInvalido(MethodArgumentNotValidException ex) {

		String erros = "";

		if (ex.getBindingResult() != null &&
			ex.getBindingResult().getFieldErrors() != null) {
			for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
				erros = " Campo " + "'" + fieldError.getField() + "' " + fieldError.getDefaultMessage() + ".";
			}
		}

		Map<String, String> body = new HashMap<>();

		body.put(CODIGO, "400");
		body.put(MENSAGEM, "Requisição com argumentos inválidos.".concat(erros));

		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RepositoryException.class)
	public ResponseEntity<Object> tratarExcecaoRepositorio(RepositoryException ex) {
	    
		Map<String, String> body = new HashMap<>();
		
		body.put(CODIGO, "404");
		body.put(MENSAGEM, ex.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND); 
	}
}