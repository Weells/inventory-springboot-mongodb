package com.brunooliveira.inventoryspringbootmongodb.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brunooliveira.inventoryspringbootmongodb.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<StandardError> authenticationError(AuthenticationException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Erro de autenticação", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
