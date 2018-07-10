package TabPort.GUI;

import javax.swing.*;
import java.awt.*;

import javax.swing.table.DefaultTableModel;

import TabPort.Connections.DatabaseConnections;


public class MenuFrame extends JFrame {
	
	static DefaultTableModel model = new DefaultTableModel();
	Container cnt = this.getContentPane();
	static JTable jtbl = new JTable(model);
	
	public MenuFrame()throws Exception{
		
		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		populateData();
		
		JScrollPane pg = new JScrollPane(jtbl);
	    cnt.add(pg);
	    this.pack();
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
