package it.luzi.automobili.utility;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.luzi.automobili.dto.AutomobileDTO;
import it.luzi.automobili.dto.ConcessionariaDTO;
import it.luzi.automobili.dto.DipendenteDTO;
import it.luzi.automobili.entities.Automobile;
import it.luzi.automobili.entities.Concessionaria;
import it.luzi.automobili.entities.Dipendente;

public class AutomobiliUtility 
{
	private static final Logger logger = LoggerFactory.getLogger(AutomobiliUtility.class);
	
	
	public static ConcessionariaDTO converToConcessionariaDTO(Concessionaria concessionarie, boolean convertAutomobili)
	{
		logger.info("Sono dentro alla classe AutomobiliUtility metodo converToConcessionariaDTO");
		ConcessionariaDTO cDTO = new ConcessionariaDTO();
		cDTO.setId(concessionarie.getId());
		cDTO.setNome(concessionarie.getNome());
		cDTO.setIndirizzo(concessionarie.getIndirizzo());
		cDTO.setCitta(concessionarie.getCitta());
		cDTO.setCap(concessionarie.getCap());
		cDTO.setCodicefiscale(concessionarie.getCodicefiscale());
		
		if(convertAutomobili)
		{
			logger.info("Sono dentro alla classe AutomobiliUtility metodo converToConcessionariaDTO nell if convertAutomobili");
		
			if(concessionarie.getAutomobiliLista() != null && concessionarie.getAutomobiliLista().size() > 0)
			{
				logger.info("Sono dentro alla classe AutomobiliUtility metodo converToConcessionariaDTO nel secondo if");
				for(Automobile auto : concessionarie.getAutomobiliLista())
				{
					logger.info("Sono dentro alla classe AutomobiliUtility metodo converToConcessionariaDTO nel ciclo for");
					cDTO.getListaAutomobili().add(null);
				}
			}
		}
		logger.info("Fine del metodo converToConcessionariaDTO nella classe AutomobiliUtility");
		return cDTO;
	}
	
	public static List<ConcessionariaDTO> convertToListDTO(List<Concessionaria> listaConcessionarie, boolean convertAutomobili)
	{
		logger.info("Sono dentro alla classe AutomobiliUtility metodo convertToListDTO");
		List<ConcessionariaDTO> listaConcessionarieDTO = new ArrayList<>();
		for(Concessionaria c : listaConcessionarie)
		{
			logger.info("Sono dentro alla classe AutomobiliUtility metodo convertToListDTO nel ciclo for");
			listaConcessionarieDTO.add(converToConcessionariaDTO(c, convertAutomobili));
		}
		logger.info("Fine del metodo convertToListDTO nella classe AutomobiliUtility");
		return listaConcessionarieDTO;
	}
	
	public static Concessionaria convertToConcessionaria(ConcessionariaDTO concessionariaDTO)
	{
		logger.info("Sono dentro alla classe AutomobiliUtility metodo convertToConcessionaria");
		Concessionaria c = new Concessionaria();
		c.setId(concessionariaDTO.getId());
		c.setNome(concessionariaDTO.getNome());
		c.setIndirizzo(concessionariaDTO.getIndirizzo());
		c.setCitta(concessionariaDTO.getCitta());
		c.setCap(concessionariaDTO.getCap());
		c.setCodicefiscale(concessionariaDTO.getCodicefiscale());
			
		logger.info("Fine del metodo convertToConcessionaria nella classe AutomobiliUtility");
		return c;
	}
	
	public static AutomobileDTO convertToAutomobileDTO(Automobile automobile)
	{
		logger.info("Sono dentro alla classe AutomobiliUtility metodo convertToAutomobileDTO");
		AutomobileDTO aDTO = new AutomobileDTO();
		aDTO.setId(automobile.getId());
		aDTO.setTarga(automobile.getTarga());
		aDTO.setMarca(automobile.getMarca());
		aDTO.setModello(automobile.getModello());
		aDTO.setAnno(automobile.getAnno());
		
		logger.info("Sono dentro alla classe AutomobiliUtility metodo convertToAutomobileDTO e ho creato l'oggetto cDTO");
		ConcessionariaDTO cDTO = new ConcessionariaDTO();
		AutomobiliUtility.convertToConcessionaria(cDTO);
		aDTO.setConcessionarieDTO(cDTO);
		
		logger.info("Fine del metodo convertToAutomobileDTO nella classe AutomobiliUtility");
		return aDTO;
	}
	
	public static Automobile convertToAutomobile(AutomobileDTO automobileDTO)
	{
		logger.info("Sono dentro alla classe AutomobiliUtility metodo convertToAutomobile");
		Automobile a = new Automobile();
		a.setId(automobileDTO.getId());
		a.setTarga(automobileDTO.getTarga());
		a.setMarca(automobileDTO.getMarca());
		a.setModello(automobileDTO.getModello());
		a.setAnno(automobileDTO.getAnno());
		
		logger.info("Fine del metodo convertToAutomobile nella classe AutomobiliUtility");
		return a;
	}
	
	public static DipendenteDTO converToDipendeteDTO(Dipendente dipendente)
	{
		logger.info("Sono dentro alla classe AutomobiliUtility metodo converToDipendeteDTO");
		DipendenteDTO dDTO = new DipendenteDTO();
		dDTO.setId(dipendente.getId());
		dDTO.setNome(dipendente.getNome());
		dDTO.setCognome(dipendente.getCognome());
		dDTO.setCodicefiscale(dipendente.getCodicefiscale());
		dDTO.setStipendio(dipendente.getStipendio());
		
		logger.info("Sono dentro alla classe AutomobiliUtility metodo converToDipendeteDTO");
		ConcessionariaDTO cDTO = new ConcessionariaDTO();
		AutomobiliUtility.convertToConcessionaria(cDTO);
		dDTO.setConcessionarieDTO(cDTO);
		
		logger.info("Fine del metodo converToDipendeteDTO nella classe AutomobiliUtility");
		return dDTO;
	}
	
	public static Dipendente converToDipendete(DipendenteDTO dipendenteDTO)
	{
		logger.info("Sono dentro alla classe AutomobiliUtility metodo converToDipendete");
		Dipendente d = new Dipendente();
		d.setId(dipendenteDTO.getId());
		d.setNome(dipendenteDTO.getNome());
		d.setCognome(dipendenteDTO.getCognome());
		d.setCodicefiscale(dipendenteDTO.getCodicefiscale());
		d.setStipendio(dipendenteDTO.getStipendio());

		logger.info("Fine del metodo converToDipendete nella classe AutomobiliUtility");
		return d;
	}
}
