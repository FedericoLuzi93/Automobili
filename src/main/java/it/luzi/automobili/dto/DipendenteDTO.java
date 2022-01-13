package it.luzi.automobili.dto;

public class DipendenteDTO 
{
	private int id;
	private String nome;
	private String cognome;
	private String codicefiscale;
	private double stipendio;
	private ConcessionariaDTO concessionarieDTO;
	
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodicefiscale() {
		return codicefiscale;
	}
	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	public ConcessionariaDTO getConcessionarieDTO() {
		return concessionarieDTO;
	}
	public void setConcessionarieDTO(ConcessionariaDTO concessionarieDTO) {
		this.concessionarieDTO = concessionarieDTO;
	}
	
	

}
