package it.luzi.automobili.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.luzi.automobili.entities.Automobile;

public interface AutomobileRepository extends JpaRepository<Automobile, Integer>
{
	@Query("select a from Automobile a where a.concessionarie.id = :idConcessionaria")
	public List<Automobile> findByIdConcessionaria(int idConcessionaria);
}
