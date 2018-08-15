package TabPort.Connections;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.table.DefaultTableModel;

import TabPort.GUI.MenuFrame;
import TabPort.Main.Home;
import TabPort.Objects.Request;
import TabPort.Objects.User;


public class DatabaseConnections {
	
    private static Connection databaseConnection = null;
	   
	public static void connect () throws Exception{
		
		   String driver = "com.mysql.cj.jdbc.Driver";
	       String dbuser ="root";
		   String dbpasswd="root";
		   String db="tabport";
		   String url="jdbc:mysql://localhost/"+db + "?useSSL=false";
		   
		   try {
		   Class.forName(driver);
		   databaseConnection = DriverManager.getConnection(url, dbuser, dbpasswd);
		   }catch (Exception e) {
			   throw new Exception("mysql connection error "+ e.getMessage());
		   }
		   
	}
		 
	public static boolean connectLogin(String userName, String passwd) throws Exception{
		connect();
		boolean success = false;
		try {
			String query = "SELECT * FROM users where username ='"+userName+"'AND password ='"+passwd +"';";
		    PreparedStatement pstm = databaseConnection.prepareStatement(query);
		    ResultSet rs = pstm.executeQuery();
		    
		    if(rs.next()){
				success=true;
	           }
		    }
		catch (Exception e) {
		   throw new Exception("mysql connection error "+ e.getMessage());
		   }
		return success;
    }
	
	public static User getUserInfo(String userName) throws Exception{
		
		User user = null;

		String query = "SELECT t1.userID,t1.username, t2.departmentname From users as t1 join department as t2 on t1.departmentID = t2.departmentID where username='"+userName + "';";
	    PreparedStatement pstm = databaseConnection.prepareStatement(query);
	    ResultSet rs = pstm.executeQuery();

	    if(rs.next()){
	    	
	    	user = new User(rs.getString(1).toString(),rs.getString(2),rs.getString(3));
	    	pstm.close();
	    }
	    return user;
	}
	
	public static ArrayList<String> getReportByDepartment(String userName) throws Exception{
		
		ArrayList<String> reports = new ArrayList<String>();
		//TODO check the name of departmentID

		String query = "select reportname from report where departmentID in (select departmentID from users where username='" + userName + "');";
	    PreparedStatement pstm = databaseConnection.prepareStatement(query);
	    ResultSet rs = pstm.executeQuery();

	    while(rs.next()){
	    	System.out.println(rs.getString(1));
	    	reports.add(rs.getString(1));
	    }
		
		return reports;
	}
	
	public static ArrayList<String> getProcess(String userName) throws Exception{
		
		ArrayList<String> reports = new ArrayList<String>();
		//TODO check the name of departmentID

		String query = "select processname from process;";
	    PreparedStatement pstm = databaseConnection.prepareStatement(query);
	    ResultSet rs = pstm.executeQuery();

	    while(rs.next()){
	    	System.out.println(rs.getString(1));
	    	reports.add(rs.getString(1));
	    }
		
		return reports;
	}
	
	public static boolean insertReportRequest(Request request) throws Exception{
		
		
		String userID = request.getUserID();
		String username = request.getUserName();
		String department = request.getDepartment();
		String report = request.getReport();
		String process = request.getProcess();
		String document = request.getDocument();		
		String status = request.getStatus();
		Date date = request.getDate();
		
		String queueRequest = String.format("INSERT INTO queue " 
				+ "(userID,username,department,report,process,document,status,date)"
				+	" VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
				userID, username, department, report, process, document, status,date);

		
		PreparedStatement preparedStatement = databaseConnection.prepareStatement(queueRequest);
		preparedStatement.executeUpdate();

		return true;
	}
    
	
	private static Request getRequest(ResultSet row) throws SQLException{
		Request request = new Request(
				row.getInt("queueID"),
				row.getString("userID"),
				row.getString("username"),
				row.getString("department"),
				row.getString("report"),
				row.getString("process"),
				row.getString("document"),				
				row.getString("status"),
				row.getDate("date")
				);
		return request;
	}

	public static ArrayList<Request> getAllRequestsMonitor(String userID, String department) throws Exception{
		String query = "Select * from queue where department = '" + department +"'AND status "
				+ "NOT IN ('Complete', 'Error');" ;
		PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		
		
		ArrayList<Request> requests = new ArrayList<Request>();

		while(rs.next()){
			Request r = getRequest(rs);
			requests.add(r);
		}
		preparedStatement.close();

		return requests;
	}
	
	public static ArrayList<Request> getAllRequestsHistory(String userID, String department) throws Exception{
//		String query = "select * from queue; " ;
		String query = "Select * from queue where department = '" + department +"'AND status "
				+ "NOT IN ('Running', 'Queued');" ;
		PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		
		
		ArrayList<Request> requests = new ArrayList<Request>();

		while(rs.next()){
			Request r = getRequest(rs);
			requests.add(r);
		}
		preparedStatement.close();

		return requests;
	}
}
