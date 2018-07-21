package TabPort.GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HistoryFrame extends JFrame{
	static DefaultTableModel model = new DefaultTableModel();
	Container cnt = this.getContentPane();
	static JTable jtbl = new JTable(model);
	private JButton exittButton;
	
	private JPanel panel;    
	
	public HistoryFrame() {
		super("History");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HistoryComponents();
		LayoutHistory();
		activateComponents();
	}
	private void HistoryComponents(){
		panel = new JPanel();
		exittButton = new JButton("Exit");

	}
	public void LayoutHistory() {
		setSize(440, 345);
		panel.setLayout(null);
		exittButton.setBounds(150, 214, 150, 23);
		
		panel.add(exittButton);
		
		add(panel);
		
	}
	private void activateComponents(){
		exittButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		});
		}
}