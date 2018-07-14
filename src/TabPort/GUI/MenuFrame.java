package TabPort.GUI;

import javax.swing.*;
import java.awt.*;

import javax.swing.table.DefaultTableModel;

import TabPort.Connections.DatabaseConnections;


public class MenuFrame extends JFrame {
	
	static DefaultTableModel model = new DefaultTableModel();
	Container cnt = this.getContentPane();
	static JTable jtbl = new JTable(model);
	
	private JPanel panel;
    private JButton showReport;
    private JButton downloadReport;
    
	private void createComponents(){
		panel = new JPanel();
		showReport = new JButton("View Report");
		downloadReport = new JButton("Download");
	}
	
	public MenuFrame()throws Exception{
		
		cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		populateData();
		
		JScrollPane pg = new JScrollPane(jtbl);
	    cnt.add(pg);
	    this.pack();
	}
	
public static void populateData() throws Exception{
	   model.addColumn("userName");
	   model.addColumn("passwd");
	   
   // DatabaseConnections.connectLogin(model);
    
    
    
	}
	
}
