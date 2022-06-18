package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.web.model.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long>{
	
	@Query("select r from Role r where r.nom=:name")
	public Role getRoleByName( @Param("name") String name);

}
