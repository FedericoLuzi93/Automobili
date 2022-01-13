package it.luzi.automobili.dto;

public class AutomobileDTO 
{
	private int id;
	private String targa;
	private String marca;
	private String modello;
	private int anno;
	private ConcessionariaDTO concessionarieDTO;
	
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
	public ConcessionariaDTO getConcessionarieDTO() {
		return concessionarieDTO;
	}
	public void setConcessionarieDTO(ConcessionariaDTO concessionarieDTO) {
		this.concessionarieDTO = concessionarieDTO;
	}
	
	
	
}
