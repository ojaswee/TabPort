package TabPort.GUI;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import TabPort.Connections.DatabaseConnections;



public class LoginFrame extends JFrame {
	
	private JPanel panel;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
    private JButton loginButton;
    
    
    public static void main(String[] args) {
		
				LoginFrame window = new LoginFrame();
				window.setVisible(true);
				window.setResizable(false);
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		super("TabPort Login");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents();
		layoutLoginComponents();
		activateComponents();
	}

	private void createComponents(){
		panel = new JPanel();
		loginButton = new JButton("Login");
		usernameTextField = new JTextField();
		passwordTextField = new JPasswordField();
	}
	
	private void layoutLoginComponents(){
		setSize(440, 345);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName");
		//lblUsername.setFont(GUICommonTools.TAHOMA_BOLD_14);
		lblUsername.setBounds(72, 71, 101, 33);
		
		JLabel lblPassword = new JLabel("Password");
		//lblPassword.setFont(GUICommonTools.TAHOMA_BOLD_14);
		lblPassword.setBounds(72, 145, 74, 14);
		
		usernameTextField.setBounds(160, 74, 142, 30);
		usernameTextField.setColumns(10);
		
		passwordTextField.setBounds(160, 139, 142, 30);
		
		//loginButton.setFont(GUICommonTools.TAHOMA_BOLD_14);
		loginButton.setBounds(181, 214, 89, 23);
		
		panel.add(lblUsername);
		panel.add(usernameTextField);
		panel.add(lblPassword);
		panel.add(passwordTextField);
		panel.add(loginButton);
		add(panel);
		getRootPane().setDefaultButton(loginButton);
		
		//Rectangle bounds = GUICommonTools.getBounds(this);
		//setLocation(bounds.width/2-getSize().width/2, bounds.height/2-getSize().height/2);
	}
	
	private void activateComponents(){
		loginButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					login();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		});
	}
	
	private void login() throws Exception{
		String userName= usernameTextField.getText();
		String passwd = new String(passwordTextField.getPassword());
		DatabaseConnections.connectLogin(userName, passwd); 
		
	
	    System.out.println("LogIn successful");
		
}

}
