package com.example.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.web.model.Membre;

@Repository
public interface MembreRepository extends JpaRepository<Membre,Long> {
	
	@Query("select m from Membre m where m.id=:id")
	public Membre getOneMembre(@Param("id") Long id);
	
	@Query("select m from Membre m where m.enabled=true")
	public List<Membre>  getAllActiveMembres();

}
