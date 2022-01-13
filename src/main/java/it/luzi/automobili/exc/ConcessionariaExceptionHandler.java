package it.luzi.automobili.exc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConcessionariaExceptionHandler 
{	
	private static final Logger logger = LoggerFactory.getLogger(ConcessionariaExceptionHandler.class);
	
	@ExceptionHandler
	public ResponseEntity<ConcessionariaErrorResponse> handleException(ConcessionariaNotFoundException exc)
	{
		logger.info("Si è verificata una ConcessionariaNotFoundException", exc);
		ConcessionariaErrorResponse error = new ConcessionariaErrorResponse();
		HttpStatus status = exc.getStatus() != null ? exc.getStatus() : HttpStatus.NOT_FOUND;
		error.setStatus(status.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, status);
	}
	
	@ExceptionHandler
	public ResponseEntity<ConcessionariaErrorResponse> handleExceptionBase(Exception e)
	{
		logger.info("Si è verificata una ConcessionariaNotFoundException", e);
		ConcessionariaErrorResponse error = new ConcessionariaErrorResponse();
		HttpStatus status = HttpStatus.NOT_FOUND;
		error.setStatus(status.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, status);
	}

	//uguale ma con excepetion e 
	//bad req
	//devo avere cod 500
}
