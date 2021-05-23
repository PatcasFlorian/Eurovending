package org.fasttrackit.spring.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	
	public Connection getConnectionDB(){
        Properties connectionProps = new Properties();
        connectionProps.put("user",  "europart_root");
        connectionProps.put("password","luca77dgl@");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection(
                    "jdbc:" + "mysql" + "://" +
                            "185.146.87.240" +
                            ":" + "3306" + "/"+
                            "",
                    connectionProps);
        } catch (SQLException ex) {
            // handle any errors
            ex.printStackTrace();
        } catch (Exception ex) {
            // handle any errors
            ex.printStackTrace();
        }
        return null;
    }
	
	public Connection getConnectionCategorii()  {
		Properties connectionsProps = new Properties();
		connectionsProps.put("user", "europart_root");
		connectionsProps.put("password", "luca77dgl@");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//return DriverManager.getConnection("jdbc:mysql://185.146.87.240/europart_test1?serverTimezone=UTC",
				//	connectionsProps);
			return DriverManager.getConnection("jdbc:mysql://185.146.87.240/europart_test1?serverTimezone=UTC",
					connectionsProps);
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
