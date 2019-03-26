package com.mitocode.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private String mensaje;
	private String detalles;
	private Date timestamp;
	
 
	
	public ExceptionResponse(String mensaje, String detalles, Date timestamp) {
		super();
		this.mensaje = mensaje;
		this.detalles = detalles;
		this.timestamp = timestamp;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
