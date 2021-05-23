package org.fasttrackit.spring.model;

import java.util.ArrayList;

public class Categorii {
	private int id;
	private String numeCatParinte;
	private String statut;
	
	
	public Categorii() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Categorii(String numeCatParinte, String statut) {
		super();
		this.numeCatParinte = numeCatParinte;
		this.statut = statut;
	}


	public Categorii(int id, String numeCatParinte, String statut) {
		super();
		this.id = id;
		this.numeCatParinte = numeCatParinte;
		this.statut = statut;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumeCatParinte() {
		return numeCatParinte;
	}


	public void setNumeCatParinte(String numeCatParinte) {
		this.numeCatParinte = numeCatParinte;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	
}
