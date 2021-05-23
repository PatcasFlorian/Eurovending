package org.fasttrackit.spring.model;

import java.util.ArrayList;

public class SubCategorii {
	private int id ;
	private String categorieParinte;
	private String categorieCopil;
	private String statut;
	
	
	
	public SubCategorii() {
		super();
	}



	public SubCategorii(String categorieParinte, String categorieCopil, String statut) {
		super();
		this.categorieParinte = categorieParinte;
		this.categorieCopil = categorieCopil;
		this.statut = statut;
	}



	public SubCategorii(int id, String categorieParinte, String categorieCopil, String statut) {
		super();
		this.id = id;
		this.categorieParinte = categorieParinte;
		this.categorieCopil = categorieCopil;
		this.statut = statut;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCategorieParinte() {
		return categorieParinte;
	}



	public void setCategorieParinte(String categorieParinte) {
		this.categorieParinte = categorieParinte;
	}



	public String getCategorieCopil() {
		return categorieCopil;
	}



	public void setCategorieCopil(String categorieCopil) {
		this.categorieCopil = categorieCopil;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}





}
