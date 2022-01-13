package it.luzi.automobili.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.luzi.automobili.entities.Concessionaria;


public interface ConcessionarieRepository extends JpaRepository<Concessionaria, Integer> 
{
	//Concessionaria è entity
//	@Query("select max(id) from Concessionaria c where c.citta = :cittaConcessionarie")
//	public Integer getMaxId(String cittaConcessionarie);
	
	@Query("select max(id) from Concessionaria")
	public Integer getMaxId();

}
