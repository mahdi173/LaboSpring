package com.example.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Budget {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, length = 4)
	private int annee;	
	
	@Column(nullable = false)
	private double  dotationBase;	
	
	@Column(nullable = false)
	private double  dotationRecherche;	
	
	@ManyToOne
	@JsonIgnoreProperties(value="budgets",allowSetters = true)
	Labo lab;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public double getDotationBase() {
		return dotationBase;
	}

	public void setDotationBase(double dotationBase) {
		this.dotationBase = dotationBase;
	}

	public double getDotationRecherche() {
		return dotationRecherche;
	}

	public void setDotationRecherche(double dotationRecherche) {
		this.dotationRecherche = dotationRecherche;
	}

	public Labo getLab() {
		return lab;
	}

	public void setLab(Labo lab) {
		this.lab = lab;
	}

	@Override
	public String toString() {
		return "Budget [id=" + id + ", annee=" + annee + ", dotationBase=" + dotationBase + ", dotationRecherche="
				+ dotationRecherche + ", lab=" + lab + "]";
	}
	

}
