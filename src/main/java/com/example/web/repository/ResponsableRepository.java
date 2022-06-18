package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.Responsable;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable,Long>{

}
