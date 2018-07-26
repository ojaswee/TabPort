package TabPort.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import TabPort.Connections.DatabaseConnections;
import TabPort.Objects.User;


public class MenuFrame extends JDialog {
	
	private static final long serialVersionUID = 1L;

    private JButton requestReportButton;
    private JButton monitorReportsButton;
    private JButton reportsHistoryButton;
    
    private LoginFrame parent;
    public User currentuser;
    
	public MenuFrame( LoginFrame parent, User currentuser) {
		super(parent, "TabPort Menu");
		this.parent = parent;
		this.currentuser = currentuser;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		createComponents();
		LayoutMenu();
		activateComponents();
		
		pack(); // need to pack all components and display
		setModalityType(ModalityType.APPLICATION_MODAL);
		setAlwaysOnTop(true);
		setResizable(false);
        setLocationRelativeTo(parent);	
	}
    
	
	private void createComponents(){
		
		requestReportButton = new JButton("Request Report");
		requestReportButton.setFont(GUICommonTools.TAHOMA_BOLD_13);
		monitorReportsButton = new JButton("Monitor Reports");
		monitorReportsButton.setFont(GUICommonTools.TAHOMA_BOLD_13);
		reportsHistoryButton = new JButton("View History");
		reportsHistoryButton.setFont(GUICommonTools.TAHOMA_BOLD_13);
	}
	
	public void LayoutMenu() {
		
		
		JPanel mainPanel = new JPanel();
		GridLayout gridLayout = new GridLayout(0,1);
		gridLayout.setVgap(10);
		mainPanel.setLayout(gridLayout);
        mainPanel.add(new RowPanel("",requestReportButton));
        mainPanel.add(new RowPanel("",monitorReportsButton));
        mainPanel.add(new RowPanel("",reportsHistoryButton));
        
        JPanel contentPane = new JPanel();
      	contentPane.setLayout(new BorderLayout());
      	contentPane.add(mainPanel, BorderLayout.CENTER);
              
              
        contentPane.setBorder(new EmptyBorder(20, 35, 15, 35));
        setContentPane(contentPane);
	
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
	public void requestReport() throws Exception {
		System.out.println("Requesting Report");
		RequestReport report_request = new RequestReport(MenuFrame.this, this.currentuser);
		report_request.setVisible(true);
		//dispose();
	}
	public void monitorReport() throws Exception {
		System.out.println("Monitor Report");
		MonitorFrame monitor = new MonitorFrame(MenuFrame.this, this.currentuser);
		monitor.setVisible(true);
		//dispose();
	}
	
	public void myReportHistory() throws Exception{
		System.out.println("History Frame");
		HistoryFrame history = new HistoryFrame(MenuFrame.this, this.currentuser);
		history.setVisible(true);	
	}
	
	private class RowPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		private Component right;
		
		RowPanel(String label, Component right){
			this.right = right;
			layoutComponents();
		}
		
		private void layoutComponents(){
			right.setPreferredSize(new Dimension(250, 25));
			
			setLayout(new BorderLayout());
			add(right, BorderLayout.CENTER);
		}
	}
}
