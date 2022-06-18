package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.web.model.Besoin;

@Repository
public interface BesoinRepository extends JpaRepository<Besoin,Long> {
	
	@Query("select b from Besoin b where b.id=:id")
	public Besoin getOneBesoin(@Param("id") Long id);

}
