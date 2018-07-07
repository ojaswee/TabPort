package TabPort.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;


public class DatabaseConnections {
	
	   public static String user;
	   public static String passwd;
	   public static String db;
	   
	   public static String url;
	   
	   public static Connection con;

	public DatabaseConnections() throws SQLException {
		super();
		
		   user="root";
		   passwd="";
		   db="rideshare";
		   url="jdbc:mysql://localhost/"+db;
		   con = DriverManager.getConnection(url,user,passwd);
	}
	   
	public static void connectLogin( DefaultTableModel model ) throws Exception{
		
		
		try {
			   System.out.println("HELLO--");
		       PreparedStatement pstm = con.prepareStatement("SELECT * FROM trip ");
		       ResultSet Rs = pstm.executeQuery();
		       
		       System.out.println("Rs");
		       while(Rs.next()){
		           model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
		           System.out.println("hello from rs");
		           System.out.println(Rs.getInt(1)+ Rs.getString(2)+Rs.getString(3)+Rs.getString(4));
		       }
		   } catch (Exception e) {
		       System.out.println(e.getMessage());
		   }
		
		
	}
	   

}
