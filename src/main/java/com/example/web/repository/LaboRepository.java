package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.web.model.Labo;

@Repository
public interface LaboRepository extends JpaRepository<Labo,Long> {
	
	@Query("select l from Labo l where l.id=:id")
	public Labo getOneLabo(@Param("id") Long id);
	

}
