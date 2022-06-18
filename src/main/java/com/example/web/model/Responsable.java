package com.example.web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("Responsable")
public class Responsable extends User {

	
	@Column(nullable = false)
	private int  grade;
	
	@OneToMany(mappedBy = "respo")
	@Column(nullable = true)
	@JsonIgnoreProperties("respo")
	 List<Labo> laboratoires;


	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public List<Labo> getLaboratoires() {
		return laboratoires;
	}

	public void setLaboratoires(List<Labo> laboratoires) {
		this.laboratoires = laboratoires;
	}

	@Override
	public String toString() {
		return "Responsable [ grade=" + grade + ", laboratoires=" + laboratoires + "]";
	}
	
	
}
