package it.luzi.automobili.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import it.luzi.automobili.entities.Concessionaria;
import it.luzi.automobili.entities.Dipendente;
import it.luzi.automobili.exc.ConcessionariaNotFoundException;
import it.luzi.automobili.repository.ConcessionarieRepository;
import it.luzi.automobili.repository.DipendenteRepository;

@Repository
@Component
public class DAODipendenetiImpl implements DAODipednenti 
{

	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	@Autowired
	private ConcessionarieRepository concessionarieRepository;
	
	@Value("${automobili.page.num}")
	private int nPagineVisual;
	
	private static final Logger logger = LoggerFactory.getLogger(DAODipendenetiImpl.class);
	
	public List<Dipendente> leggiTuttiDipendenti(int nPagina) 
	{
		logger.info("Inizio funzione leggiTuttiDipendenti");
		Pageable pageable = PageRequest.of(0, 5);
		Page<Dipendente> pageDipendenti = dipendenteRepository.findAll(pageable);
		return pageDipendenti.toList();
	}

	@Override
	public int updateDipendenteConcessionarieId(Dipendente dipendente, int idConcessionario) 
	{
		logger.info("Inizio funzione updateDipendenteConcessionarieId");
		Optional<Concessionaria> cOt = concessionarieRepository.findById(idConcessionario);
		logger.info("Fine funzione updateDipendenteConcessionarieId");
		if(!cOt.isPresent())
		{
			logger.info("Non ci sono concessionarie nel DB con id pari a " + idConcessionario);
			throw new ConcessionariaNotFoundException("Non ci sono concessionarie nel DB con id pari a " + idConcessionario);
		}
		
		Optional<Dipendente> dOt = dipendenteRepository.findById(dipendente.getId());
		if(!dOt.isPresent())
		{
			logger.info("Non ci sono concessionarie nel DB con id pari a " + idConcessionario);
			throw new ConcessionariaNotFoundException("Non ci sono concessionarie nel DB con id pari a " + idConcessionario);
		}
		Dipendente dipendeteDB = dOt.get();
		dipendeteDB.setNome(dipendente.getNome());
		dipendeteDB.setCognome(dipendente.getCognome());
		dipendeteDB.setCodicefiscale(dipendente.getCodicefiscale());
		dipendeteDB.setStipendio(dipendente.getStipendio());
		dipendeteDB.setConcessionarie(cOt.get());
		
		dipendenteRepository.save(dipendeteDB);
		logger.info("Fine funzione updateDipendenteConcessionarieId");
		return 1;
	}

	@Override
	public List<Dipendente> listaDipendenteIdConcessionarie(int idConcessionaria) 
	{
		logger.info("Inizio funzione listaDipendenteIdConcessionarie");
		List<Dipendente> listaDipendenti = dipendenteRepository.findByIdConcessionaria(idConcessionaria);
		return listaDipendenti;
	}

	public List<Dipendente> listaDipendentePaginata(int idConcessionaria, int page, String sort)
	{
		logger.info("Inizio funzione listaDipendentePaginata");
		Pageable pageble = PageRequest.of(page-1, nPagineVisual, Sort.by(sort));
		Page<Dipendente> listaDipedentiPaginata = dipendenteRepository.findAllUsersWithPagination(idConcessionaria, pageble);
		return listaDipedentiPaginata.toList();
	}

}
