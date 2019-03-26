package com.mitocode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoudException extends RuntimeException{
	
	public ModeloNotFoudException(String mensaje) {
		super(mensaje);

	}
	
}
