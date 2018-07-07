package TabPort.Main;

import TabPort.GUI.LoginFrame;

public class Home {

	public static void main(String[] args) throws Exception {
		
		
		LoginFrame homeFrame = new LoginFrame();
		homeFrame.setTitle("TabPort - Reporting Application");
		homeFrame.setSize(500, 300);
		homeFrame.setLocationRelativeTo(null);
		homeFrame.setVisible(true);
		homeFrame.setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);

	}

}
