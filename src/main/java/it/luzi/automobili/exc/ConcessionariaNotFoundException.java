package it.luzi.automobili.exc;

import java.lang.RuntimeException;

import org.springframework.http.HttpStatus;

public class ConcessionariaNotFoundException extends RuntimeException
{
	private HttpStatus status;
	
	public ConcessionariaNotFoundException(String message)
	{
		super(message);
	}
	
	public ConcessionariaNotFoundException(String message, HttpStatus status)
	{
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	

}
