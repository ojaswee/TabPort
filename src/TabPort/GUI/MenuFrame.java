package TabPort.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import TabPort.Connections.DatabaseConnections;


public class MenuFrame extends JFrame {
	
	static DefaultTableModel model = new DefaultTableModel();
	Container cnt = this.getContentPane();
	static JTable jtbl = new JTable(model);
	
	private JPanel panel;
    private JButton showReport;
    private JButton downloadReport;
    
	public MenuFrame() {
		super("TabPort Menu");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents();
		LayoutMenu();
		activateComponents();
	}
    
	
	private void createComponents(){
		panel = new JPanel();
		showReport = new JButton("View Report");
		downloadReport = new JButton("Download");
//		LayoutMenu();
	}
	
	public void LayoutMenu() {
		setSize(540, 345);
		panel.setLayout(null);
		
		//loginButton.setFont(GUICommonTools.TAHOMA_BOLD_14);
		showReport.setBounds(120, 114, 110, 23);
		downloadReport.setBounds(295, 114, 110, 23);
		
		panel.add(showReport);
		panel.add(downloadReport);
		add(panel);
	}
	private void activateComponents(){
		showReport.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					viewReport();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		});
		
	}
	public void viewReport() {
		System.out.println("Viewing Report");
	}
}
