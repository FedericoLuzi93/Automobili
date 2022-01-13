package it.luzi.automobili.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.luzi.automobili.dto.AutomobileDTO;
import it.luzi.automobili.dto.ConcessionariaDTO;
import it.luzi.automobili.dto.EsitoDTO;
import it.luzi.automobili.exc.ConcessionariaNotFoundException;
import it.luzi.automobili.service.AutomobileService;

@RestController
@RequestMapping("/test")
public class TestAutomobiliController 
{
	@Autowired
	private AutomobileService automobileService;
	
	private static final Logger logger = LoggerFactory.getLogger(TestAutomobiliController.class);
	
	/* Test Prova */
	@GetMapping("/prova")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Il pulsante dev'essere presente"),
			@ApiResponse(code = 403, message = "Il pulsante non dev'essere presente"),
			@ApiResponse(code = 400, message = "Dati in ingresso non validi"),
			@ApiResponse(code = 500, message = "Errore interno") })
	public ResponseEntity<EsitoDTO> test()
	{
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		esito.setStatus(HttpStatus.OK.value());
		esito.setBody("TEST AVVENUTO CON SUCCESSO");
		return ResponseEntity.ok().headers(header).body(esito);
	}
	
	/* Lista Concessionaria */
	@GetMapping("/getListaConcessionarie")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Il pulsante dev'essere presente"),
			@ApiResponse(code = 403, message = "Il pulsante non dev'essere presente"),
			@ApiResponse(code = 400, message = "Dati in ingresso non validi"),
			@ApiResponse(code = 500, message = "Errore interno") })
	public ResponseEntity<List<ConcessionariaDTO>> leggiTutteConcessionarie()
	{
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		List<ConcessionariaDTO> listaApi = new ArrayList<>();
		logger.info("Accesso al servizio getListaConcessionarie");
		try
		{
			esito.setStatus(HttpStatus.OK.value());
			esito.setBody("CHIAMATA AVVENUTA CON SUCCESSO");
			listaApi = automobileService.leggiTutteConcessionarie();
		}
		catch(Exception e)
		{
			logger.info("Eccezione nel servizio leggiTutteConcessionarie" + e);
			esito.setStatus(HttpStatus.BAD_REQUEST.value());
			esito.setBody("LETTURA NON AVVENUTA");
			throw new ConcessionariaNotFoundException("Non è stato possibile mostrare la Lista" + e, HttpStatus.BAD_REQUEST);	
		}
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(listaApi);
	}
	
	/* Crea una Concessionaria */
	@PostMapping("/creaConcessionario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Il pulsante dev'essere presente"),
			@ApiResponse(code = 403, message = "Il pulsante non dev'essere presente"),
			@ApiResponse(code = 400, message = "Dati in ingresso non validi"),
			@ApiResponse(code = 500, message = "Errore interno") })
	public ResponseEntity<EsitoDTO> createConcessionarie(@RequestBody ConcessionariaDTO concessionarieDTO)
	{
		logger.info("Accesso al servizio createConcessionarie");
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		try
		{
			esito.setStatus(HttpStatus.OK.value());
			esito.setBody("INSERIMENTO AVVENUTO CON SUCCESSO");
			concessionarieDTO.setId(0);
			automobileService.createConcessionario(concessionarieDTO);
		}
		catch(Exception e)
		{
			logger.info("Eccezione nel servizio createConcessionarie" + e);
			esito.setStatus(HttpStatus.BAD_REQUEST.value());
			esito.setBody("INSERIMENTO NON AVVENUTO");
			throw new ConcessionariaNotFoundException("Non è stato possibile inserire il nuovo conessionario" + e, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(esito);
	}
	
	/* Cancella una Concessionaria tramite l'ID */
	@DeleteMapping("/delete/{concessionarioId}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Il pulsante dev'essere presente"),
			@ApiResponse(code = 403, message = "Il pulsante non dev'essere presente"),
			@ApiResponse(code = 400, message = "Dati in ingresso non validi"),
			@ApiResponse(code = 500, message = "Errore interno") })
	public ResponseEntity<EsitoDTO> deleteConcessionario(@PathVariable int concessionarioId)
	{
		logger.info("Accesso al servizio deleteConcessionario");
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		try
		{
			esito.setStatus(HttpStatus.OK.value());
			esito.setBody("CANCELLAZIONE AVVENUTA CON SUCCESSO");
			automobileService.deleteConcessionario(concessionarioId);
		}
		catch(Exception e)
		{
			logger.info("Eccezione nel servizio deleteConcessionario" + e);
			esito.setStatus(HttpStatus.BAD_REQUEST.value());
			esito.setBody("CANCELLAZIONE NON AVVENUTA");
			throw new ConcessionariaNotFoundException("Non è stato possibile cancellare la concessionaria" + e, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(esito); 
	}
	
	/* Aggiorna una Concessionaria tramite l'ID */
	@PutMapping("/update/{concessionarioId}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Il pulsante dev'essere presente"),
			@ApiResponse(code = 403, message = "Il pulsante non dev'essere presente"),
			@ApiResponse(code = 400, message = "Dati in ingresso non validi"),
			@ApiResponse(code = 500, message = "Errore interno") })
	public ResponseEntity<EsitoDTO> updateConcessionario(@RequestBody ConcessionariaDTO concessionarieDTO)
	{
		logger.info("Accesso al servizio updateConcessionario");
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		try
		{
			esito.setStatus(HttpStatus.OK.value());
			esito.setBody("AGGIORNAMENTO AVVENUTO CON SUCCESSO");
			automobileService.updateConcessionario(concessionarieDTO);
		}
		catch(Exception e)
		{
			logger.info("Eccezione nel servizio updateConcessionario" + e);
			esito.setStatus(HttpStatus.BAD_REQUEST.value());
			esito.setBody("CANCELLAZIONE NON AVVENUTA");
			throw new ConcessionariaNotFoundException("Non è stato possibile aggiornare la concessionaria" + e, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(esito);  
	}
	
	//Errore logico!!!
	@PutMapping("/getConcessionarie/{concessionarieId}/auto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Il pulsante dev'essere presente"),
			@ApiResponse(code = 403, message = "Il pulsante non dev'essere presente"),
			@ApiResponse(code = 400, message = "Dati in ingresso non validi"),
			@ApiResponse(code = 500, message = "Errore interno") })
	public List<ConcessionariaDTO> associaConcessionarieAutomobile(@PathVariable String concessionarieId, @RequestBody AutomobileDTO automobileDTO)
	{
		logger.info("Accesso al servizio 	public");
		automobileService.assassociaConcessionarieAutomobile(Integer.parseInt(concessionarieId), automobileDTO);
		return automobileService.leggiTutteConcessionarie();
	}
	
	/* Aggiorna la concessionara di una automobile */
	@PutMapping("/updateAutoConcessionarieId/automobile")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Il pulsante dev'essere presente"),
			@ApiResponse(code = 403, message = "Il pulsante non dev'essere presente"),
			@ApiResponse(code = 400, message = "Dati in ingresso non validi"),
			@ApiResponse(code = 500, message = "Errore interno") })
	public ResponseEntity<EsitoDTO> updateAutoConcessionarieId(@RequestBody AutomobileDTO automobileDTO)
	{
		logger.info("Accesso al servizio updateAutoConcessionarieId");
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		try
		{
			esito.setStatus(HttpStatus.OK.value());
			esito.setBody("AGGIORNAMENTO AVVENUTO CON SUCCESSO");
			automobileService.updateAutoConcessionarieId(automobileDTO);
		}
		catch(Exception e)
		{
			logger.info("Eccezione nel servizio updateAutoConcessionarieId" + e);
			esito.setStatus(HttpStatus.BAD_REQUEST.value());
			esito.setBody("CANCELLAZIONE NON AVVENUTA");
			throw new ConcessionariaNotFoundException("Non è stato possibile aggiornare la automobile" + e, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(esito);  
	}
	
	/* Lista di tutte le Automobili di una Concessionaria */
	@GetMapping("/listaAutomobiliConcessionaria/{idConcessionaria}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Il pulsante dev'essere presente"),
			@ApiResponse(code = 403, message = "Il pulsante non dev'essere presente"),
			@ApiResponse(code = 400, message = "Dati in ingresso non validi"),
			@ApiResponse(code = 500, message = "Errore interno") })
	public ResponseEntity<List<AutomobileDTO>> leggiAutomobiliConcessionarie(@PathVariable int idConcessionaria)
	{
		logger.info("Accesso al servizio leggiAutomobiliConcessionarie");
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		List<AutomobileDTO> listaApi = new ArrayList<>();
		try
		{
			esito.setStatus(HttpStatus.OK.value());
			esito.setBody("AGGIORNAMENTO AVVENUTO CON SUCCESSO");
			listaApi = automobileService.findByIdConcessionaria(idConcessionaria);
		}
		catch(Exception e)
		{
			logger.info("Eccezione nel servizio leggiAutomobiliConcessionarie" + e);
			esito.setStatus(HttpStatus.BAD_REQUEST.value());
			esito.setBody("RICHIESTA NON AVVENUTA");
			throw new ConcessionariaNotFoundException("Non è stato possibile mostrare la lista delle automobili" + e, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(listaApi); 
	}

}