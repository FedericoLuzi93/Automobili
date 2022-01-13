package it.luzi.automobili.dao;

import java.util.List;

import it.luzi.automobili.entities.Automobile;
import it.luzi.automobili.entities.Concessionaria;

public interface DAOConcessionarie 
{
	public String test();
	public List<Concessionaria> leggiTutteConcessionarie();
	public int createConcessionario(Concessionaria c);
	public int deleteConcessionario(int concessionarioId);
	public int updateConcessionario(Concessionaria concessionarie);
	
	public int associaConcessionarieAutomobile(int concessionarieId, Automobile a);
	public int updateAutoConcessionarieId(Automobile auto, int idConcessionario);
	
	public List<Automobile> findByIdConcessionaria(int idConcessionaria);

}
