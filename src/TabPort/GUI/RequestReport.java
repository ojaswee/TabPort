package TabPort.GUI;

import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javafx.scene.control.DatePicker;

public class RequestReport extends JFrame{
	private JPanel panel;
	private JTextField userIDTextField;//userID will be autofillied
	private JTextField departmentTextField;//dept get from user log in
	private JComboBox reportComboBx; // auto fill from database by looking at users dept
	private JTextField processIDTextField;
	private JTextField subProcessTextField;
	private JTextField fileTextField; // input given by IT eg EI072018
    private JButton submitRequestButton;
    
	public RequestReport() {
		super("Request Report");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents();
		ReportRequestComponents();
//		activateComponents();
	}
	
	private void createComponents(){
		panel = new JPanel();
		submitRequestButton = new JButton("Submit");
		userIDTextField = new JTextField();
		departmentTextField= new JTextField();
		reportComboBx = new JComboBox();
		processIDTextField = new JTextField();
		subProcessTextField = new JTextField();
		fileTextField = new JTextField();
	} 
	
	private void ReportRequestComponents(){
		setSize(400, 300);
		panel.setLayout(null);
		
		JLabel lblUserID = new JLabel("User ID");
		//lblUsername.setFont(GUICommonTools.TAHOMA_BOLD_14);
		lblUserID.setBounds(20, 25, 150, 33);
		
		userIDTextField.setBounds(70, 25, 100, 30);
		userIDTextField.setColumns(10);
				
		JLabel lbldepartment = new JLabel("Department");
		//lblPassword.setFont(GUICommonTools.TAHOMA_BOLD_14);
		lbldepartment.setBounds(180, 25, 100, 30);
		departmentTextField.setBounds(260, 25, 100, 30);
		departmentTextField.setColumns(10);
		
		String[] test = {"Select a report","Top Employee", "Top Training", "Most involved Department"};
		reportComboBx.setSize(400,300);
		reportComboBx = new JComboBox(test);
		reportComboBx.setSelectedIndex(0);
		reportComboBx.addActionListener(reportComboBx);
		reportComboBx.setBounds(30, 70, 200, 30);
				
		JLabel lblprocessID = new JLabel("Process ID");
		lblprocessID.setBounds(30, 120, 150, 14);
		
		processIDTextField.setBounds(120, 115, 120, 30);
		processIDTextField.setColumns(10);
		
		JLabel lblsubProcessID = new JLabel("Subprocess ID");
		lblsubProcessID.setBounds(30, 160, 150, 14);
		
		subProcessTextField.setBounds(120, 160, 120, 30);
		subProcessTextField.setColumns(10);
		
		submitRequestButton.setBounds(180, 214, 89, 23);
				
		panel.add(lblUserID);
		panel.add(userIDTextField);
		panel.add(lbldepartment);
		panel.add(departmentTextField);
		panel.add(reportComboBx);
		panel.add(lblprocessID);
		panel.add(processIDTextField);
		panel.add(lblsubProcessID);
		panel.add(subProcessTextField);
		
		panel.add(submitRequestButton);
		add(panel);
		getRootPane().setDefaultButton(submitRequestButton);
	}
}