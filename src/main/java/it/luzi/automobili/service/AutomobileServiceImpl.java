package it.luzi.automobili.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.luzi.automobili.dao.DAOConcessionarie;
import it.luzi.automobili.dto.AutomobileDTO;
import it.luzi.automobili.dto.ConcessionariaDTO;
import it.luzi.automobili.entities.Automobile;
import it.luzi.automobili.entities.Concessionaria;
import it.luzi.automobili.utility.AutomobiliUtility;

@Service
public class AutomobileServiceImpl implements AutomobileService
{
	@Autowired
	private DAOConcessionarie daoConcessionarie;
	
	@Value("${automobili.date.format}")
	private String dateFormat;
	
	private static final Logger logger = LoggerFactory.getLogger(AutomobileServiceImpl.class);

	public List<ConcessionariaDTO> leggiTutteConcessionarie()
	{
		logger.info("Sono dentro alla classe AutomobileServiceImpl metodo leggiTutteConcessionarie");
		List<Concessionaria> listaConcessionarie = daoConcessionarie.leggiTutteConcessionarie();
		List<ConcessionariaDTO> listaConcessionarieDTO = new ArrayList<>();
		for(Concessionaria c : listaConcessionarie)
		{
			logger.info("Sono dentro alla classe AutomobileServiceImpl metodo leggiTutteConcessionarie nel ciclo for");
			listaConcessionarieDTO.add(AutomobiliUtility.converToConcessionariaDTO(c, false));
		}
		logger.info("Fine metodo leggiTutteConcessionarie nella classe AutomobileServiceImpl");
		return listaConcessionarieDTO;	
	}

	@Override
	public int createConcessionario(ConcessionariaDTO c) 
	{
		logger.info("Inizio metodo createConcessionario nella classe AutomobileServiceImpl");
		Concessionaria concessionarie = AutomobiliUtility.convertToConcessionaria(c);
		logger.info("Fine metodo createConcessionario nella classe AutomobileServiceImpl");
		return daoConcessionarie.createConcessionario(concessionarie);
	}

	@Override
	public int deleteConcessionario(int concessionarioId) 
	{
		logger.info("Inizio metodo deleteConcessionario nella classe AutomobileServiceImpl");
		daoConcessionarie.deleteConcessionario(concessionarioId);
		logger.info("Fine metodo deleteConcessionario nella classe AutomobileServiceImpl");
		return concessionarioId;
	}

	@Override
	public int updateConcessionario(ConcessionariaDTO c)
	{
		logger.info("Inizio metodo updateConcessionario nella classe AutomobileServiceImpl");
		Concessionaria concessionarie = AutomobiliUtility.convertToConcessionaria(c);
		logger.info("Fine metodo updateConcessionario nella classe AutomobileServiceImpl");
		return daoConcessionarie.updateConcessionario(concessionarie);
	}

	@Override
	public int assassociaConcessionarieAutomobile(int concessionarieId, AutomobileDTO automobileDTO) 
	{
		logger.info("Inizio metodo assassociaConcessionarieAutomobile nella classe AutomobileServiceImpl");
		Automobile a = AutomobiliUtility.convertToAutomobile(automobileDTO);
		logger.info("Fine metodo assassociaConcessionarieAutomobile nella classe AutomobileServiceImpl");
		return daoConcessionarie.associaConcessionarieAutomobile(concessionarieId, a);
	}

	//UPDATE
	@Override
	public int updateAutoConcessionarieId(AutomobileDTO automobileDTO) 
	{
		logger.info("Inizio metodo updateAutoConcessionarieId nella classe AutomobileServiceImpl");
		Automobile auto = AutomobiliUtility.convertToAutomobile(automobileDTO);
		logger.info("Fine metodo updateAutoConcessionarieId nella classe AutomobileServiceImpl");
		return daoConcessionarie.updateAutoConcessionarieId(auto, automobileDTO.getConcessionarieDTO().getId());
	}

	@Override
	public List<AutomobileDTO> findByIdConcessionaria(int idConcessionaria) 
	{
		logger.info("Sono dentro alla classe AutomobileServiceImpl metodo findByIdConcessionaria");
		List<Automobile> listaAutomobile = daoConcessionarie.findByIdConcessionaria(idConcessionaria);
		List<AutomobileDTO> listaAutomobileDTO = new ArrayList<>();
		for(Automobile a : listaAutomobile)
		{
			logger.info("Sono dentro alla classe AutomobileServiceImpl metodo findByIdConcessionaria nel ciclo for");
			listaAutomobileDTO.add(AutomobiliUtility.convertToAutomobileDTO(a));
		}
		logger.info("Fine del metodo findByIdConcessionaria nella classe AutomobileServiceImpl");
		return listaAutomobileDTO;
	}
}
