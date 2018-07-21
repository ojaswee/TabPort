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
    private JButton requestReportButton;
    private JButton monitorReportsButton;
    private JButton reportsHistoryButton;
    
	public MenuFrame() {
		super("TabPort Menu");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents();
		LayoutMenu();
		activateComponents();
	}
    
	
	private void createComponents(){
		panel = new JPanel();
		requestReportButton = new JButton("Request Report");
		monitorReportsButton = new JButton("Monitor");
		reportsHistoryButton = new JButton("History");
	}
	
	public void LayoutMenu() {
		setSize(340, 345);
		panel.setLayout(null);
		
		//loginButton.setFont(GUICommonTools.TAHOMA_BOLD_14);
		requestReportButton.setBounds(100, 80, 130, 23);
		monitorReportsButton.setBounds(100, 150, 130, 23);
		reportsHistoryButton.setBounds(100,220, 130, 23);
		
		panel.add(requestReportButton);
		panel.add(monitorReportsButton);
		panel.add(reportsHistoryButton);

		add(panel);
	}
	private void activateComponents(){
		requestReportButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					requestReport();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		});
		monitorReportsButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					monitorReport();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		});
		
		reportsHistoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					myReportHistory();
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	public void requestReport() {
		System.out.println("Requesting Report");
		RequestReport RR = new RequestReport();
		RR.setVisible(true);
		//dispose();
	}
	public void monitorReport() {
		System.out.println("Monitor Report");
		MonitorFrame monitor = new MonitorFrame();
		monitor.setVisible(true);
		//dispose();
	}
	
	public void myReportHistory() {
		System.out.println("History Frame");
		HistoryFrame history = new HistoryFrame();
		history.setVisible(true);	
	}
}
