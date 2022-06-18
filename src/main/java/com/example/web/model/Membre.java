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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("Membre")
public class Membre extends User  {

	
	@Column(nullable = false)
	private double  budget;
	
	public Labo getLabo() {
		return labo;
	}

	public void setLabo(Labo labo) {
		this.labo = labo;
	}

	@OneToMany(mappedBy = "membre")
	@Column(nullable = true)
	@JsonIgnoreProperties("membre")
	List<Besoin> besoins;
	
	@ManyToOne
	@JoinColumn(name="labo_id")
	@JsonIgnoreProperties("membres")
	Labo labo;


	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public List<Besoin> getBesoins() {
		return besoins;
	}

	public void setBesoins(List<Besoin> besoins) {
		this.besoins = besoins;
	}

	@Override
	public String toString() {
		return "Membre [ budget=" + budget + ", besoins=" + besoins + ", labo=" + labo + "]";
	}

	
	
	
	
}
