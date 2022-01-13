package it.luzi.automobili.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="concessionarie")
public class Concessionaria 
{
	@Id												
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="indirizzo")
	private String indirizzo;
	
	@Column(name="citta")
	private String citta;
	
	@Column(name="cap")
	private int cap;
	
	@Column(name="codicefiscale")
	private String codicefiscale;
	
	@OneToMany(	mappedBy="concessionarie",
			cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Automobile> automobiliLista;
	
	@OneToMany(	mappedBy="concessionarie",
			cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Dipendente> dipendentiLista;
	
	public Concessionaria()
	{
		
	}

	public Concessionaria(String nome, String indirizzo, String citta, int cap, String codicefiscale,
			List<Automobile> automobiliLista) 
	{
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.cap = cap;
		this.codicefiscale = codicefiscale;
		this.automobiliLista = automobiliLista;
	}
	
	public void add(Automobile autoMom)
	{
		if(automobiliLista == null)
		{
			automobiliLista = new ArrayList<Automobile>();
		}
		automobiliLista.add(autoMom);
		autoMom.setConcessionarie(this);
	}
	
	public void add(Dipendente dipeMoM)
	{
		if(dipendentiLista == null)
		{
			dipendentiLista = new ArrayList<Dipendente>();
		}
		dipendentiLista.add(dipeMoM);
		dipeMoM.setConcessionarie(this);
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

	public List<Automobile> getAutomobiliLista() {
		return automobiliLista;
	}

	public void setAutomobiliLista(List<Automobile> automobiliLista) {
		this.automobiliLista = automobiliLista;
	}

	public List<Dipendente> getDipendentiLista() {
		return dipendentiLista;
	}

	public void setDipendentiLista(List<Dipendente> dipendentiLista) {
		this.dipendentiLista = dipendentiLista;
	}
	
	
	
}
