package TabPort.GUI;


import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import TabPort.Connections.DatabaseConnections;
import TabPort.Objects.Request;
import TabPort.Objects.User;

public class MonitorFrame extends JDialog  {
	
	private static final long serialVersionUID = 1L;

	private JButton btnRefresh;

	

	//Table
	private JTable table;
	
	private RequestReportTableModel tableModel;
	
	
    private JScrollPane tableScrollPane;
	
	
    private TableRowSorter<RequestReportTableModel> sorter;
 
	
	private MenuFrame parent;
	
	public User currentuser;
    
	public MonitorFrame(MenuFrame parent, User currentuser) throws Exception {
		super(parent, "Monitor Report(s)");
		
		this.parent = parent;
		this.currentuser = currentuser;
		
		tableModel = new RequestReportTableModel();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		createComponents();
		layoutComponents();
		activateComponents();
		
		pack(); // need to pack all components and display
		setModalityType(ModalityType.APPLICATION_MODAL);
		setAlwaysOnTop(true);
		setResizable(false);
        setLocationRelativeTo(parent);
        
        buildModelFromDatabase(); 
	}
	
	
	
	public void createComponents(){
		
		table = new JTable(tableModel);

		table.setAutoCreateRowSorter(true);

		//sorter = new TableRowSorter<RequestReportTableModel>(tableModel);
		table.setRowSorter(sorter);

		//by default, sort from newest to oldest
//		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
//		sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
//		sorter.setSortKeys(sortKeys);
//		sorter.sort();

		tableScrollPane = new JScrollPane();
		tableScrollPane.setViewportView(table);

		btnRefresh = new JButton("Refresh");
        btnRefresh.setFont(GUICommonTools.TAHOMA_BOLD_12);
		
		
	}
	
	private void layoutComponents(){
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(59)
						.addComponent(btnRefresh)
						.addGap(127))
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(20)
						.addComponent(tableScrollPane, GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
						.addGap(20))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(25)
						.addComponent(btnRefresh)
						.addGap(25)
						.addComponent(tableScrollPane, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
						.addGap(25))
				);
		
		getContentPane().setLayout(groupLayout);

        resizeColumnWidths();
		
	}
	
	public void resizeColumnWidths() {
		TableColumnModel columnModel = table.getColumnModel();    

		for (int column = 0; column < table.getColumnCount(); column++) {
			TableColumn tableColumn = columnModel.getColumn(column);

			TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
			Component headerComp = headerRenderer.getTableCellRendererComponent(table, tableColumn.getHeaderValue(), false, false, 0, 0);

			int minWidth = headerComp.getPreferredSize().width;
			int maxWidth = 150;

			int width = minWidth;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 25 , width);
			}
			width = Math.min(maxWidth, width);
			columnModel.getColumn(column).setPreferredWidth(width);
		}
}
	
	private void activateComponents(){
		
	}
	
	private void buildModelFromDatabase() throws Exception {
		
		tableModel.resetModel();
		
	
		ArrayList<Request> requests = DatabaseConnections.getAllRequests(currentuser.getUserID());
		
			
		for(Request r : requests) {
			
			System.out.println(r.getUserName());
			
			tableModel.addRequest(r);
		}
		
		
	}
	
		
}
