package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.web.model.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long>{

	@Query("select b from Budget b where b.id=:id")
	public Budget getOneBudget(@Param("id") Long id);
	
	@Query("select b from Budget b where b.annee=:year")
    public Budget getByYear(@Param("year") int year);
}
