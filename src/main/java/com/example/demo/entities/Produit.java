package com.example.demo.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Produit {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@javax.validation.constraints.NotNull
	@Size(min=1, max=10)
	private String designation;
	@Column
	@javax.validation.constraints.NotNull
	private double prix;
	@Column
	@javax.validation.constraints.NotNull
	private int quantite;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	public Produit(Long id, String designation, double prix, int quantite) {
		super();
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Produit() {
		super();
	}
	
	
	
}
