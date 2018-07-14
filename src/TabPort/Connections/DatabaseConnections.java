package TabPort.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import TabPort.GUI.MenuFrame;
import TabPort.Main.Home;


public class DatabaseConnections {
	
    private static Connection databaseConnection = null;
	   
	public static void connect () throws Exception{
		
		   String driver = "com.mysql.cj.jdbc.Driver";
	       String dbuser ="root";
		   String dbpasswd="root";
		   String db="tabport";
		   String url="jdbc:mysql://localhost/"+db + "?useSSL=false";
		   
		   try {
		   Class.forName(driver);
		   databaseConnection = DriverManager.getConnection(url, dbuser, dbpasswd);
		   }catch (Exception e) {
			   throw new Exception("mysql connection error "+ e.getMessage());
		   }
		   
	}
		 
	public static ResultSet connectLogin(String userName, String passwd) throws Exception{
		connect();
		try {
			String query = "SELECT * FROM user_login where user_name ='"+userName+"'AND passwords ='"+passwd +"';";
		    PreparedStatement pstm = databaseConnection.prepareStatement(query);
		    ResultSet Rs = pstm.executeQuery();
		    return (Rs);
		    }
		catch (Exception e) {
		   throw new Exception("mysql connection error "+ e.getMessage());
		   }
    }

}
