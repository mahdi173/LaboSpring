package com.example.web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Labo {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, length = 65)
	private String nom;	
	
	@ManyToOne
	@JoinColumn(name="respo_id")
	@JsonIgnoreProperties("laboratoires")
	Responsable respo;
	
	@OneToMany(mappedBy = "lab")
	@JsonIgnoreProperties(value="lab",allowSetters = true)
	List<Budget> budgets;
	

	@OneToMany(mappedBy = "labo")
    @Column(nullable = true)
	@JsonIgnoreProperties("labo")
	List<Membre> membres;


	public Long getId() {
		return id;
	}

	public List<Membre> getMembres() {
		return membres;
	}

	public void setMembres(List<Membre> membres) {
		this.membres = membres;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Responsable getRespo() {
		return respo;
	}

	public void setRespo(Responsable respo) {
		this.respo = respo;
	}

	public List<Budget> getBudgets() {
		return budgets;
	}

	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}

	@Override
	public String toString() {
		return "Labo [id=" + id + ", nom=" + nom + ", respo=" + respo + ", budgets=" + budgets + ", membres=" + membres
				+ "]";
	}

	

	
	
	

}
