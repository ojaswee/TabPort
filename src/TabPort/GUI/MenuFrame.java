package TabPort.GUI;

import javax.swing.*;
import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import TabPort.Connections.DatabaseConnections;


public class LoginFrame extends JFrame {
	
	static DefaultTableModel model = new DefaultTableModel();
	Container cnt = this.getContentPane();
	static JTable jtbl = new JTable(model);
	
	public LoginFrame()throws Exception{
		
		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		populateData();

	}
	
public static void populateData() throws Exception{
		
	   
	   model.addColumn("username");
	   model.addColumn("origin");
	   model.addColumn("destination");
	   model.addColumn("tripdate");
	   model.addColumn("triptime");
	   model.addColumn("number");
	   
    DatabaseConnections.connectLogin(model);
    
	}
	
}
