package com.example.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.web.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query("select u from User u where u.email=:email")
	public User getUser(@Param("email") String email);
	
	@Query("select u from User u where u.codeVerification=:code")
	public User getUserByCode(@Param("code") String code);
	
    @Query("select u from User u where u.profil='Responsable' or u.profil='Admin' ")
	public List<User> findAllRespoAdmin();

}
