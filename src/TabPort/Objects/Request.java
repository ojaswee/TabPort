package TabPort.Objects;

import java.sql.Date;

public class Request {

	public Integer queueID; //same as queueID
	public String userID; 
	public String username; 
	public String department;
	
	
	public String report;
	public String process;
	
	public String document;
	
	public String status;
	
	public Date date;

	
	public Request(String userID, String username, String department, String report, String process,
			String document, String status, Date date) {
		// TODO Auto-generated constructor stub
		
		this.userID = userID;
		this.username = username;
		this.department = department;
		this.report = report;
		this.process = process;
		this.document = document;
		this.status = status;
		this.date = date;
	}
	public Request(int queueID, String userID, String username, String department, String report, String process,
			String document, String status, Date date) {
		// TODO Auto-generated constructor stub
		
		this.queueID = queueID;
		this.userID = userID;
		this.username = username;
		this.department = department;
		this.report = report;
		this.process = process;
		this.document = document;
		this.status = status;
		this.date = date;
		
		
	}
	public Integer getrequestID() {
		return queueID;
	}

	public void setrequestID(Integer requestID) {
		this.queueID = requestID;
	}

	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
