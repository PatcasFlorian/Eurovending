package org.fasttrackit.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.fasttrackit.spring.helper.DBHelper;
import org.fasttrackit.spring.model.Categorii;
import org.fasttrackit.spring.model.SubCategorii;

public class SubCategoriiDAO {

	
	//Creare Tabela cu CategoriiProduse
	public void createTableSubCategorii() throws SQLException {
			DBHelper helper = new DBHelper();
			Connection con = helper.getConnectionCategorii();
			String insertCategorii = "CREATE TABLE IF NOT EXISTS lista_categorii_copil"+ 
					" (id INTEGER not NULL auto_increment primary key,nume_cat_parinte VARCHAR(250) NULL,nume_cat_copil VARCHAR(250) NULL,statut_categorie VARCHAR(15) NULL)";			
			Statement stmt = con.createStatement();      
		       stmt.execute(insertCategorii);
		       helper.closeConnection(con);
		       
		}
	
	//Insert  into table SubCategorii
	public void insertSubCategorii(SubCategorii categorie) throws SQLException {
		
		
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnectionCategorii();
		String insertCategorie = "insert into lista_categorii_copil"+ 
				"(nume_cat_parinte,nume_cat_copil,statut_categorie)"
				  +" value(?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(insertCategorie);
		ps.setString(1, categorie.getCategorieParinte());
		ps.setString(2, categorie.getCategorieCopil());
		ps.setString(3, categorie.getStatut());
		ps.executeUpdate();
		
		 helper.closeConnection(con);
	      }
	
	//verify if table SubCategorii is Empty
	public int verifyTableSubCategorii() throws SQLException {
		
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnectionCategorii();
		String selectUser = "SELECT * FROM lista_categorii_copil";
		int count = 0;	
	  Statement stmt = (PreparedStatement) con.prepareStatement(selectUser);
	  ResultSet rst = stmt.executeQuery(selectUser);
	      try {
	           while(rst.next()){
	              count++;
	           }
	          
	      } catch (SQLException ex) {
	              
	       }
	      helper.closeConnection(con);
	      return count;
	}
	
	//selectare listacategorieCopil dupa denumireCategorie din tabela
		public ArrayList<SubCategorii>  getListaSubCategorii(String numeCategorie) throws SQLException {
			ArrayList<SubCategorii> categorii = new ArrayList<SubCategorii> ();
			DBHelper helper = new DBHelper();
			Connection con = helper.getConnectionCategorii();
			String strSql = "select * from lista_categorii_copil where nume_cat_parinte = '"+numeCategorie+"'";
			Statement stmt;
			stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery(strSql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String numeCatParinte = rs.getString("nume_cat_parinte");
				
				String numeCatCopil = rs.getString("nume_cat_copil");
				
				String statut = rs.getString("statut_categorie");
				SubCategorii categorie = new SubCategorii(id,numeCatParinte, numeCatCopil,statut);
				categorii.add(categorie);
			}
			helper.closeConnection(con);
			return categorii;
			
			
		}
	
		//selectare categorieCopil dupa denumireCategorieCopil din tabela
		public SubCategorii getCategorieCopil(String numeCategorie ) throws SQLException {
			ArrayList<SubCategorii> subCategorii = new ArrayList<SubCategorii> ();
			SubCategorii categorie = null;
			DBHelper helper = new DBHelper();
			Connection con = helper.getConnectionCategorii();
			String strSql = "select*from lista_categorii_copil where nume_cat_copil =?";
			PreparedStatement stmt = con.prepareStatement(strSql);
			stmt.setString(1, numeCategorie);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String numeCatParinte = rs.getString("nume_cat_parinte");
				String numeCatCopil = rs.getString("nume_cat_copil");
				String statut = rs.getString("statut_categorie");
				categorie = new SubCategorii(id,numeCatParinte, numeCatCopil,statut);
			}
			
			helper.closeConnection(con);
			return categorie;	
		}

		//Delete/update categorie Copil
		public void deleteCatCopil(String denumireCategorie,String numeNouCategorie) throws SQLException {
			DBHelper helper = new DBHelper();
			Connection con = helper.getConnectionCategorii();
			//String deleteRow = "DELETE FROM lista_categorii WHERE nume_cat_copil = "+ denumireCategorie;
			String upDate = "update lista_categorii_copil set nume_cat_copil = '"+numeNouCategorie+"' where nume_cat_copil= '"+denumireCategorie+"'";
			PreparedStatement ps = con.prepareStatement(upDate);
			//ps.setString(2, denumireCategorie);
			ps.executeUpdate();
			helper.closeConnection(con);
		}
}
