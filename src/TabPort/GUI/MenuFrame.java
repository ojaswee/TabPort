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
    private JButton showReportButton;
    private JButton myReportsButton;
    
	public MenuFrame() {
		super("TabPort Menu");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents();
		LayoutMenu();
		activateComponents();
	}
    
	
	private void createComponents(){
		panel = new JPanel();
		showReportButton = new JButton("Request Report");
		myReportsButton = new JButton("My Reports");
	}
	
	public void LayoutMenu() {
		setSize(540, 345);
		panel.setLayout(null);
		
		//loginButton.setFont(GUICommonTools.TAHOMA_BOLD_14);
		showReportButton.setBounds(100, 114, 130, 23);
		myReportsButton.setBounds(295, 114, 110, 23);
		
		panel.add(showReportButton);
		panel.add(myReportsButton);
		add(panel);
	}
	private void activateComponents(){
		showReportButton.addActionListener(new ActionListener(){
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
		
		myReportsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dwnldReport();
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	public void viewReport() {
		System.out.println("Requesting Report");
	}
	
	public void dwnldReport() {
		System.out.println("My Report");
		
	}
}
