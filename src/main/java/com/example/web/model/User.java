package com.example.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="profil")
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, length = 80)
	private String userName;
	
	@Column(nullable = false, length = 80)
	private String email;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable=false, insertable=false , updatable= false)
	private String profil;
	
	@Column(nullable = true)
	private String codeVerification;
	
	@Column(nullable = false)
	private boolean  enabled;
	
	@ManyToMany
	@JsonIgnoreProperties(value="users",allowSetters = true)
	List<Role> roles = new ArrayList<Role>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getCodeVerification() {
		return codeVerification;
	}

	public void setCodeVerification(String codeVerification) {
		this.codeVerification = codeVerification;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + ", profil="
				+ profil + ", codeVerification=" + codeVerification + ", enabled=" + enabled + ", roles=" + roles + "]";
	}
	
	
	
	

}
