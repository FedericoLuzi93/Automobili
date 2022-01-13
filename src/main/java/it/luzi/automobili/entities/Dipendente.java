package it.luzi.automobili.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Dipendente")
public class Dipendente 
{
	@Id												
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="codicefiscale")
	private String codicefiscale;
	
	@Column(name="stipendio")
	private double stipendio;
	
	@ManyToOne(	cascade={CascadeType.PERSIST, CascadeType.DETACH,
		 	CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="concessionarioId")
	private Concessionaria concessionarie;
	
	public Dipendente()
	{
		
	}

	public Dipendente(int id, String nome, String cognome, String codicefiscale, double stipendio, Concessionaria concessionarie) 
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codicefiscale = codicefiscale;
		this.stipendio = stipendio;
		this.concessionarie = concessionarie;
	}
	
	public Dipendente(String nome, String cognome, double stipendio, Concessionaria concessionarie)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.stipendio = stipendio;
		this.concessionarie = concessionarie;
	}
	
	

	@Override
	public String toString() {
		return "Dipendente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codicefiscale=" + codicefiscale
				+ ", stipendio=" + stipendio + ", concessionarie=" + concessionarie + "]";
	}

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

	public Concessionaria getConcessionarie() {
		return concessionarie;
	}

	public void setConcessionarie(Concessionaria concessionarie) {
		this.concessionarie = concessionarie;
	}
	
	
}
