package it.luzi.automobili.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.luzi.automobili.entities.Dipendente;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer>
{
	
	@Query("select d from Dipendente d where d.concessionarie.id = :idConcessionaria")
	public List<Dipendente> findByIdConcessionaria(int idConcessionaria);

	@Query("select d from Dipendente d where d.concessionarie.id = :idConcessionaria")
	public Page<Dipendente> findAllUsersWithPagination(int idConcessionaria, Pageable pageable);

}
