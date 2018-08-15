package TabPort.GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import TabPort.Objects.Request;

public class HistoryTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Request> requests;
	private ArrayList<HistoryTableModelColumn> columns;

	public HistoryTableModel(){
		this.requests = new ArrayList<Request>();
		constructColumns();
		
	}
		private void constructColumns(){
			columns = new ArrayList<HistoryTableModelColumn>();
			
			columns.add(new HistoryTableModelColumn("The Queue ID",
					"queueID",
					Integer.class,
					(Request request) -> request.queueID));
			
			columns.add(new HistoryTableModelColumn("The user ID",
					"userID",
					String.class,
					(Request request) -> request.userID));

			columns.add(new HistoryTableModelColumn("The user name",
					"username",
					String.class,
					(Request request) -> request.username));

			columns.add(new HistoryTableModelColumn("The sample used",
					"department",
					String.class,
					(Request request) -> request.department));

			columns.add(new HistoryTableModelColumn("The assay used", 
					"report", 
					String.class,
					(Request request) -> request.report));


			columns.add(new HistoryTableModelColumn("The instrument used", 
					"process", 
					String.class,
					(Request request) -> request.process));


			columns.add(new HistoryTableModelColumn("The environment used", 
					"document", 
					String.class,
					(Request request) -> request.document));

			columns.add(new HistoryTableModelColumn("The pipeline status", 
					"status", 
					String.class,
					(Request request) -> request.status));

			columns.add(new HistoryTableModelColumn("The runtime of pipeline", 
					"date", 
					String.class,
					(Request request) -> request.date));


			}
		public Request getRequest(int row){
			return requests.get(row);
		}

		public void resetModel() {
			requests.clear();
			fireTableDataChanged();
		}
		
		public void addRequest(Request request){
			requests.add(request);
			fireTableRowsInserted(requests.size()-1, requests.size()-1);
		}

		@Override 
		public boolean isCellEditable(int row, int column) {
			return false;
		}

		@Override
		public Class<?> getColumnClass(int column) {
			return columns.get(column).columnClass;
		}

		@Override
		public int getColumnCount() {
			return columns.size();
		}

		@Override
		public int getRowCount() {
			return requests.size();
		}

		@Override
		public String getColumnName(int column) {
			return columns.get(column).title;
		}

		@Override
		public Object getValueAt(int row, int column) {
			Request request = requests.get(row);
			return columns.get(column).getValue(request);
		}

		public String getColumnDescription(int column){
			return columns.get(column).description;
		}

}