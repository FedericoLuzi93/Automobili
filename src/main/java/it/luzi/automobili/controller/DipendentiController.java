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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.luzi.automobili.dto.DipendenteDTO;
import it.luzi.automobili.dto.EsitoDTO;
import it.luzi.automobili.exc.ConcessionariaNotFoundException;
import it.luzi.automobili.service.DipendentiService;


@RestController
@RequestMapping("/dipendenti")
public class DipendentiController 
{
	@Autowired
	private DipendentiService dipendentiService;
	
	private static final Logger logger = LoggerFactory.getLogger(DipendentiController.class);
	
	/* Test di avvio */
	
	@GetMapping("/prova")
	public ResponseEntity<EsitoDTO> test()
	{
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		logger.info("Accesso al servizio test");
		esito.setStatus(HttpStatus.OK.value());
		esito.setBody("TEST AVVENUTO CON SUCCESSO");
		return ResponseEntity.ok().headers(header).body(esito);

	}
	
	/* Update Dipendente */
	@PutMapping("/updateDipendentiConcessionarieId/dipendente")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Il pulsante dev'essere presente"),
			@ApiResponse(responseCode = "403", description = "Il pulsante non dev'essere presente"),
			@ApiResponse(responseCode = "400", description = "Dati in ingresso non validi"),
			@ApiResponse(responseCode = "500", description = "Errore interno") })
	public ResponseEntity<EsitoDTO> updateAutoConcessionarieId(@RequestBody DipendenteDTO dipendenteDTO)
	{
		logger.info("Accesso al servizio updateAutoConcessionarieId");
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		try
		{
			esito.setStatus(HttpStatus.OK.value());
			esito.setBody("INSERIMENTO AVVENUTO CON SUCCESSO");
			dipendentiService.updateDipendenteConcessionarieId(dipendenteDTO);
		}
		catch(Exception e)
		{
			logger.info("Eccezione nel servizio updateAutoConcessionarieId" + e);
			esito.setStatus(HttpStatus.BAD_REQUEST.value());
			esito.setBody("INSERIMENTO NON AVVENUTO");
			throw new ConcessionariaNotFoundException("Non è stato possibile aggiornare il dipendente " + e, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(esito);
	}
	
	/* Lista Dipendenti in base alla concessonaria */
	@GetMapping("/listaDipendentiConcessionaria/{idConcessionaria}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Il pulsante dev'essere presente"),
			@ApiResponse(responseCode = "403", description = "Il pulsante non dev'essere presente"),
			@ApiResponse(responseCode = "400", description = "Dati in ingresso non validi"),
			@ApiResponse(responseCode = "500", description = "Errore interno") })
	public ResponseEntity<List<DipendenteDTO>> leggiDipendentiConcessionarie(@PathVariable int idConcessionaria)
	{
		logger.info("Accesso al servizio leggiDipendentiConcessionaria");
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		List<DipendenteDTO> listaApi = new ArrayList<>();
		try
		{
			esito.setStatus(HttpStatus.OK.value());
			esito.setBody("CHIAMATA AVVENUTA CON SUCCESSO");
			listaApi = dipendentiService.listaDipendenteIdConcessionarie(idConcessionaria);
		}
		catch(Exception e)
		{
			logger.info("Eccezione nel servizio leggiDipendentiConcessionarie" + e);
			esito.setStatus(HttpStatus.BAD_REQUEST.value());
			esito.setBody("INSERIMENTO NON AVVENUTO");
			throw new ConcessionariaNotFoundException("Non è stato possibile chiamare leggiDipendentiConcessionarie" + e, HttpStatus.BAD_REQUEST);	
		}
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(listaApi);
	}
	
//	@PatchMapping("/creaListone")
//	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Il pulsante dev'essere presente"),
//			@ApiResponse(responseCode = "403", description = "Il pulsante non dev'essere presente"),
//			@ApiResponse(responseCode = "400", description = "Dati in ingresso non validi"),
//			@ApiResponse(responseCode = "500", description = "Errore interno") })
//	public String creaListone() throws FileNotFoundException
//	{
//		logger.info("Accesso al servizio creaListone");
//		dipendentiService.creaDipendenti();
//		return "FATTO!";
//	}
	
	/* Lista Paginata Dipendenti di una Concessionaria */
	@GetMapping("/getListaDipendentiPage/{idConcessionaria}/{page}/{sort}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Il pulsante dev'essere presente"),
			@ApiResponse(responseCode = "403", description = "Il pulsante non dev'essere presente"),
			@ApiResponse(responseCode = "400", description = "Dati in ingresso non validi"),
			@ApiResponse(responseCode = "500", description = "Errore interno") })
	public ResponseEntity<List<DipendenteDTO>> listaDipendentePaginata(@PathVariable int idConcessionaria,
			@PathVariable("page") int page,
			@PathVariable("sort") String sort)
	{
		logger.info("Accesso al servizio listaDipendentePaginata");
		HttpHeaders header = new HttpHeaders();
		EsitoDTO esito = new EsitoDTO();
		List<DipendenteDTO> listaApi = new ArrayList<>();
		try
		{
			esito.setStatus(HttpStatus.OK.value());
			esito.setBody("CHIAMATA AVVENUTA CON SUCCESSO");
			listaApi = dipendentiService.listaDipendentePaginata(idConcessionaria, page, sort);
		}
		catch(Exception e)
		{
			logger.info("Eccezione nel servizio listaDipendentePaginata" + e);
			esito.setStatus(HttpStatus.BAD_REQUEST.value());
			esito.setBody("CHIAMATA NON AVVENUTA");
			throw new ConcessionariaNotFoundException("Non è stato possibile chiamare listaDipendentePaginata" + e, HttpStatus.BAD_REQUEST);	
		}
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(listaApi);
	}
}
