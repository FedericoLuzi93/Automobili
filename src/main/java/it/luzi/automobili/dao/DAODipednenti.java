package it.luzi.automobili.dao;


import java.util.List;

import it.luzi.automobili.entities.Dipendente;

public interface DAODipednenti 
{
	public List<Dipendente> leggiTuttiDipendenti(int nPagina);
	public int updateDipendenteConcessionarieId(Dipendente dipendente, int idConcessionario);
	public List<Dipendente> listaDipendenteIdConcessionarie(int idConcessionaria);
	List<Dipendente> listaDipendentePaginata(int idConcessionaria, int page, String sort);

}
