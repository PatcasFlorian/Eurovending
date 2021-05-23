package org.fasttrackit.spring.helper;

import java.sql.SQLException;
import java.util.ArrayList;


import org.fasttrackit.spring.dao.CategoriiDAO;
import org.fasttrackit.spring.dao.SubCategoriiDAO;
import org.fasttrackit.spring.dao.UserDAO;
import org.fasttrackit.spring.model.Categorii;
import org.fasttrackit.spring.model.SubCategorii;
import org.fasttrackit.spring.model.User;
import org.fasttrackit.spring.password.PasswordUtils;

public class MainTest {

	public static void main(String[] args) {
		
		PasswordUtils uPassword = new PasswordUtils();
		String salt = null ;
		String adminPassword = "admin21782619";
		String email = "patcasf12@gmail.com";
		salt = uPassword.getSalt(30);
		String generatePassword = null;
		 generatePassword = uPassword.generateSecurePassword( adminPassword,salt);
		
		String numeCatParinte = "Interupatoare Touch";
		String numeCatParinte1 = "Arduino";
		String numeCatCopil = "Interupatoare Touch 1/1";
		String numeCatCopil1 = "Interupatoare Touch 1/2";
		String numeCatCopil2 = "Interupatoare Touch 2/2";
		String numeCatCopil3 = "PlaciDezvoltare";
		String numeCatCopil4 = "Placi Shield";
		String statut ="PUBLICAT";
		Categorii categorie = new Categorii(1,numeCatParinte,"PUBLICAT");
		Categorii categorie1 = new Categorii(2,numeCatParinte1,"PUBLICAT");
		SubCategorii subCategorie = new SubCategorii(1,numeCatParinte,numeCatCopil,"PUBLICAT");
		SubCategorii subCategorie1 = new SubCategorii(1,numeCatParinte,numeCatCopil1,"PUBLICAT");
		SubCategorii subCategorie2 = new SubCategorii(1,numeCatParinte,numeCatCopil2,"PUBLICAT");
		SubCategorii subCategorie3 = new SubCategorii(1,numeCatParinte1,numeCatCopil3,"PUBLICAT");
		SubCategorii subCategorie4 = new SubCategorii(1,numeCatParinte1,numeCatCopil4,"PUBLICAT");
		User user =new User(1,"Patcas Florentina","+40745556533","patcasf12@gmail.com",salt,generatePassword,"ADMIN","ACTIVE");
		User user1 =new User();
		ArrayList<Categorii>listCategorii = new ArrayList<Categorii>();
		System.out.println("ID :");
		CategoriiDAO cdao = new CategoriiDAO();
		SubCategoriiDAO scdao = new SubCategoriiDAO();
		try {
			cdao.createTableCategorii();
			scdao.createTableSubCategorii();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		/*
		try {
			cdao.insertCategorie(categorie);
			cdao.insertCategorie(categorie1);
			scdao.insertSubCategorii(subCategorie);
			scdao.insertSubCategorii(subCategorie1);
			scdao.insertSubCategorii(subCategorie2);
			scdao.insertSubCategorii(subCategorie3);
			scdao.insertSubCategorii(subCategorie4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		try {
			cdao.insertCategorie(categorie1);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		UserDAO udao =new UserDAO();
		System.out.println("Tabela User:");
		
		 try {
			udao.createTableUser();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			udao.insertUser(user);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 boolean adminPasswordMatch=false;
		 
		 try {
			user1 =udao.getOneUser("Patcas Florentina");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 String myPassword ="admin21782619";
		 String myEmail = "patcasf12@gmail.com";
		 String verifyPassword = user1.getPassword();
		 String adminSalt = user1.getSalt();
			adminPasswordMatch = PasswordUtils.verifyUserPassword( myPassword,user1.getPassword(), user1.getSalt());
			System.out.println("PasswMatch "+adminPasswordMatch);
        if((adminPasswordMatch==true)&&(user1.getEmail().equalsIgnoreCase(myEmail))) 
        {
		System.out.println("IDUser : " +user1.getId()+" FullName "+user1.getFullName());
        }
		try {
			categorie = cdao.getCategorieByNume(numeCatParinte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ID1 :"+categorie.getNumeCatParinte());
		try {
			listCategorii = cdao.getListaCategorii();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Categorii cat:listCategorii) {
			System.out.println("Id:"+cat.getId()+" Den "+cat.getNumeCatParinte());
		}
	}
*/
	 }
	}
}
