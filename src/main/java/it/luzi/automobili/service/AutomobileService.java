package it.luzi.automobili.service;

import java.util.List;

import it.luzi.automobili.dto.AutomobileDTO;
import it.luzi.automobili.dto.ConcessionariaDTO;

public interface AutomobileService 
{
	public List<ConcessionariaDTO> leggiTutteConcessionarie();
	public int createConcessionario(ConcessionariaDTO c);
	public int deleteConcessionario(int concessionarioId);
	public int updateConcessionario(ConcessionariaDTO concessionarieDTO);
	
	public int assassociaConcessionarieAutomobile(int concessionarieId, AutomobileDTO automobileDTO);
	public int updateAutoConcessionarieId(AutomobileDTO automobileDTO);
	
	List<AutomobileDTO> findByIdConcessionaria(int idConcessionaria);
	
	

	

}
