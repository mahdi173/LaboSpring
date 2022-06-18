package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>  {

}
