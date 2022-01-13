package it.luzi.automobili.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import it.luzi.automobili.entities.Automobile;
import it.luzi.automobili.entities.Concessionaria;
import it.luzi.automobili.exc.ConcessionariaNotFoundException;
import it.luzi.automobili.repository.AutomobileRepository;
import it.luzi.automobili.repository.ConcessionarieRepository;

@Repository
@Component
public class DAOConcessionarieImpl implements DAOConcessionarie
{
	@Autowired
	private ConcessionarieRepository concessionarieRepository;
	
	@Autowired
	private AutomobileRepository automobileRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(DAOConcessionarieImpl.class);
	
	public String test()
	{
		logger.info("Accesso al DAOConcessionarieImpl metodo test");
		return "Questo è un test";
	}
	
	public List<Concessionaria> leggiTutteConcessionarie()
	{
		logger.info("Accesso al DAOConcessionarieImpl metodo leggiTutteConcessionarie");
		return concessionarieRepository.findAll();
	}

	public int createConcessionario(Concessionaria c)
	{
		logger.info("Accesso al DAOConcessionarieImpl metodo createConcessionario");
		concessionarieRepository.save(c);
		logger.info("Fine di DAOConcessionarieImpl metodo createConcessionario");
		return c.getId();
	}

	@Override
	public int deleteConcessionario(int concessionarioId) 
	{
		logger.info("Accesso al DAOConcessionarieImpl metodo deleteConcessionario");
		concessionarieRepository.deleteById(concessionarioId);
		logger.info("Fine di DAOConcessionarieImpl metodo deleteConcessionario");
		return concessionarioId;
	}

	@Override
	public int updateConcessionario(Concessionaria concessionarie) 
	{
		logger.info("Accesso al DAOConcessionarieImpl metodo updateConcessionario");
		concessionarieRepository.save(concessionarie);
		logger.info("Fine di DAOConcessionarieImpl metodo updateConcessionario");
		return concessionarie.getId();		
	}

	@Override
	public int associaConcessionarieAutomobile(int concessionarieId, Automobile a) 
	{
		logger.info("Accesso al DAOConcessionarieImpl metodo associaConcessionarieAutomobile");
		Integer maxId = concessionarieRepository.getMaxId();
		if(maxId == null)
		{
			logger.info("Eccezzione: La tabella Concessionarie e' vuota" );
			throw new ConcessionariaNotFoundException("La tabella Concessionarie e' vuota");
		}
		if(concessionarieId > maxId || concessionarieId < 0)
		{
			logger.info("Non ci sono concessionarie nel DB con id pari a" + concessionarieId);
			throw new ConcessionariaNotFoundException("Non ci sono concessionarie nel DB con id pari a " + concessionarieId);
		}

		Optional<Concessionaria> optionalConcessionarie = concessionarieRepository.findById(concessionarieId);
		if(optionalConcessionarie.isPresent())
		{
			logger.info("In DAOConcessionarieImpl metodo associaConcessionarieAutomobiledentro sono dentro if di optionalConcessionarie.isPresent");
			Concessionaria concessionarie = optionalConcessionarie.get();
			concessionarie.add(a);
			concessionarieRepository.save(concessionarie);
		}
		logger.info("Fine di DAOConcessionarieImpl metodo leggiTutteConcessionarie");
		return concessionarieId;
	}

	@Override
	public int updateAutoConcessionarieId(Automobile auto, int idConcessionario) 
	{
		logger.info("Accesso al DAOConcessionarieImpl metodo updateAutoConcessionarieId");
		Optional<Concessionaria> cOt = concessionarieRepository.findById(idConcessionario);
		if(!cOt.isPresent())
		{
			logger.info("Non ci sono concessionarie nel DB con id pari a " + idConcessionario);
			 throw new ConcessionariaNotFoundException("Non ci sono concessionarie nel DB con id pari a " + idConcessionario);
		}
		
		Optional<Automobile> aOt = automobileRepository.findById(auto.getId());
		if(!aOt.isPresent())
		{
			logger.info("In DAOConcessionarieImpl metodo updateAutoConcessionarieId sono dentro if di aOt.isPresent");
			return 0;
		}
		
		Automobile automobileDB = aOt.get();
		automobileDB.setTarga(auto.getTarga());
		automobileDB.setModello(auto.getModello());
		automobileDB.setMarca(auto.getMarca());
		automobileDB.setAnno(auto.getAnno());
		automobileDB.setConcessionarie(cOt.get());
		automobileRepository.save(automobileDB);
		logger.info("Fine di DAOConcessionarieImpl metodo updateAutoConcessionarieId");
		return 1;
	}

	@Override
	public List<Automobile> findByIdConcessionaria(int idConcessionaria) 
	{
			logger.info("Inizio funzione findByIdConcessionaria");
			List<Automobile> listaAutomoboli = automobileRepository.findByIdConcessionaria(idConcessionaria);
			return listaAutomoboli;
	}
}
