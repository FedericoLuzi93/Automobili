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
@Table(name="automobile")
public class Automobile 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="targa")
	private String targa;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="modello")
	private String modello;
	
	@Column(name="anno")
	private int anno;
	
	@ManyToOne(	cascade={CascadeType.PERSIST, CascadeType.DETACH,
		 	CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="concessionarioId")
	private Concessionaria concessionarie;
	
	public Automobile()
	{
		
	}
	
	public Automobile(String targa, String marca, String modello, int anno, Concessionaria concessionarie) 
	{
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.anno = anno;
		this.concessionarie = concessionarie;
	}
	
	public Automobile(String targaAuto)
	{
		this.targa = targaAuto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Concessionaria getConcessionarie() {
		return concessionarie;
	}

	public void setConcessionarie(Concessionaria concessionarie) {
		this.concessionarie = concessionarie;
	}
}
