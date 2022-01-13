package it.luzi.automobili.service;


import java.io.FileNotFoundException;
import java.util.List;

import it.luzi.automobili.dto.DipendenteDTO;
import it.luzi.automobili.entities.Dipendente;

public interface DipendentiService 
{
	public List<DipendenteDTO> leggiTuttiDipendenti(int nPagina);
	public int updateDipendenteConcessionarieId(DipendenteDTO dipendenteDTO); 
	List<DipendenteDTO> listaDipendenteIdConcessionarie(int idConcessionaria);
	public List<Dipendente> creaDipendenti() throws FileNotFoundException;
	List<DipendenteDTO> listaDipendentePaginata(int idConcessionaria, int page, String sort);
	
	
}
