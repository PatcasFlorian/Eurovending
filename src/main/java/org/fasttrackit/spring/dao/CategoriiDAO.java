package org.fasttrackit.spring.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.fasttrackit.spring.helper.DBHelper;
import org.fasttrackit.spring.model.Categorii;
import org.fasttrackit.spring.model.User;
public class CategoriiDAO {
	
ArrayList<Categorii> categorii = new ArrayList<Categorii> ();
	
//Creare Tabela cu CategoriiProduse
public void createTableCategorii() throws SQLException {
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnectionCategorii();
		String insertCategorii = "CREATE TABLE IF NOT EXISTS lista_categorii"+ 
				" (id INTEGER not NULL auto_increment primary key,nume_cat_parinte VARCHAR(250) NULL,statut_categorie VARCHAR(15) NULL)";			
		Statement stmt = con.createStatement();      
	       stmt.execute(insertCategorii);
	       helper.closeConnection(con);
	       
	}


//Insert  into table Categorii
public void insertCategorie(Categorii categorie) throws SQLException {
	
	
	DBHelper helper = new DBHelper();
	Connection con = helper.getConnectionCategorii();
	String insertCategorie = "insert into lista_categorii"+ 
			"(nume_cat_parinte,statut_categorie)"
			  +" value(?,?)";
	
	PreparedStatement ps = con.prepareStatement(insertCategorie);
	ps.setString(1, categorie.getNumeCatParinte());
	ps.setString(2, categorie.getStatut());
	ps.executeUpdate();
	
	 helper.closeConnection(con);
      }

//verify if table categorii is Empty
public int verifyTableUser() throws SQLException {
	
	DBHelper helper = new DBHelper();
	Connection con = helper.getConnectionCategorii();
	String selectUser = "SELECT * FROM lista_categorii";
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

//afisare continut tabela Categorii
	public ArrayList<Categorii>  getListaCategorii() throws SQLException {
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnectionCategorii();
		String strSql = "select * from lista_categorii";
		Statement stmt;
		stmt= con.createStatement();
		ResultSet rs = stmt.executeQuery(strSql);
		while(rs.next()) {
			int id = rs.getInt("id");
			String numeCatParinte = rs.getString("nume_cat_parinte");
			String statut = rs.getString("statut_categorie");
			Categorii categorie = new Categorii(id,numeCatParinte,statut);
			categorii.add(categorie);
		}
		helper.closeConnection(con);
		return categorii;
		
		
	}
	
	//Delete/update categorie Parinte
			public void updateCatParinte(String denumireCategorie,Categorii newCategorie) throws SQLException {
				DBHelper helper = new DBHelper();
				Connection con = helper.getConnectionCategorii();
				Connection con1 = helper.getConnectionCategorii();
				//String deleteRow = "DELETE FROM lista_categorii WHERE nume_cat_copil = "+ denumireCategorie;
				String upDateCategorii = "update lista_categorii set nume_cat_parinte = '"+newCategorie.getNumeCatParinte()+"' where nume_cat_parinte= '"+denumireCategorie+"'";
				String upDateCategoriiStatut = "update lista_categorii set statut_categorie = '"+newCategorie.getStatut()+"' where nume_cat_parinte= '"+denumireCategorie+"'";
				String upDateSubCategorii = "update lista_categorii_copil set nume_cat_parinte = '"+newCategorie.getNumeCatParinte()+"' where nume_cat_parinte= '"+denumireCategorie+"'";
				PreparedStatement ps = con.prepareStatement(upDateCategorii);
				PreparedStatement ps1 = con.prepareStatement(upDateCategoriiStatut);
				PreparedStatement ps2 = con1.prepareStatement(upDateSubCategorii);
				ps.executeUpdate();
				ps1.executeUpdate();
				ps2.executeUpdate();
				helper.closeConnection(con);
				helper.closeConnection(con1);
			}
	
	//selectare categorieParinte dupa denumireCategorie din tabela
public Categorii getCategorieParinte(String numeCategorie ) throws SQLException {
		
		Categorii categorie = null;
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnectionCategorii();
		String strSql = "select*from lista_categorii where nume_cat_parinte =?";
		PreparedStatement stmt = con.prepareStatement(strSql);
		stmt.setString(1, numeCategorie);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("id");
			String numeCatParinte = rs.getString("nume_cat_parinte");
			String statut = rs.getString("statut_categorie");
			categorie = new Categorii(id,numeCatParinte,statut);
		}
		
		helper.closeConnection(con);
		return categorie;	
	}

//selectare categorieParinte dupa id din tabela
public Categorii getIdCategorieParinte(int id ) throws SQLException {
		
		Categorii categorie = null;
		DBHelper helper = new DBHelper();
		Connection con = helper.getConnectionCategorii();
		String strSql = "select*from lista_categorii where id =?";
		PreparedStatement stmt = con.prepareStatement(strSql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			int id1 = rs.getInt("id");
			String numeCatParinte = rs.getString("nume_cat_parinte");
			String statut = rs.getString("statut_categorie");
			categorie = new Categorii(id1,numeCatParinte,statut);
		}
		
		helper.closeConnection(con);
		return categorie;	
	}



/*
//selectare categorieCopil dupa denumireCategorie din tabela
public Categorii getCategorieCopil(String numeCategorie ) throws SQLException {
	
	Categorii categorie = null;
	DBHelper helper = new DBHelper();
	Connection con = helper.getConnectionCategorii();
	String strSql = "select*from lista_categorii where nume_cat_copil =?";
	PreparedStatement stmt = con.prepareStatement(strSql);
	stmt.setString(1, numeCategorie);
	ResultSet rs = stmt.executeQuery();
	if(rs.next()) {
		int id = rs.getInt("id");
		String numeCatParinte = rs.getString("nume_cat_parinte");
		String numeCatCopil = rs.getString("nume_cat_copil");
		String statut = rs.getString("statut_categorie");
		categorie = new Categorii(id,numeCatParinte, numeCatCopil,statut);
	}
	
	helper.closeConnection(con);
	return categorie;	
}
*/

//Delete categorie parinte
		public void deleteCatParinte(String denumireCategorie) throws SQLException {
			DBHelper helper = new DBHelper();
			Connection con = helper.getConnectionCategorii();
			String deleteRow = "DELETE FROM lista_categorii WHERE nume_cat_parinte=?";
			PreparedStatement ps = con.prepareStatement(deleteRow);
			ps.setString(1, denumireCategorie);
			ps.executeUpdate();
			helper.closeConnection(con);
		}
		
		

}
