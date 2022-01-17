package it.luzi.automobili.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.luzi.automobili.dto.EsitoDTO;
import it.luzi.automobili.dto.StudenteLombokDTO;
import it.luzi.automobili.exc.ConcessionariaNotFoundException;
import it.luzi.automobili.service.StudenteLombokService;

@RestController
@RequestMapping("/mapper")
public class StudenteLombokController 
{
	@Autowired
	private StudenteLombokService studenteLombokService;
	
	private static final Logger logger = LoggerFactory.getLogger(StudenteLombokController.class);
	
	@GetMapping("/prova")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Il pulsante dev'essere presente"),
			@ApiResponse(code = 403, message = "Il pulsante non dev'essere presente"),
			@ApiResponse(code = 400, message = "Dati in ingresso non validi"),
			@ApiResponse(code = 500, message = "Errore interno") })
	public ResponseEntity<EsitoDTO> test()
	{
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		logger.info("Accesso al servizio test");
		esito.setStatus(HttpStatus.OK.value());
		esito.setBody("TEST AVVENUTO CON SUCCESSO");
		return ResponseEntity.ok().headers(header).body(esito);
	}
	
	@GetMapping("getListaStudenti")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Il pulsante dev'essere presente"),
			@ApiResponse(code = 403, message = "Il pulsante non dev'essere presente"),
			@ApiResponse(code = 400, message = "Dati in ingresso non validi"),
			@ApiResponse(code = 500, message = "Errore interno") })
	public ResponseEntity<List<StudenteLombokDTO>> leggiTuttiStudenti()
	{
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		List<StudenteLombokDTO> listaApi = new ArrayList<>();
		logger.info("Accesso al servizio leggiTuttiStudenti");
		try
		{
			esito.setStatus(HttpStatus.OK.value());
			esito.setBody("CHIAMATA AVVENUTA CON SUCCESSO");
			listaApi = studenteLombokService.getAll();
		}
		catch(Exception e)
		{
			logger.info("Eccezione nel servizio leggiTuttiStudenti" + e);
			esito.setStatus(HttpStatus.BAD_REQUEST.value());
			esito.setBody("LETTURA NON AVVENUTA");
			throw new ConcessionariaNotFoundException("Non è stato possibile mostrare la Lista" + e, HttpStatus.BAD_REQUEST);	
		}
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(listaApi);
	}
	
	

}
