package it.luzi.automobili.dto;

import java.util.List;

public class ConcessionariaDTO 
{
	private int id;
	private String nome;
	private String indirizzo;
	private String citta;
	private int cap;
	private String codicefiscale;
	private List<AutomobileDTO> listaAutomobili;
	private List<DipendenteDTO> listaDipendenti;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getCodicefiscale() {
		return codicefiscale;
	}
	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}
	public List<AutomobileDTO> getListaAutomobili() {
		return listaAutomobili;
	}
	public void setListaAutomobili(List<AutomobileDTO> listaAutomobili) {
		this.listaAutomobili = listaAutomobili;
	}
	public List<DipendenteDTO> getListaDipendenti() {
		return listaDipendenti;
	}
	public void setListaDipendenti(List<DipendenteDTO> listaDipendenti) {
		this.listaDipendenti = listaDipendenti;
	}
	
	
	

}
