package it.luzi.automobili.service;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.luzi.automobili.dao.DAOConcessionarie;
import it.luzi.automobili.dao.DAODipednenti;
import it.luzi.automobili.dto.DipendenteDTO;
import it.luzi.automobili.entities.Concessionaria;
import it.luzi.automobili.entities.Dipendente;
import it.luzi.automobili.exc.ConcessionariaNotFoundException;
import it.luzi.automobili.repository.ConcessionarieRepository;
import it.luzi.automobili.repository.DipendenteRepository;
import it.luzi.automobili.utility.AutomobiliUtility;





@Service
public class DipendentiServiceImpl implements DipendentiService
{

	enum enumDipendenti 
	{
		id,
		nome,
		cognome,
		codicefiscale,
		stipendio
	}

	
	@Autowired
	private DAODipednenti daoDipendenti;
	
	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	@Autowired
	private DAOConcessionarie daoConcessionarie;
	
	@Autowired
	private ConcessionarieRepository concessionarieRepository;
	
	
	private static final Logger logger = LoggerFactory.getLogger(DipendentiServiceImpl.class);
	
	@Override
	public List<DipendenteDTO> leggiTuttiDipendenti(int nPagina) 
	{
		logger.info("Sono dentro alla classe DipendentiServiceImpl metodo leggiTuttiDipendenti");
		List<Dipendente> listaDipendente = daoDipendenti.leggiTuttiDipendenti(nPagina);
		List<DipendenteDTO> listaDipendenteDTO = new ArrayList<>();
		for(Dipendente d: listaDipendente)
		{
			logger.info("Sono dentro alla classe DipendentiServiceImpl metodo leggiTuttiDipendenti nel ciclo for");
			listaDipendenteDTO.add(AutomobiliUtility.converToDipendeteDTO(d));
		}
		logger.info("Fine del metodo leggiTuttiDipendenti nella classe DipendentiServiceImpl");
		return listaDipendenteDTO;
	}

	public int updateDipendenteConcessionarieId(DipendenteDTO dipendenteDTO) 
	{
		logger.info("Sono dentro alla classe updateDipendenteConcessionarieId metodo leggiTuttiDipendenti");
		Dipendente dipendente = AutomobiliUtility.converToDipendete(dipendenteDTO);
		logger.info("Fine del metodo updateDipendenteConcessionarieId nella classe DipendentiServiceImpl");
		return daoDipendenti.updateDipendenteConcessionarieId(dipendente, dipendenteDTO.getConcessionarieDTO().getId());
	}

	@Override
	public List<DipendenteDTO> listaDipendenteIdConcessionarie(int idConcessionaria) 
	{
		logger.info("Sono dentro alla classe updateDipendenteConcessionarieId metodo listaDipendenteIdConcessionarie");
		List<Dipendente> listaDipendente = daoDipendenti.listaDipendenteIdConcessionarie(idConcessionaria);
		List<DipendenteDTO> listaDipendenteDTO = new ArrayList<>();
		for(Dipendente d: listaDipendente)
		{
			logger.info("Sono dentro alla classe DipendentiServiceImpl metodo listaDipendenteIdConcessionarie nel ciclo for");
			listaDipendenteDTO.add(AutomobiliUtility.converToDipendeteDTO(d));
		}
		logger.info("Fine del metodo listaDipendenteIdConcessionarie nella classe DipendentiServiceImpl");
		return listaDipendenteDTO;
	}
	
	public List<Dipendente> creaDipendenti() throws FileNotFoundException
	{
		logger.info("Sono dentro alla classe DipendentiServiceImpl metodo creaDipendenti");
		String percorsoFile = "src/main/resources/MOCK_DATA.csv";
		Scanner file = new Scanner(new File(percorsoFile));
		List<Dipendente> listaDipendenti = new ArrayList<>();
		String[] riga;
		Dipendente d = null;
		int counter = 0;
		int random = 0;
		while(file.hasNextLine())
		{
			riga = file.nextLine().split(",");
			counter ++;
			for(int i = 0; i < counter ; i++)
			{
				random = RandomUtils.nextInt(1, 3);
				Optional<Concessionaria> optionalConcessionaria = concessionarieRepository.findById(random);
				Concessionaria concessionaria = optionalConcessionaria.get();
				d = new Dipendente(	riga[0],
									riga[1],
									Double.parseDouble(riga[2]),
									concessionaria
									);
			}
			dipendenteRepository.save(d);
			listaDipendenti.add(d);
		}
		
		return listaDipendenti;
	}
	
	public List<DipendenteDTO> listaDipendentePaginata(int idConcessionaria, int page, String sort)
	{
		
		if(	sort.equals(enumDipendenti.nome.name()) || sort.equals(enumDipendenti.id.name()) ||
			sort.equals(enumDipendenti.cognome.name()) || sort.equals(enumDipendenti.codicefiscale.name()) ||
			sort.equals(enumDipendenti.stipendio.name()))
		{
		logger.info("Sono dentro alla classe DipendentiServiceImpl metodo listaDipendentePaginata");
		List<DipendenteDTO> listaDipendenteDTO = new ArrayList<>();
		List<Dipendente> listaDipendente = daoDipendenti.listaDipendentePaginata(idConcessionaria, page, sort);
		for(Dipendente d: listaDipendente)
		{
			logger.info("Sono dentro alla classe DipendentiServiceImpl metodo listaDipendentePaginata nel ciclo for");
			listaDipendenteDTO.add(AutomobiliUtility.converToDipendeteDTO(d));
		}
		logger.info("Fine del metodo listaDipendentePaginata nella classe DipendentiServiceImpl");
		return listaDipendenteDTO;
		}
		else
		{
			logger.info("Non posso ordinare l'elenco dei dipendenti in base al parametro " + sort);
			throw new ConcessionariaNotFoundException("Non posso ordinare l'elenco dei dipendenti in base al parametro" + sort);
		}
	}
}
