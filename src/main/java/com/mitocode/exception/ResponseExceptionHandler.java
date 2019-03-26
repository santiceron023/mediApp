package com.mitocode.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(ModeloNotFoudException.class)
	public final ResponseEntity<Object> manjearModeloExcepciones(ModeloNotFoudException ex, WebRequest request){
		ExceptionResponse excResp = new ExceptionResponse(ex.getMessage(),
				request.getDescription(false),new Date());
		
		return new ResponseEntity(excResp, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> manjearTodasExcepciones(Exception ex, WebRequest request){
		
		ExceptionResponse excResp = new ExceptionResponse(ex.getMessage(),
				request.getDescription(false),new Date());
		
		return new ResponseEntity(excResp, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		String errores = "";
		for (ObjectError e : ex.getBindingResult().getAllErrors()) {
			errores += e.getObjectName();
		}
		
		ExceptionResponse excResp = new ExceptionResponse("validación fallida", errores, new Date());
		
		return new ResponseEntity(excResp, HttpStatus.BAD_REQUEST);
//		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}

}
