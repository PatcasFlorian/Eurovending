package org.fasttrackit.spring.model;

import java.io.InputStream;

public class Produs {
	
	private int id;
	private String denumireProdus;
	private String descriereProdus;
	private double pretUnitar;
	private double pretPromotional;
	private String procentReducere;
	private double stocProdus;
	private double atentionareStoc; //cantitate minima de avertizare
	private boolean statuteProdus; //publicat,nepublicat(true,false)
	

	private InputStream photo1;
	private InputStream  photo2;
	private InputStream  photo3;
	private InputStream  photo4;
	private InputStream  photo5;

	private byte[] img1;
	private byte[] img2;
	private byte[] img3;
	private byte[] img4;
	private byte[] img5;
	public Produs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Produs(String denumireProdus, String descriereProdus, double pretUnitar, double pretPromotional,
			String procentReducere, double stocProdus, double atentionareStoc, boolean statuteProdus,
			InputStream photo1, InputStream photo2, InputStream photo3, InputStream photo4, InputStream photo5) {
		super();
		this.denumireProdus = denumireProdus;
		this.descriereProdus = descriereProdus;
		this.pretUnitar = pretUnitar;
		this.pretPromotional = pretPromotional;
		this.procentReducere = procentReducere;
		this.stocProdus = stocProdus;
		this.atentionareStoc = atentionareStoc;
		this.statuteProdus = statuteProdus;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.photo5 = photo5;
	}



	public Produs(int id, String denumireProdus, String descriereProdus, double pretUnitar, double pretPromotional,
			String procentReducere, double stocProdus, double atentionareStoc, boolean statuteProdus,
			InputStream photo1, InputStream photo2, InputStream photo3, InputStream photo4, InputStream photo5) {
		super();
		this.id = id;
		this.denumireProdus = denumireProdus;
		this.descriereProdus = descriereProdus;
		this.pretUnitar = pretUnitar;
		this.pretPromotional = pretPromotional;
		this.procentReducere = procentReducere;
		this.stocProdus = stocProdus;
		this.atentionareStoc = atentionareStoc;
		this.statuteProdus = statuteProdus;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.photo5 = photo5;
	}



	public Produs(int id, String denumireProdus, String descriereProdus, double pretUnitar, double pretPromotional,
			String procentReducere, double stocProdus, double atentionareStoc, boolean statuteProdus, byte[] img1,
			byte[] img2, byte[] img3, byte[] img4, byte[] img5) {
		super();
		this.id = id;
		this.denumireProdus = denumireProdus;
		this.descriereProdus = descriereProdus;
		this.pretUnitar = pretUnitar;
		this.pretPromotional = pretPromotional;
		this.procentReducere = procentReducere;
		this.stocProdus = stocProdus;
		this.atentionareStoc = atentionareStoc;
		this.statuteProdus = statuteProdus;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDenumireProdus() {
		return denumireProdus;
	}



	public void setDenumireProdus(String denumireProdus) {
		this.denumireProdus = denumireProdus;
	}



	public String getDescriereProdus() {
		return descriereProdus;
	}



	public void setDescriereProdus(String descriereProdus) {
		this.descriereProdus = descriereProdus;
	}



	public double getPretUnitar() {
		return pretUnitar;
	}



	public void setPretUnitar(double pretUnitar) {
		this.pretUnitar = pretUnitar;
	}



	public double getPretPromotional() {
		return pretPromotional;
	}



	public void setPretPromotional(double pretPromotional) {
		this.pretPromotional = pretPromotional;
	}



	public String getProcentReducere() {
		return procentReducere;
	}



	public void setProcentReducere(String procentReducere) {
		this.procentReducere = procentReducere;
	}



	public double getStocProdus() {
		return stocProdus;
	}



	public void setStocProdus(double stocProdus) {
		this.stocProdus = stocProdus;
	}



	public double getAtentionareStoc() {
		return atentionareStoc;
	}



	public void setAtentionareStoc(double atentionareStoc) {
		this.atentionareStoc = atentionareStoc;
	}



	public boolean isStatuteProdus() {
		return statuteProdus;
	}



	public void setStatuteProdus(boolean statuteProdus) {
		this.statuteProdus = statuteProdus;
	}



	public InputStream getPhoto1() {
		return photo1;
	}



	public void setPhoto1(InputStream photo1) {
		this.photo1 = photo1;
	}



	public InputStream getPhoto2() {
		return photo2;
	}



	public void setPhoto2(InputStream photo2) {
		this.photo2 = photo2;
	}



	public InputStream getPhoto3() {
		return photo3;
	}



	public void setPhoto3(InputStream photo3) {
		this.photo3 = photo3;
	}



	public InputStream getPhoto4() {
		return photo4;
	}



	public void setPhoto4(InputStream photo4) {
		this.photo4 = photo4;
	}



	public InputStream getPhoto5() {
		return photo5;
	}



	public void setPhoto5(InputStream photo5) {
		this.photo5 = photo5;
	}



	public byte[] getImg1() {
		return img1;
	}



	public void setImg1(byte[] img1) {
		this.img1 = img1;
	}



	public byte[] getImg2() {
		return img2;
	}



	public void setImg2(byte[] img2) {
		this.img2 = img2;
	}



	public byte[] getImg3() {
		return img3;
	}



	public void setImg3(byte[] img3) {
		this.img3 = img3;
	}



	public byte[] getImg4() {
		return img4;
	}



	public void setImg4(byte[] img4) {
		this.img4 = img4;
	}



	public byte[] getImg5() {
		return img5;
	}



	public void setImg5(byte[] img5) {
		this.img5 = img5;
	}

	

}
