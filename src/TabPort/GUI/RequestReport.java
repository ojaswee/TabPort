package TabPort.GUI;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import TabPort.Connections.DatabaseConnections;
import TabPort.Objects.Request;
import TabPort.Objects.User;
import javafx.scene.control.DatePicker;

public class RequestReport extends JDialog{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField userIDTextField;//userID will be autofillied
	private JTextField departmentTextField;//dept get from user log in
	
	private JComboBox reportComboBox; // auto fill from database by looking at users dept
	private JComboBox processComboBox;
	
	private JTextField fileIDTextField; // input given by IT eg EI072018
    
	private JButton submitRequestButton;
	
	private MenuFrame parent;
	
	public User currentuser;
    
	public RequestReport(MenuFrame parent, User currentuser) throws Exception {
		
		super(parent,"Request Report");
		this.parent = parent;
		this.currentuser = currentuser;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		createComponents();
		layoutComponents();
		activateComponents();
		
		pack(); // need to pack all components and display
		setModalityType(ModalityType.APPLICATION_MODAL);
		setAlwaysOnTop(true);
		setResizable(false);
        setLocationRelativeTo(parent);
        
        setUserDepartment();
        setReportsbyDepartment();
        setProcess();
             
	}
	
	private void createComponents(){
				
		userIDTextField = new JTextField();
		departmentTextField= new JTextField();
		
		reportComboBox = new JComboBox();
		processComboBox = new JComboBox();
		
		fileIDTextField = new JTextField();
		
		submitRequestButton = new JButton("Submit");
		submitRequestButton.setFont(GUICommonTools.TAHOMA_BOLD_13);
	} 
	
	private void layoutComponents(){
		
		JPanel mainPanel = new JPanel();
		GridLayout gridLayout = new GridLayout(0,1);
		gridLayout.setVgap(10);
		mainPanel.setLayout(gridLayout);
        mainPanel.add(new RowPanel("Name ", userIDTextField));
        mainPanel.add(new RowPanel("Department", departmentTextField));
        mainPanel.add(new RowPanel("Report", reportComboBox));
        mainPanel.add(new RowPanel("Process", processComboBox));
        mainPanel.add(new RowPanel("FileID", fileIDTextField));
        
        
        JPanel southPanel = new JPanel();
		GridLayout southGridLayout = new GridLayout(1,0);
		southGridLayout.setHgap(30);
		southPanel.setLayout(southGridLayout);
        southPanel.add(submitRequestButton);
        
        JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(mainPanel, BorderLayout.CENTER);
        contentPane.add(southPanel, BorderLayout.SOUTH);
        
        
        contentPane.setBorder(new EmptyBorder(20, 35, 15, 35));
        setContentPane(contentPane);

	}
	
	private void activateComponents(){
		
		submitRequestButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					reportSubmission();
					
				}catch (Exception e){
					JOptionPane.showMessageDialog(RequestReport.this, e.getMessage());
				}
			}
		});
	}
		
	private void setUserDepartment(){
	
	    userIDTextField.setText(currentuser.getUserName());
	    userIDTextField.setEnabled(false);
	    departmentTextField.setText(currentuser.getDepartment());
	    departmentTextField.setEnabled(false);
	}
	
	private void setReportsbyDepartment() throws Exception {
		
		ArrayList<String> reports = DatabaseConnections.getReportByDepartment(currentuser.getUserName());
		
		for(int i =0; i < reports.size(); i++){
			reportComboBox.addItem(reports.get(i));
//			processComboBox.addItem(reports.get(i));
       }
	}
	
	private void setProcess() throws Exception {
		
		ArrayList<String> reports = DatabaseConnections.getProcess(currentuser.getUserName());
		
		for(int i =0; i < reports.size(); i++){
			processComboBox.addItem(reports.get(i));
       }
	}
	
	private void reportSubmission() throws Exception{
		
		
		String userID = currentuser.getUserID();
		String username = userIDTextField.getText();
		String department = departmentTextField.getText();
		
		String report = reportComboBox.getSelectedItem().toString();
		String process = processComboBox.getSelectedItem().toString();
		
		String document = fileIDTextField.getText();
		
		String status = "queued";
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		Request newrequest = new Request(userID,currentuser.getUserName(),department,report, process, document, status,date);
		
		boolean success = DatabaseConnections.insertReportRequest(newrequest);
		
		if (success) {
			
			JOptionPane.showMessageDialog(null,"Report Submitted");
		}
		else {
			JOptionPane.showMessageDialog(null,"Error");
			
		}
	}
	
	private class RowPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		private JLabel left;
		private Component right;
		
		RowPanel(String label, Component right){
			this.left = new JLabel(label);
			this.right = right;
			layoutComponents();
		}
		
		private void layoutComponents(){
			left.setFont(GUICommonTools.TAHOMA_BOLD_14);
			left.setPreferredSize(new Dimension(150, 25));
			
			right.setPreferredSize(new Dimension(250, 25));
			
			setLayout(new BorderLayout());
			add(left, BorderLayout.WEST);
			add(right, BorderLayout.CENTER);
		}
	}
}